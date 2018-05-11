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
     *        - JSON response message
     * @return the deserialized {@link ResponseMessage} response message
     */
    public ResponseMessage deserializeResponse(String jsonMessage);

    /**
     * Deserializes a JSON string as a {@link RequestMessage} request message.
     *
     * @param jsonMessage
     *        - JSON request message
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
     * @param clazz
     *        - the class of the property
     * @param <T> the type of the property
     * @return the value of the property
     */
    public <T> T getProperty(String jsonMessage, String propertyName, Class<T> clazz);
}
