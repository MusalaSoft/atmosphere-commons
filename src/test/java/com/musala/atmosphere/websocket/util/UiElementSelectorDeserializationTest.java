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
public class UiElementSelectorDeserializationTest extends CustomDataDeserializationTest {
    @Test
    public void uiElementSelectorDeserializatinTest() {
        String jsonMessage = "{\"arguments\":[{\"mKey\":\"com.musala.atmosphere.commons.ui.selector.UiElementSelector\","
                + "\"mValue\":{\"attributeProjectionMap\":{\"CLASS_NAME\":{\"mKey\":\"android.widget.NumberPicker\","
                + "\"mValue\":\"EQUALS\"},\"INDEX\":{\"mKey\":1,\"mValue\":\"EQUALS\"}}}},{\"mKey\":\"java.lang.Boolean\",\"mValue\":true}],"
                + "\"messageAction\":\"ROUTING_ACTION\",\"routingAction\":\"GET_UI_ELEMENTS\","
                + "\"deviceId\":\"59A57D012B068B4B0D227342EEA9262E_01d04ee91317a4d6\",\"sessionId\":\"726363d4-23b0-4125-b5cf-f411c3d89139\"}";

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
        String jsonRequest = "{\"arguments\":[{\"mKey\":\"com.musala.atmosphere.commons.ui.selector.UiElementSelector\","
                + "\"mValue\":{\"attributeProjectionMap\":{\"TEXT\":{\"mValue\":\"EQUALS\"}}}},{\"mKey\":\"java.lang.Boolean\","
                + "\"mValue\":true}],\"messageAction\":\"ROUTING_ACTION\",\"routingAction\":\"GET_UI_ELEMENTS\","
                + "\"deviceId\":\"59A57D012B068B4B0D227342EEA9262E_01d04ee91317a4d6\","
                + "\"sessionId\":\"b132e1f7-a24a-4991-bcab-a29f37485147\"}";

        RequestMessage requestMessage = jsonUtil.deserializeRequest(jsonRequest);

        UiElementSelector selector = (UiElementSelector) requestMessage.getArguments()[0];

        Assert.assertNull(selector.getText());
        Assert.assertTrue((Boolean) requestMessage.getArguments()[1]);
    }
}
