package com.musala.atmosphere.commons.websocket.util;

import java.io.Serializable;
import java.lang.reflect.Type;

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
    public static final String KEY = "mKey";

    public static final String VALUE = "mValue";

    @Override
    public Pack deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        Pack pack = new Pack();

        JsonObject jsonObject = json.getAsJsonObject();
        JsonElement contents = jsonObject.get("contents");

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
                    String typeName = elementValue.getAsJsonObject().get(KEY).getAsString();
                    try {
                        Class<?> objectClass = Class.forName(typeName);
                        JsonElement objectValue = elementValue.getAsJsonObject().get(VALUE);
                        Serializable serializableObject = context.deserialize(objectValue, objectClass);

                        pack.putSerializable(key, serializableObject);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }

        }

        return pack;
    }

}
