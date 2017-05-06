package com.musala.atmosphere.commons.websocket.util.serializer;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.musala.atmosphere.commons.RoutingAction;
import com.musala.atmosphere.commons.websocket.message.MessageAction;
import com.musala.atmosphere.commons.websocket.message.RequestMessage;
import com.musala.atmosphere.commons.websocket.util.JsonConst;

/**
 * Serializer for the {@link RequestMessage} object.
 *
 * @author dimcho.nedev
 *
 */
public class RequestMessageSerializer implements JsonSerializer<RequestMessage> {

    @Override
    public JsonElement serialize(RequestMessage request, Type type, JsonSerializationContext context) {
        Object[] argument = request.getArguments();
        MessageAction messageAction = request.getMessageAction();
        RoutingAction routingAction = request.getRoutingAction();
        String agentId = request.getAgentId();
        String deviceId = request.getDeviceId();
        String sessionId = request.getSessionId();
        Long passkey = request.getPasskey();
        boolean async = request.isAsync();

        JsonObject requestJson = new JsonObject();
        JsonArray jsonArray = new JsonArray();

        for (Object arg : argument) {
            JsonObject pair = new JsonObject();

            if (arg != null) {
                pair.addProperty(JsonConst.KEY, arg.getClass().getName());
                pair.add(JsonConst.VALUE, context.serialize(arg));
            }

            jsonArray.add(pair);
        }

        requestJson.add(JsonConst.ARGUMENTS, jsonArray);

        if (messageAction != null) {
            requestJson.addProperty(JsonConst.MESSAGE_ACTION, messageAction.toString());
        }
        if (routingAction != null) {
            requestJson.addProperty(JsonConst.ROUTING_ACTION, routingAction.toString());
        }
        if (passkey != null) {
            requestJson.addProperty(JsonConst.DEVICE_PASSKEY, passkey);
        }
        if (agentId != null) {
            requestJson.addProperty(JsonConst.AGENT_ID, agentId);
        }
        if (deviceId != null) {
            requestJson.addProperty(JsonConst.DEVICE_ID, deviceId);
        }
        if (sessionId != null) {
            requestJson.addProperty(JsonConst.SESSION_ID, sessionId);
        }
        if(async) {
            requestJson.addProperty(JsonConst.ASYNC, async);
        }

        return requestJson;
    }

}
