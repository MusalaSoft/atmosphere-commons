package com.musala.atmosphere.commons.websocket.util.serializer;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.musala.atmosphere.commons.RoutingAction;
import com.musala.atmosphere.commons.websocket.message.MessageAction;
import com.musala.atmosphere.commons.websocket.message.ResponseMessage;
import com.musala.atmosphere.commons.websocket.util.JsonConst;

/**
 * Serializer for the {@link ResponseMessage} object.
 *
 * @author dimcho.nedev
 *
 */
public class ResponseMessageSeriazlizer implements JsonSerializer<ResponseMessage> {

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
        jsonResponse.add(JsonConst.MESSAGE_ACTION, context.serialize(messageAction));

        // Add a routing action
        jsonResponse.add(JsonConst.ROUTING_ACTION, context.serialize(routingAction));

        // Add a data
        if (data != null) {
            JsonObject dataJson = new JsonObject();
            dataJson.addProperty(JsonConst.KEY, data.getClass().getName());
            dataJson.add(JsonConst.VALUE, context.serialize(data));
            jsonResponse.add(JsonConst.DATA, dataJson);
        }

        // Add an agent ID
        jsonResponse.addProperty(JsonConst.AGENT_ID, agentId);

        // Add a session ID
        jsonResponse.addProperty(JsonConst.SESSION_ID, sessionId);

        // Add a device ID
        jsonResponse.addProperty(JsonConst.DEVICE_ID, deviceId);

        // Add an exception
        if (exception != null) {
            JsonObject exceptionJson = new JsonObject();
            exceptionJson.addProperty(JsonConst.KEY, exception.getClass().getName());
            exceptionJson.add(JsonConst.VALUE, context.serialize(exception));
            jsonResponse.add(JsonConst.EXCEPTION, exceptionJson);
        }

        return jsonResponse;
    }

}
