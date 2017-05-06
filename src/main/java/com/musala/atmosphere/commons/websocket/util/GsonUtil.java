package com.musala.atmosphere.commons.websocket.util;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.musala.atmosphere.commons.RoutingAction;
import com.musala.atmosphere.commons.ui.selector.UiElementSelector;
import com.musala.atmosphere.commons.ui.tree.AccessibilityElement;
import com.musala.atmosphere.commons.util.Pack;
import com.musala.atmosphere.commons.util.Pair;
import com.musala.atmosphere.commons.util.structure.tree.Tree;
import com.musala.atmosphere.commons.websocket.message.MessageAction;
import com.musala.atmosphere.commons.websocket.message.RequestMessage;
import com.musala.atmosphere.commons.websocket.message.ResponseMessage;

/**
 * Represents a concrete implementation of serialize/deserialize messages.
 *
 * @author dimcho.nedev
 *
 */
public class GsonUtil implements IJsonUtil {
    private final static Logger LOGGER = Logger.getLogger(GsonUtil.class);

    private static Gson g = new GsonBuilder().enableComplexMapKeySerialization()
                                             .registerTypeHierarchyAdapter(Pack.class, new PackDeserializer())
                                             .registerTypeHierarchyAdapter(UiElementSelector.class,
                                                                           new UiElementSelectorDeserializer())
                                             .create();

    @Override
    public String serialize(RequestMessage requestMessage) {
        String jsonMessage = g.toJson(requestMessage);

        return jsonMessage;
    }

    @Override
    public String serialize(ResponseMessage responseMessage) {
        String jsonMessage = g.toJson(responseMessage);

        return jsonMessage;
    }

    @Override
    public ResponseMessage deserializeResponse(String jsonMessage) {
        ResponseMessage responseMessage = g.fromJson(jsonMessage, ResponseMessage.class);

        MessageAction messageAction = responseMessage.getMessageAction();
        Type type = null;

        switch (messageAction) {
            case ROUTING_ACTION:
                RoutingAction routingAction = responseMessage.getRoutingAction();
                type = resolveTypeForRoutingAction(responseMessage, routingAction);
                break;
            default:
                LOGGER.error("The message action is not recognized.");
                break;
        }

        if (type != null) {
            JsonObject jsonObject = g.fromJson(jsonMessage, JsonObject.class);
            JsonElement responseData = jsonObject.get("data");

            responseMessage.setData(g.fromJson(responseData, type));
        }

        if (responseMessage.getException() != null) {
            String exceptionTypeName = responseMessage.getExceptionTypeName();
            try {
                Type exceptionType = Class.forName(exceptionTypeName);

                JsonObject jsonObject = g.fromJson(jsonMessage, JsonObject.class);
                JsonElement exceptionData = jsonObject.get("exception");
                Exception e = g.fromJson(exceptionData, exceptionType);
                responseMessage.setException(e);
            } catch (ClassNotFoundException e) {
                // TODO: Error message, exception
                e.printStackTrace();
            }
        }

        return responseMessage;
    }

    private Type resolveTypeForRoutingAction(ResponseMessage responseMessage, RoutingAction routingAction) {
        Type type = null;

        switch (routingAction) {
            case EXECUTE_SHELL_COMMAND_SEQUENCE:
                type = new TypeToken<List<String>>() {
                }.getType();
                break;
            case GET_SCREENSHOT:
            case GET_DEVICE_LOGCAT:
                type = new TypeToken<byte[]>() {
                }.getType();
                break;
            case GET_UI_TREE:
                type = new TypeToken<Tree<AccessibilityElement>>() {
                }.getType();
                break;
            case GET_UI_ELEMENTS:
            case GET_CHILDREN:
            case EXECUTE_XPATH_QUERY_ON_LOCAL_ROOT:
            case EXECUTE_XPATH_QUERY:
                type = new TypeToken<List<AccessibilityElement>>() {
                }.getType();
                break;
            case GET_LOGCAT_BUFFER:
                type = new TypeToken<List<Pair<Integer, String>>>() {
                }.getType();
                break;
            case GET_WEB_VIEWS:
                type = new TypeToken<Set<String>>() {
                }.getType();
                break;
            case FIND_WEB_ELEMENT:
                type = new TypeToken<Map<String, Object>>() {
                }.getType();
                break;
            case FIND_WEB_ELEMENTS:
                type = new TypeToken<List<Map<String, Object>>>() {
                }.getType();
                break;
            case WEB_ELEMENT_ACTION:
                if (responseMessage.getTypeName() != null
                        && responseMessage.getTypeName().equals(Pair.class.getName())) {
                    type = new TypeToken<Pair<Integer, Integer>>() {
                    }.getType();
                    break;
                }
            default:
                try {
                    type = Class.forName(responseMessage.getTypeName());
                } catch (ClassNotFoundException e) {
                    // TODO: Error message, exception
                    e.printStackTrace();
                } catch (NullPointerException e1) {
                    // nothing to do here
                }
                break;
        }

        return type;
    }

    @Override
    public Object getProperty(String jsonMessage, String propertyName, Class<?> clazz) {
        JsonObject jsonObject = g.fromJson(jsonMessage, JsonObject.class);
        JsonElement propertyElement = jsonObject.get(propertyName);
        Object propertyData = g.fromJson(propertyElement, clazz);

        return propertyData;
    }

    @Override
    public RequestMessage deserializeRequest(String jsonMessage) {
        RequestMessage requestMessage = g.fromJson(jsonMessage, RequestMessage.class);
        String[] typeNames = requestMessage.getTypeNames();

        JsonObject jsonObject = g.fromJson(jsonMessage, JsonObject.class);
        JsonArray responseData = jsonObject.get("arguments").getAsJsonArray();

        Object[] newObjects = new Object[typeNames.length];

        for (int i = 0; i < responseData.size(); i++) {
            try {
                if (typeNames[i] != null) {
                    newObjects[i] = g.fromJson(responseData.get(i), Class.forName(typeNames[i]));
                }
            } catch (JsonSyntaxException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
        }

        requestMessage.setArguments(newObjects);

        return requestMessage;
    }

}
