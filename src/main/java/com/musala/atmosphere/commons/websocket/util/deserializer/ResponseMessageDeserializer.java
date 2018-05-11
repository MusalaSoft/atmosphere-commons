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

package com.musala.atmosphere.commons.websocket.util.deserializer;

import static com.musala.atmosphere.commons.websocket.util.JsonConst.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.musala.atmosphere.commons.RoutingAction;
import com.musala.atmosphere.commons.ui.tree.AccessibilityElement;
import com.musala.atmosphere.commons.util.Pair;
import com.musala.atmosphere.commons.util.structure.tree.Tree;
import com.musala.atmosphere.commons.websocket.message.MessageAction;
import com.musala.atmosphere.commons.websocket.message.ResponseMessage;

/**
 * Deserializer for the {@link ResponseMessage} object.
 *
 * @author dimcho.nedev
 *
 */
public class ResponseMessageDeserializer implements JsonDeserializer<ResponseMessage> {
    private final static Logger LOGGER = Logger.getLogger(ResponseMessageDeserializer.class);

    @Override
    public ResponseMessage deserialize(JsonElement json, Type srcType, JsonDeserializationContext context)
        throws JsonParseException {
        ResponseMessage responseMessage = new ResponseMessage();
        JsonObject jsonResponse = json.getAsJsonObject();

        MessageAction messageAction = context.deserialize(jsonResponse.get(MESSAGE_ACTION), MessageAction.class);
        RoutingAction routingAction = context.deserialize(jsonResponse.get(ROUTING_ACTION), RoutingAction.class);
        String agentId = getPropertyString(AGENT_ID, jsonResponse);
        String sessionId = getPropertyString(SESSION_ID, jsonResponse);
        String deviceId = getPropertyString(DEVICE_ID, jsonResponse);

        // Sets an exception to the response
        JsonElement pair = jsonResponse.get(EXCEPTION);
        if (pair != null) {
            String exceptionClassName = pair.getAsJsonObject().get(KEY).getAsString();
            JsonElement exceptionElement = pair.getAsJsonObject().get(VALUE);
            try {
                Exception exception = context.deserialize(exceptionElement, Class.forName(exceptionClassName));
                responseMessage.setException(exception);
            } catch (ClassNotFoundException e) {
                LOGGER.error(String.format(FAILED_TO_FIND_CLASS, exceptionClassName), e);
            }
        }

        // Sets a data to the response
        JsonElement dataElement = jsonResponse.get(DATA);

        if (dataElement != null) {
            JsonElement typeElement = dataElement.getAsJsonObject().get(KEY);
            JsonElement dataValue = dataElement.getAsJsonObject().get(VALUE);
            Type type = resolveTypeForRoutingAction(typeElement, messageAction, routingAction);
            Object data = context.deserialize(dataValue, type);

            responseMessage.setData(data);
        }

        responseMessage.setMessageAction(messageAction);
        responseMessage.setRoutingAction(routingAction);
        responseMessage.setAgentId(agentId);
        responseMessage.setSessionId(sessionId);
        responseMessage.setDeviceId(deviceId);

        return responseMessage;
    }

    private String getPropertyString(String property, JsonObject jsonResponse) {
        JsonElement element = jsonResponse.get(property);
        return element != null ? element.getAsString() : null;
    }

    /**
     * Resolves the types of the arguments in some non-trivial cases (e. g. collections). Creates a {@link TypeToken}
     * according the {@link MessageAction} and {@link RoutingAction} of the response.
     */
    private Type resolveTypeForRoutingAction(JsonElement typeElement,
                                             MessageAction messageAction,
                                             RoutingAction routingAction) {
        Type type = null;

        switch (messageAction) {
            case ROUTING_ACTION:
                type = resolve(typeElement, routingAction);
                break;
            case DEVICE_ALLOCATION_INFORMATION:
                type = defaultResolver(typeElement);
                break;
            case GET_ALL_AVAILABLE_DEVICES:
                type = new TypeToken<List<Pair<String, String>>>() {}.getType();
                break;
            default:
                LOGGER.error("The message action is not recognized.");
                break;
        }

        return type;
    }

    private Type resolve(JsonElement typeElement, RoutingAction routingAction) {
        Type type = null;

        switch (routingAction) {
            case EXECUTE_SHELL_COMMAND_SEQUENCE:
                type = new TypeToken<List<String>>() {}.getType();
                break;
            case GET_UI_TREE:
                type = new TypeToken<Tree<AccessibilityElement>>() {}.getType();
                break;
            case GET_UI_ELEMENTS:
            case GET_CHILDREN:
            case EXECUTE_XPATH_QUERY_ON_LOCAL_ROOT:
            case EXECUTE_XPATH_QUERY:
                type = new TypeToken<List<AccessibilityElement>>() {}.getType();
                break;
            case GET_LOGCAT_BUFFER:
                type = new TypeToken<List<Pair<Integer, String>>>() {}.getType();
                break;
            case GET_WEB_VIEWS:
                type = new TypeToken<Set<String>>() {}.getType();
                break;
            case FIND_WEB_ELEMENT:
                type = new TypeToken<Map<String, Object>>() {}.getType();
                break;
            case FIND_WEB_ELEMENTS:
                type = new TypeToken<List<Map<String, Object>>>() {}.getType();
                break;
            case WEB_ELEMENT_ACTION:
                boolean isEmptyType = !typeElement.equals(new JsonObject());
                boolean isPair = typeElement.getAsString().equals(Pair.class.getName());

                if (isEmptyType && isPair) {
                    type = new TypeToken<Pair<Integer, Integer>>() {}.getType();
                    break;
                }
            default:
                type = defaultResolver(typeElement);
                break;
        }

        return type;
    }

    private Type defaultResolver(JsonElement typeElement) {
        Type type = null;
        String className = typeElement.getAsString();
        try {
            type = Class.forName(className);
        } catch (ClassNotFoundException e) {
            LOGGER.error(String.format(FAILED_TO_FIND_CLASS, className), e);
        } catch (NullPointerException e1) {
            // nothing to do here
        }

        return type;
    }

}
