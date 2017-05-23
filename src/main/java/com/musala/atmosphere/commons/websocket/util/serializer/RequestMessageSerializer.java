package com.musala.atmosphere.commons.websocket.util.serializer;

import static com.musala.atmosphere.commons.websocket.util.JsonConst.AGENT_ID;
import static com.musala.atmosphere.commons.websocket.util.JsonConst.ARGUMENTS;
import static com.musala.atmosphere.commons.websocket.util.JsonConst.ASYNC;
import static com.musala.atmosphere.commons.websocket.util.JsonConst.DEVICE_ID;
import static com.musala.atmosphere.commons.websocket.util.JsonConst.DEVICE_PASSKEY;
import static com.musala.atmosphere.commons.websocket.util.JsonConst.KEY;
import static com.musala.atmosphere.commons.websocket.util.JsonConst.MESSAGE_ACTION;
import static com.musala.atmosphere.commons.websocket.util.JsonConst.ROUTING_ACTION;
import static com.musala.atmosphere.commons.websocket.util.JsonConst.SESSION_ID;
import static com.musala.atmosphere.commons.websocket.util.JsonConst.VALUE;

import java.lang.reflect.Type;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.musala.atmosphere.commons.RoutingAction;
import com.musala.atmosphere.commons.websocket.message.MessageAction;
import com.musala.atmosphere.commons.websocket.message.RequestMessage;

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
                pair.addProperty(KEY, arg.getClass().getName());
                pair.add(VALUE, context.serialize(arg));
            }

            jsonArray.add(pair);
        }

        requestJson.add(ARGUMENTS, jsonArray);

        if (messageAction != null) {
            requestJson.addProperty(MESSAGE_ACTION, messageAction.toString());
        }
        if (routingAction != null) {
            requestJson.addProperty(ROUTING_ACTION, routingAction.toString());
        }
        if (passkey != null) {
            requestJson.addProperty(DEVICE_PASSKEY, passkey);
        }
        if (agentId != null) {
            requestJson.addProperty(AGENT_ID, agentId);
        }
        if (deviceId != null) {
            requestJson.addProperty(DEVICE_ID, deviceId);
        }
        if (sessionId != null) {
            requestJson.addProperty(SESSION_ID, sessionId);
        }
        if (async) {
            requestJson.addProperty(ASYNC, async);
        }

        return requestJson;
    }

}
