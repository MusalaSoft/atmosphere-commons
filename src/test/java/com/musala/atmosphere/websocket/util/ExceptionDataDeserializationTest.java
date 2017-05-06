package com.musala.atmosphere.websocket.util;

import org.junit.Assert;
import org.junit.Test;

import com.musala.atmosphere.commons.RoutingAction;
import com.musala.atmosphere.commons.exceptions.AtmosphereConfigurationException;
import com.musala.atmosphere.commons.webelement.exception.WebElementNotPresentException;
import com.musala.atmosphere.commons.websocket.message.MessageAction;
import com.musala.atmosphere.commons.websocket.message.ResponseMessage;

/**
 * TODO: Add a javadoc
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

        throw actualException;
    }
}
