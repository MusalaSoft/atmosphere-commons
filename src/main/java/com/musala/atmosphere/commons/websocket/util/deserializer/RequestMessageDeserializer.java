package com.musala.atmosphere.commons.websocket.util.deserializer;

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
import com.musala.atmosphere.commons.websocket.util.JsonConst;

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
        JsonElement agentIdElement = jsonObject.get(JsonConst.AGENT_ID);
        JsonElement deviceIdElement = jsonObject.get(JsonConst.DEVICE_ID);
        JsonElement sessionIdElement = jsonObject.get(JsonConst.SESSION_ID);
        JsonElement passkeyElement = jsonObject.get(JsonConst.DEVICE_PASSKEY);
        JsonElement asyncElement = jsonObject.get(JsonConst.ASYNC);

        MessageAction messageAction = context.deserialize(jsonObject.get(JsonConst.MESSAGE_ACTION),
                                                          MessageAction.class);
        RoutingAction routingAction = context.deserialize(jsonObject.get(JsonConst.ROUTING_ACTION),
                                                          RoutingAction.class);
        String agentId = agentIdElement != null ? agentIdElement.getAsString() : null;
        String deviceId = deviceIdElement != null ? deviceIdElement.getAsString() : null;
        String sessionId = sessionIdElement != null ? sessionIdElement.getAsString() : null;
        Long passkey = passkeyElement != null ? passkeyElement.getAsLong() : null;
        boolean isAsync = asyncElement != null ? true : false;

        JsonArray jsonArguments = jsonObject.get(JsonConst.ARGUMENTS).getAsJsonArray();
        Object[] arguments = new Object[jsonArguments.size()];

        for (int i = 0; i < jsonArguments.size(); i++) {

            if (!jsonArguments.get(i).equals(new JsonObject())) {
                String className = jsonArguments.get(i).getAsJsonObject().get(JsonConst.KEY).getAsString();
                JsonElement jsonValue = jsonArguments.get(i).getAsJsonObject().get(JsonConst.VALUE);
                try {
                    Object value = context.deserialize(jsonValue, Class.forName(className));
                    arguments[i] = value;
                } catch (ClassNotFoundException e) {
                    LOGGER.error(String.format(JsonConst.FAILED_TO_FIND_CLASS, className), e);
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

}
