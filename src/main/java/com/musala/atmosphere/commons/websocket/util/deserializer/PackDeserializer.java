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

package com.musala.atmosphere.commons.websocket.util.deserializer;

import static com.musala.atmosphere.commons.websocket.util.JsonConst.*;

import java.io.Serializable;
import java.lang.reflect.Type;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.musala.atmosphere.commons.util.Pack;

/**
 * Deserializer for the {@link Pack} object.
 *
 * @author dimcho.nedev
 *
 */
public class PackDeserializer implements JsonDeserializer<Pack> {
    private final static Logger LOGGER = Logger.getLogger(RequestMessageDeserializer.class);

    @Override
    public Pack deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        Pack pack = new Pack();

        JsonObject jsonObject = json.getAsJsonObject();
        JsonElement contents = jsonObject.get(CONTENTS);

        if (contents.equals(new JsonObject())) {
            // empty contents map: {}
            return pack;
        }

        JsonArray contentsJsonArray = contents.getAsJsonArray();

        for (JsonElement contentsElement : contentsJsonArray) {
            JsonArray elementAsJsonArray = contentsElement.getAsJsonArray();

            JsonElement elementKey = elementAsJsonArray.get(0);
            JsonElement elementValue = elementAsJsonArray.get(1);
            JsonElement mKey = elementKey.getAsJsonObject().get(KEY);
            JsonElement mValue = elementKey.getAsJsonObject().get(VALUE);

            String key = mKey.getAsString();
            String valueTypeName = mValue.getAsString();
            Pack.ValueType valueType = Pack.ValueType.valueOf(valueTypeName);

            switch (valueType) {
                case STRING:
                    pack.putString(key, elementValue.getAsString());
                    break;
                case LONG:
                    pack.putLong(key, elementValue.getAsLong());
                    break;
                case BOOLEAN:
                    pack.putBoolean(key, elementValue.getAsBoolean());
                    break;
                case FLOAT:
                    pack.putFloat(key, elementValue.getAsFloat());
                    break;
                case DOUBLE:
                    pack.putDouble(key, elementValue.getAsDouble());
                    break;
                case INTEGER:
                    pack.putInt(key, elementValue.getAsInt());
                    break;
                case CHARACTER:
                    pack.putChar(key, elementValue.getAsCharacter());
                    break;
                case SHORT:
                    pack.putShort(key, elementValue.getAsShort());
                    break;
                case BYTE:
                    pack.putByte(key, elementValue.getAsByte());
                    break;
                case SERIALIZABLE:
                    String className = elementValue.getAsJsonObject().get(KEY).getAsString();
                    try {
                        Class<?> objectClass = Class.forName(className);
                        JsonElement objectValue = elementValue.getAsJsonObject().get(VALUE);
                        Serializable serializableObject = context.deserialize(objectValue, objectClass);

                        pack.putSerializable(key, serializableObject);
                    } catch (ClassNotFoundException e) {
                        LOGGER.error(String.format(FAILED_TO_FIND_CLASS, className), e);
                    }
                    break;
                default:
                    break;
            }

        }

        return pack;
    }

}
