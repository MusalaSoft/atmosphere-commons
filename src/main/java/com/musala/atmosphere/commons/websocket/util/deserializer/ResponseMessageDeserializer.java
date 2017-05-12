package com.musala.atmosphere.commons.websocket.util.deserializer;

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
import com.musala.atmosphere.commons.websocket.util.JsonConst;

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

        MessageAction messageAction = context.deserialize(jsonResponse.get(JsonConst.MESSAGE_ACTION),
                                                          MessageAction.class);
        RoutingAction routingAction = context.deserialize(jsonResponse.get(JsonConst.ROUTING_ACTION),
                                                          RoutingAction.class);
        String agentId = jsonResponse.get(JsonConst.AGENT_ID) != null
                ? jsonResponse.get(JsonConst.AGENT_ID).getAsString() : null;
        String sessionId = jsonResponse.get(JsonConst.SESSION_ID) != null
                ? jsonResponse.get(JsonConst.SESSION_ID).getAsString() : null;

        // Sets an exception to the response
        JsonElement pair = jsonResponse.get(JsonConst.EXCEPTION);
        if (pair != null) {
            String exceptionClassName = pair.getAsJsonObject().get(JsonConst.KEY).getAsString();
            JsonElement exceptionElement = pair.getAsJsonObject().get(JsonConst.VALUE);
            try {
                Exception exception = context.deserialize(exceptionElement, Class.forName(exceptionClassName));
                responseMessage.setException(exception);
            } catch (ClassNotFoundException e) {
                LOGGER.error(String.format(JsonConst.FAILED_TO_FIND_CLASS, exceptionClassName), e);
            }
        }

        // Sets a data to the response
        JsonElement dataElement = jsonResponse.get(JsonConst.DATA);

        if (dataElement != null) {
            JsonElement typeElement = dataElement.getAsJsonObject().get(JsonConst.KEY);
            JsonElement dataTa = dataElement.getAsJsonObject().get(JsonConst.VALUE);
            Type type = resolveTypeForRoutingAction(typeElement, messageAction, routingAction);
            Object data = context.deserialize(dataTa, type);

            responseMessage.setData(data);
        }

        responseMessage.setMessageAction(messageAction);
        responseMessage.setRoutingAction(routingAction);
        responseMessage.setAgentId(agentId);
        responseMessage.setSessionId(sessionId);

        return responseMessage;
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
            case GET_SCREENSHOT:
            case GET_DEVICE_LOGCAT:
                type = new TypeToken<byte[]>() {}.getType();
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
                String className = typeElement.getAsString();
                try {
                    type = Class.forName(className);
                } catch (ClassNotFoundException e) {
                    LOGGER.error(String.format(JsonConst.FAILED_TO_FIND_CLASS, className), e);
                } catch (NullPointerException e1) {
                    // nothing to do here
                }
                break;
        }

        return type;
    }

}
