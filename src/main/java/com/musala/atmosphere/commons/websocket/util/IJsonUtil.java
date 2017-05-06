package com.musala.atmosphere.commons.websocket.util;

import com.musala.atmosphere.commons.websocket.message.RequestMessage;
import com.musala.atmosphere.commons.websocket.message.ResponseMessage;

/**
 * Represents commonly used actions for JSON serialization/deserialization.
 *
 * @author dimcho.nedev
 *
 */
public interface IJsonUtil {
    /**
     * Serializes {@link RequestMessage} request message.
     *
     * @param requestMessage
     *        - the request message
     * @return the request message as JSON string
     */
    public String serialize(RequestMessage requestMessage);

    /**
     * Serializes {@link ResponseMessage} request message.
     *
     * @param responseMessage
     *        - the request message
     * @return the response message as JSON string
     */
    public String serialize(ResponseMessage responseMessage);

    /**
     * Deserializes a JSON string as a {@link ResponseMessage} response message.
     *
     * @param jsonMessage
     * @return the deserialized {@link ResponseMessage} request message
     */
    public ResponseMessage deserializeResponse(String jsonMessage);

    /**
     * Deserializes a JSON string as a {@link RequestMessage} request message.
     *
     * @param jsonMessage
     * @return the deserialized {@link RequestMessage} request message
     */
    public RequestMessage deserializeRequest(String jsonMessage);

    /**
     * Gets the value of a specified property from a JSON string.
     *
     * @param jsonMessage
     *        - JSON message
     * @param propertyName
     *        - name of a property
     * @param type
     *        - the {@Class class} of the property
     * @return the value of the property as a {@link Java object}
     */
    public Object getProperty(String jsonMessage, String propertyName, Class<?> type);
}