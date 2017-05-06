package com.musala.atmosphere.websocket.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.musala.atmosphere.commons.RoutingAction;
import com.musala.atmosphere.commons.geometry.Bounds;
import com.musala.atmosphere.commons.geometry.Point;
import com.musala.atmosphere.commons.ui.tree.AccessibilityElement;
import com.musala.atmosphere.commons.util.Pair;

/**
 * TODO: Add a javadoc
 *
 * @author dimcho.nedev
 *
 */
public class CollectionsDeserialziationTest extends BaseDataSerialization {
    @SuppressWarnings("unchecked")
    @Test
    public void stringListResponseDataDeserializationTest() {
        List<String> commands = new ArrayList<String>();
        commands.add("first");
        commands.add("second");

        List<String> deserializedResponseData = (List<String>) getExpectedResponseData(RoutingAction.EXECUTE_SHELL_COMMAND_SEQUENCE,
                                                                                       commands);

        Assert.assertEquals(2, deserializedResponseData.size());
        Assert.assertEquals("first", deserializedResponseData.get(0));
        Assert.assertEquals("second", deserializedResponseData.get(1));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void stringSetDataDeserializerTest() {
        Set<String> set = new HashSet<String>(Arrays.asList("one", "two", "three"));

        Set<String> deserializedResponseData = (Set<String>) getExpectedResponseData(RoutingAction.GET_WEB_VIEWS, set);

        Assert.assertEquals(3, deserializedResponseData.size());
        Assert.assertEquals(set, deserializedResponseData);
    }

    // Check whether Map<String, Object> is used only as Map<String, String>
    @SuppressWarnings("unchecked")
    @Test
    public void listOfMapDataDeserializerTest() {
        List<Map<String, Object>> listOfMaps = new ArrayList<Map<String, Object>>();
        Map<String, Object> firstMap = new HashMap<String, Object>();
        Map<String, Object> secondMap = new HashMap<String, Object>();

        firstMap.put("first", "first_value");
        firstMap.put("second", "second_value");
        secondMap.put("third", "third_value");
        listOfMaps.add(firstMap);
        listOfMaps.add(secondMap);

        List<Map<String, Object>> deserializedResponseData = (List<Map<String, Object>>) getExpectedResponseData(RoutingAction.FIND_WEB_ELEMENTS,
                                                                                                                 listOfMaps);

        Assert.assertEquals("first_value", (deserializedResponseData.get(0).get("first")));
        Assert.assertEquals("second_value", (deserializedResponseData.get(0).get("second")));
        Assert.assertEquals("third_value", (deserializedResponseData.get(1).get("third")));
    }

    // Check whether Map<String, Object> is used only as Map<String, String>
    @SuppressWarnings("unchecked")
    @Test
    public void mapDataDeserializerTest() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("first", "first_value");
        map.put("second", "second_value");
        map.put("third", "third_value");

        Map<String, Object> deserializedResponseData = (Map<String, Object>) getExpectedResponseData(RoutingAction.FIND_WEB_ELEMENT,
                                                                                                     map);

        Assert.assertEquals("first_value", deserializedResponseData.get("first"));
        Assert.assertEquals("second_value", (deserializedResponseData.get("second")));
        Assert.assertEquals("third_value", (deserializedResponseData.get("third")));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void listOfAccessibilityElementsDeserializerTest() {
        AccessibilityElement firstElement = new AccessibilityElement();
        AccessibilityElement seconfElement = new AccessibilityElement();
        AccessibilityElement thirdElement = new AccessibilityElement();

        firstElement.setPath(TEST_PATH);
        seconfElement.setEnabled(true);
        thirdElement.setBounds(new Bounds(new Point(0, 0), new Point(4, 4)));

        List<AccessibilityElement> list = Arrays.asList(firstElement, seconfElement, thirdElement);

        List<AccessibilityElement> deserializedResponseData = (List<AccessibilityElement>) getExpectedResponseData(RoutingAction.GET_UI_ELEMENTS,
                                                                                                                   list);

        AccessibilityElement actualFirstElement = deserializedResponseData.get(0);
        AccessibilityElement actualSecondElement = deserializedResponseData.get(1);
        AccessibilityElement actualThirdElement = deserializedResponseData.get(2);

        Assert.assertEquals(TEST_PATH, actualFirstElement.getPath());
        Assert.assertEquals(3, deserializedResponseData.size());
        Assert.assertTrue(actualSecondElement.isEnabled());
        Assert.assertEquals(2, actualThirdElement.getBounds().getCenter().getX());
        Assert.assertEquals(2, actualThirdElement.getBounds().getCenter().getY());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void listOfPairsDeserializerTest() {
        Pair<Integer, String> firstPair = new Pair<Integer, String>(1, "first_value");
        Pair<Integer, String> secondPair = new Pair<Integer, String>(2, "second_value");
        Pair<Integer, String> thirdPair = new Pair<Integer, String>(3, "third_value");

        List<Pair<Integer, String>> list = Arrays.asList(firstPair, secondPair, thirdPair);

        List<Pair<Integer, String>> deserializedResponseData = (List<Pair<Integer, String>>) getExpectedResponseData(RoutingAction.GET_LOGCAT_BUFFER,
                                                                                                                     list);
        Assert.assertEquals(3, deserializedResponseData.size());
        Assert.assertEquals(firstPair, deserializedResponseData.get(0));
        Assert.assertEquals(secondPair, deserializedResponseData.get(1));
        Assert.assertEquals(thirdPair, deserializedResponseData.get(2));
    }
}
