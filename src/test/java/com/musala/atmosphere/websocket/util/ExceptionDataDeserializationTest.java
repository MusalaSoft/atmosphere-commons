package com.musala.atmosphere.websocket.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.musala.atmosphere.commons.RoutingAction;
import com.musala.atmosphere.commons.exceptions.AtmosphereConfigurationException;
import com.musala.atmosphere.commons.exceptions.CommandFailedException;
import com.musala.atmosphere.commons.webelement.exception.WebElementNotPresentException;
import com.musala.atmosphere.commons.websocket.message.MessageAction;
import com.musala.atmosphere.commons.websocket.message.ResponseMessage;

/**
 * Test the deserialization of the the {@link Exception exception} data after a serialization.
 *
 * @author dimcho.nedev
 *
 */
public class ExceptionDataDeserializationTest extends BaseDataSerialization {
    public static final String EXCEPTION_MESSAGE = "Exception Message";

    @Test
    public void exceptionDataDeserializerTest() throws Exception {
        ResponseMessage responseMessage = new ResponseMessage(MessageAction.ROUTING_ACTION,
                                                              RoutingAction.GET_LOGCAT_BUFFER,
                                                              null);
        WebElementNotPresentException expectedExcpetion = new WebElementNotPresentException(EXCEPTION_MESSAGE);
        StackTraceElement[] ste = new StackTraceElement[3];
        ste[0] = new StackTraceElement("declaringClass_1", "methodName_1", "fileName_1", 1);
        ste[1] = new StackTraceElement("declaringClass_2", "methodName_2", "fileName_2", 2);
        ste[2] = new StackTraceElement("declaringClass_3", "methodName_3", "fileName_3", 2);
        expectedExcpetion.setStackTrace(ste);
        expectedExcpetion.initCause(new RuntimeException("cause"));
        responseMessage.setException(expectedExcpetion);

        String jsonResponse = jsonUtil.serialize(responseMessage);

        ResponseMessage deserializedResponse = jsonUtil.deserializeResponse(jsonResponse);
        Exception actualException = deserializedResponse.getException();

        Assert.assertArrayEquals(ste, actualException.getStackTrace());
        Assert.assertEquals(actualException.getMessage(), EXCEPTION_MESSAGE);
        Assert.assertEquals(WebElementNotPresentException.class, actualException.getClass());
        Assert.assertEquals(actualException.getCause().getMessage(), expectedExcpetion.getCause().getMessage());
        Assert.assertArrayEquals(actualException.getStackTrace(), expectedExcpetion.getStackTrace());
    }

    @Test(expected = AtmosphereConfigurationException.class)
    public void throwDeserializedExcpetionTest() throws Exception {
        ResponseMessage responseMessage = new ResponseMessage(MessageAction.ROUTING_ACTION,
                                                              RoutingAction.GET_LOGCAT_BUFFER,
                                                              null);
        AtmosphereConfigurationException expectedExcpetion = new AtmosphereConfigurationException(EXCEPTION_MESSAGE);
        responseMessage.setException(expectedExcpetion);
        String jsonResponse = jsonUtil.serialize(responseMessage);

        ResponseMessage deserializedResponse = jsonUtil.deserializeResponse(jsonResponse);

        Exception actualException = deserializedResponse.getException();

        Assert.assertEquals(EXCEPTION_MESSAGE, actualException.getMessage());
        Assert.assertEquals(AtmosphereConfigurationException.class, actualException.getClass());

        throw actualException;
    }

    @Test(expected=CommandFailedException.class)
    public void responseWithExceptionDataDeserializationTest() throws Exception {
        ResponseMessage responseMessage = new ResponseMessage(MessageAction.ROUTING_ACTION, RoutingAction.GET_WEB_VIEWS, "aaa");
        responseMessage.setException(new CommandFailedException(EXCEPTION_MESSAGE));
        Set<String> set = new HashSet<String>(Arrays.asList("1", "2", "3"));
        responseMessage.setData(set);

        String json = jsonUtil.serialize(responseMessage);

        ResponseMessage response = jsonUtil.deserializeResponse(json);

        Assert.assertEquals(MessageAction.ROUTING_ACTION, response.getMessageAction());
        Assert.assertEquals(RoutingAction.GET_WEB_VIEWS, response.getRoutingAction());
        Assert.assertNull(response.getAgentId());
        Assert.assertEquals(EXCEPTION_MESSAGE, response.getException().getMessage());
        Assert.assertEquals(CommandFailedException.class, response.getException().getClass());

        Assert.assertEquals(set, response.getData());

        throw response.getException();

    }
}
