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

package com.musala.atmosphere.websocket.util;

import org.junit.Assert;
import org.junit.Test;

import com.musala.atmosphere.commons.RoutingAction;
import com.musala.atmosphere.commons.geometry.Bounds;
import com.musala.atmosphere.commons.geometry.Point;
import com.musala.atmosphere.commons.ui.selector.CssAttribute;
import com.musala.atmosphere.commons.ui.selector.UiElementSelectionOption;
import com.musala.atmosphere.commons.ui.selector.UiElementSelector;
import com.musala.atmosphere.commons.websocket.message.RequestMessage;

/**
 * Tests the deserialization of the {@link UiElementSelector} data.
 *
 * @author dimcho.nedev
 *
 */
public class UiElementSelectorDeserializationTest extends DataSerializationTestBase {

    @Test
    public void uiElementSelectorDeserializatinTest() {
        String jsonMessage = readFile(jsonPath + "uiElementSelectorDeserializatinTest.txt");

        RequestMessage requestMessage = jsonUtil.deserializeRequest(jsonMessage);

        UiElementSelector uiElementSelector = (UiElementSelector) (requestMessage.getArguments()[0]);

        Assert.assertEquals(uiElementSelector.getClassName(), "android.widget.NumberPicker");
        Assert.assertEquals(uiElementSelector.getStringValue(CssAttribute.CLASS_NAME), "android.widget.NumberPicker");
        Assert.assertEquals(uiElementSelector.getStringValueWithSelectionOption(CssAttribute.CLASS_NAME).getKey(),
                            "android.widget.NumberPicker");
        Assert.assertEquals(uiElementSelector.getStringValueWithSelectionOption(CssAttribute.CLASS_NAME)
                                             .getValue()
                                             .name(),
                            "EQUALS");
        Assert.assertEquals(uiElementSelector.getIndex(), new Integer(1));
    }

    @Test
    public void uiElementSelectorDeserializationTest() {
        UiElementSelector selector = new UiElementSelector();

        // Integers
        selector.addSelectionAttribute(CssAttribute.INDEX, 108);
        // Strings
        selector.addSelectionAttribute(CssAttribute.CLASS_NAME, "class_name");
        selector.addSelectionAttribute(CssAttribute.TEXT, UiElementSelectionOption.WORD_MATCH, "[a-z]");
        selector.addSelectionAttribute(CssAttribute.CONTENT_DESCRIPTION,
                                       UiElementSelectionOption.CONTAINS,
                                       "description");
        selector.addSelectionAttribute(CssAttribute.PACKAGE_NAME, "package_name");
        selector.addSelectionAttribute(CssAttribute.RESOURCE_ID, "resource_id");
        // Booleans
        selector.addSelectionAttribute(CssAttribute.CHECKABLE, true);
        selector.addSelectionAttribute(CssAttribute.CHECKED, true);
        selector.addSelectionAttribute(CssAttribute.CLICKABLE, true);
        selector.addSelectionAttribute(CssAttribute.ENABLED, true);
        selector.addSelectionAttribute(CssAttribute.FOCUSABLE, true);
        selector.addSelectionAttribute(CssAttribute.FOCUSED, true);
        selector.addSelectionAttribute(CssAttribute.LONG_CLICKABLE, true);
        selector.addSelectionAttribute(CssAttribute.PASSWORD, true);
        selector.addSelectionAttribute(CssAttribute.SCROLLABLE, true);
        selector.addSelectionAttribute(CssAttribute.SELECTED, true);
        // Bounds
        Bounds bounds = new Bounds(new Point(10, 20), new Point(30, 40));
        selector.addSelectionAttribute(CssAttribute.BOUNDS, bounds);

        UiElementSelector result = (UiElementSelector) getExpectedResponseData(RoutingAction.SEND_BROADCAST, selector);

        // Asserts
        // Integers
        Assert.assertEquals(new Integer(108), result.getIndex());
        Assert.assertEquals(new Integer(108), result.getIntegerValue(CssAttribute.INDEX));
        // Strings
        Assert.assertEquals("class_name", result.getStringValue(CssAttribute.CLASS_NAME));
        Assert.assertEquals("[a-z]", result.getStringValue(CssAttribute.TEXT));
        Assert.assertEquals("description", result.getStringValue(CssAttribute.CONTENT_DESCRIPTION));
        Assert.assertEquals("package_name", result.getStringValue(CssAttribute.PACKAGE_NAME));
        // Booleans
        Assert.assertEquals(true, result.getBooleanValue(CssAttribute.CHECKABLE));
        Assert.assertEquals(true, result.getBooleanValue(CssAttribute.CHECKED));
        Assert.assertEquals(true, result.getBooleanValue(CssAttribute.CLICKABLE));
        Assert.assertEquals(true, result.getBooleanValue(CssAttribute.ENABLED));
        Assert.assertEquals(true, result.getBooleanValue(CssAttribute.FOCUSABLE));
        Assert.assertEquals(true, result.getBooleanValue(CssAttribute.FOCUSED));
        Assert.assertEquals(true, result.getBooleanValue(CssAttribute.LONG_CLICKABLE));
        Assert.assertEquals(true, result.getBooleanValue(CssAttribute.PASSWORD));
        Assert.assertEquals(true, result.getBooleanValue(CssAttribute.SCROLLABLE));
        Assert.assertEquals(true, result.getBooleanValue(CssAttribute.SELECTED));
        // Bounds
        Assert.assertEquals(bounds, result.getBounds());
    }

    @Test
    public void emptyUiElementSelectorDeserializationTest() {
        UiElementSelector selector = new UiElementSelector();

        UiElementSelector result = (UiElementSelector) getExpectedResponseData(RoutingAction.SEND_BROADCAST, selector);

        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void emptyUiElementSelectorAttributeDeserializationTest() {
        String jsonRequest = readFile(jsonPath + "emptyUiElementSelectorAttributeDeserializationTest.txt");

        RequestMessage requestMessage = jsonUtil.deserializeRequest(jsonRequest);

        UiElementSelector selector = (UiElementSelector) requestMessage.getArguments()[0];

        Assert.assertNull(selector.getText());
        Assert.assertTrue((Boolean) requestMessage.getArguments()[1]);
    }
}
