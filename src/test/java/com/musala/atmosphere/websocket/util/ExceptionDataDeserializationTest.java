// This file is part of the ATMOSPHERE mobile testing framework.
// Copyright (C) 2016 MusalaSoft
//
// ATMOSPHERE is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// ATMOSPHERE is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with ATMOSPHERE.  If not, see <http://www.gnu.org/licenses/>.

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
public class ExceptionDataDeserializationTest extends DataSerializationTestBase {
    public static final String EXCEPTION_MESSAGE = "Exception Message";

    @Test
    public void exceptionDataDeserializerTest() throws Exception {
        ResponseMessage responseMessage = new ResponseMessage(MessageAction.ROUTING_ACTION,
                                                              RoutingAction.GET_LOGCAT_BUFFER,
                                                              null);
        WebElementNotPresentException expectedException = new WebElementNotPresentException(EXCEPTION_MESSAGE);
        StackTraceElement[] ste = new StackTraceElement[3];
        ste[0] = new StackTraceElement("declaringClass_1", "methodName_1", "fileName_1", 1);
        ste[1] = new StackTraceElement("declaringClass_2", "methodName_2", "fileName_2", 2);
        ste[2] = new StackTraceElement("declaringClass_3", "methodName_3", "fileName_3", 2);
        expectedException.setStackTrace(ste);
        expectedException.initCause(new RuntimeException("cause"));
        responseMessage.setException(expectedException);

        String jsonResponse = jsonUtil.serialize(responseMessage);

        ResponseMessage deserializedResponse = jsonUtil.deserializeResponse(jsonResponse);
        Exception actualException = deserializedResponse.getException();

        Assert.assertArrayEquals(ste, actualException.getStackTrace());
        Assert.assertEquals(actualException.getMessage(), EXCEPTION_MESSAGE);
        Assert.assertEquals(WebElementNotPresentException.class, actualException.getClass());
        Assert.assertEquals(actualException.getCause().getMessage(), expectedException.getCause().getMessage());
        Assert.assertArrayEquals(actualException.getStackTrace(), expectedException.getStackTrace());
    }

    @Test(expected = AtmosphereConfigurationException.class)
    public void throwDeserializedExceptionTest() throws Exception {
        ResponseMessage responseMessage = new ResponseMessage(MessageAction.ROUTING_ACTION,
                                                              RoutingAction.GET_LOGCAT_BUFFER,
                                                              null);
        AtmosphereConfigurationException expectedException = new AtmosphereConfigurationException(EXCEPTION_MESSAGE);
        responseMessage.setException(expectedException);
        String jsonResponse = jsonUtil.serialize(responseMessage);

        ResponseMessage deserializedResponse = jsonUtil.deserializeResponse(jsonResponse);

        Exception actualException = deserializedResponse.getException();

        Assert.assertEquals(EXCEPTION_MESSAGE, actualException.getMessage());

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
        Assert.assertEquals(set, response.getData());

        throw response.getException();

    }
}
