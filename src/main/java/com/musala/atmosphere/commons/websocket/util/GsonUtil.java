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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.musala.atmosphere.commons.ui.selector.UiElementSelector;
import com.musala.atmosphere.commons.util.Pack;
import com.musala.atmosphere.commons.websocket.message.Message;
import com.musala.atmosphere.commons.websocket.message.RequestMessage;
import com.musala.atmosphere.commons.websocket.message.ResponseMessage;
import com.musala.atmosphere.commons.websocket.util.deserializer.PackDeserializer;
import com.musala.atmosphere.commons.websocket.util.deserializer.RequestMessageDeserializer;
import com.musala.atmosphere.commons.websocket.util.deserializer.ResponseMessageDeserializer;
import com.musala.atmosphere.commons.websocket.util.deserializer.UiElementSelectorDeserializer;
import com.musala.atmosphere.commons.websocket.util.serializer.RequestMessageSerializer;
import com.musala.atmosphere.commons.websocket.util.serializer.ResponseMessageSerializer;

/**
 * Represents a concrete implementation of the {@link IJsonUtil JSON util interface}. Responsible for
 * serialization/deserialization of all {@link Message messages} that have an argument/data belonging to the
 * atmosphere-commons project.
 *
 * @author dimcho.nedev
 *
 */
public class GsonUtil implements IJsonUtil {
    protected static GsonBuilder gsonBuilder;

    protected static Gson g;

    public GsonUtil() {
        gsonBuilder = new GsonBuilder().enableComplexMapKeySerialization();
        gsonBuilder.registerTypeHierarchyAdapter(Pack.class, new PackDeserializer());
        gsonBuilder.registerTypeHierarchyAdapter(UiElementSelector.class, new UiElementSelectorDeserializer());
        gsonBuilder.registerTypeHierarchyAdapter(RequestMessage.class, new RequestMessageSerializer());
        gsonBuilder.registerTypeHierarchyAdapter(RequestMessage.class, new RequestMessageDeserializer());
        gsonBuilder.registerTypeHierarchyAdapter(ResponseMessage.class, new ResponseMessageSerializer());
        gsonBuilder.registerTypeHierarchyAdapter(ResponseMessage.class, new ResponseMessageDeserializer());
        g = gsonBuilder.create();
    }

    @Override
    public String serialize(RequestMessage requestMessage) {
        return g.toJson(requestMessage);
    }

    @Override
    public String serialize(ResponseMessage responseMessage) {
        return g.toJson(responseMessage);
    }

    @Override
    public ResponseMessage deserializeResponse(String jsonMessage) {
        return g.fromJson(jsonMessage, ResponseMessage.class);
    }

    @Override
    public <T> T getProperty(String jsonMessage, String propertyName, Class<T> clazz) {
        JsonObject jsonObject = g.fromJson(jsonMessage, JsonObject.class);
        JsonElement propertyElement = jsonObject.get(propertyName);
        T propertyData = g.fromJson(propertyElement, clazz);

        return propertyData;
    }

    @Override
    public RequestMessage deserializeRequest(String jsonMessage) {
        return g.fromJson(jsonMessage, RequestMessage.class);
    }

}
