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

import java.lang.reflect.Type;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.musala.atmosphere.commons.geometry.Bounds;
import com.musala.atmosphere.commons.ui.selector.CssAttribute;
import com.musala.atmosphere.commons.ui.selector.UiElementSelectionOption;
import com.musala.atmosphere.commons.ui.selector.UiElementSelector;

/**
 * Deserializer for the {@link UiElementSelector} object.
 *
 * @author dimcho.nedev
 *
 */
public class UiElementSelectorDeserializer implements JsonDeserializer<UiElementSelector> {
    private final static Logger LOGGER = Logger.getLogger(UiElementSelectorDeserializer.class);

    @Override
    public UiElementSelector deserialize(JsonElement json, Type type, JsonDeserializationContext context)
        throws JsonParseException {
        UiElementSelector selector = new UiElementSelector();

        JsonObject jsonObject = json.getAsJsonObject();
        JsonElement attributeProjectionMap = jsonObject.get(ATTRIBUTE_PROJECTION_MAP);

        if (attributeProjectionMap.equals(new JsonObject())) {
            // empty attribute map: {}
            return selector;
        }

        LOGGER.debug(String.format("%s: %s", ATTRIBUTE_PROJECTION_MAP, attributeProjectionMap));

        Set<Entry<String, JsonElement>> set = attributeProjectionMap.getAsJsonObject().entrySet();

        for (Entry<String, JsonElement> entry : set) {
            LOGGER.debug(String.format("Key: %s, Value: %s", entry.getKey(), entry.getValue()));

            CssAttribute cssAttribute = CssAttribute.valueOf(entry.getKey());

            JsonElement key = entry.getValue().getAsJsonObject().get(KEY);
            if (key != null) {
                String optionName = entry.getValue().getAsJsonObject().get(VALUE).getAsString();
                UiElementSelectionOption option = UiElementSelectionOption.valueOf(optionName);

                switch (cssAttribute) {
                    case INDEX:
                        selector.addSelectionAttribute(cssAttribute, option, key.getAsInt());
                        break;
                    case CLASS_NAME:
                    case CONTENT_DESCRIPTION:
                    case PACKAGE_NAME:
                    case RESOURCE_ID:
                    case TEXT:
                        selector.addSelectionAttribute(cssAttribute, option, key.getAsString());
                        break;
                    case BOUNDS:
                        selector.addSelectionAttribute(cssAttribute, option, context.deserialize(key, Bounds.class));
                        break;
                    default:
                        selector.addSelectionAttribute(cssAttribute, option, key.getAsBoolean());
                        break;
                }
            }
        }

        return selector;
    }

}
