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

package com.musala.atmosphere.commons.websocket.util.serializer;

import static com.musala.atmosphere.commons.websocket.util.JsonConst.*;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.musala.atmosphere.commons.RoutingAction;
import com.musala.atmosphere.commons.websocket.message.MessageAction;
import com.musala.atmosphere.commons.websocket.message.ResponseMessage;

/**
 * Serializer for the {@link ResponseMessage} object.
 *
 * @author dimcho.nedev
 *
 */
public class ResponseMessageSerializer implements JsonSerializer<ResponseMessage> {

    @Override
    public JsonElement serialize(ResponseMessage response, Type type, JsonSerializationContext context) {
        MessageAction messageAction = response.getMessageAction();
        RoutingAction routingAction = response.getRoutingAction();
        Object data = response.getData();
        String agentId = response.getAgentId();
        Exception exception = response.getException();
        String sessionId = response.getSessionId();
        String deviceId = response.getDeviceId();

        JsonObject jsonResponse = new JsonObject();

        // add a message action
        jsonResponse.add(MESSAGE_ACTION, context.serialize(messageAction));

        // Add a routing action
        jsonResponse.add(ROUTING_ACTION, context.serialize(routingAction));

        // Add a data
        if (data != null) {
            JsonObject dataJson = new JsonObject();
            dataJson.addProperty(KEY, data.getClass().getName());
            dataJson.add(VALUE, context.serialize(data));
            jsonResponse.add(DATA, dataJson);
        }

        // Add an agent ID
        jsonResponse.addProperty(AGENT_ID, agentId);

        // Add a session ID
        jsonResponse.addProperty(SESSION_ID, sessionId);

        // Add a device ID
        jsonResponse.addProperty(DEVICE_ID, deviceId);

        // Add an exception
        if (exception != null) {
            JsonObject exceptionJson = new JsonObject();
            exceptionJson.addProperty(KEY, exception.getClass().getName());
            exceptionJson.add(VALUE, context.serialize(exception));
            jsonResponse.add(EXCEPTION, exceptionJson);
        }

        return jsonResponse;
    }

}
