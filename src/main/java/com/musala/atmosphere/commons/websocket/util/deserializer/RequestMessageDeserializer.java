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

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.musala.atmosphere.commons.RoutingAction;
import com.musala.atmosphere.commons.websocket.message.MessageAction;
import com.musala.atmosphere.commons.websocket.message.RequestMessage;

/**
 * Deserializer for the {@link RequestMessage} object.
 * 
 * @author dimcho.nedev
 *
 */
public class RequestMessageDeserializer implements JsonDeserializer<RequestMessage> {
    private final static Logger LOGGER = Logger.getLogger(RequestMessageDeserializer.class);

    @Override
    public RequestMessage deserialize(JsonElement json, Type type, JsonDeserializationContext context)
        throws JsonParseException {
        RequestMessage requestMessage = new RequestMessage();

        JsonObject jsonObject = json.getAsJsonObject();
        JsonElement passkeyElement = jsonObject.get(DEVICE_PASSKEY);
        JsonElement asyncElement = jsonObject.get(ASYNC);

        MessageAction messageAction = context.deserialize(jsonObject.get(MESSAGE_ACTION), MessageAction.class);
        RoutingAction routingAction = context.deserialize(jsonObject.get(ROUTING_ACTION), RoutingAction.class);
        String agentId = getPropertyString(AGENT_ID, jsonObject);
        String deviceId = getPropertyString(DEVICE_ID, jsonObject);
        String sessionId = getPropertyString(SESSION_ID, jsonObject);
        Long passkey = passkeyElement != null ? passkeyElement.getAsLong() : null;
        boolean isAsync = asyncElement != null ? true : false;

        JsonArray jsonArguments = jsonObject.get(ARGUMENTS).getAsJsonArray();
        Object[] arguments = new Object[jsonArguments.size()];

        for (int i = 0; i < jsonArguments.size(); i++) {
            if (!jsonArguments.get(i).equals(new JsonObject())) {
                String className = jsonArguments.get(i).getAsJsonObject().get(KEY).getAsString();
                JsonElement jsonValue = jsonArguments.get(i).getAsJsonObject().get(VALUE);
                try {
                    Object value = context.deserialize(jsonValue, Class.forName(className));
                    arguments[i] = value;
                } catch (ClassNotFoundException e) {
                    LOGGER.error(String.format(FAILED_TO_FIND_CLASS, className), e);
                }
            } else {
                arguments[i] = null;
            }
        }

        requestMessage.setMessageAction(messageAction);
        requestMessage.setRoutingAction(routingAction);
        requestMessage.setArguments(arguments);
        requestMessage.setAgentId(agentId);
        requestMessage.setDeviceId(deviceId);
        requestMessage.setSessionId(sessionId);
        requestMessage.setPasskey(passkey);
        requestMessage.setAsync(isAsync);

        return requestMessage;
    }

    private String getPropertyString(String property, JsonObject jsonRequest) {
        JsonElement element = jsonRequest.get(property);
        return element != null ? element.getAsString() : null;
    }

}
