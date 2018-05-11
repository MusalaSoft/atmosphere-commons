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
import com.musala.atmosphere.commons.websocket.message.MessageAction;
import com.musala.atmosphere.commons.websocket.message.ResponseMessage;

/**
 * Tests the deserialized response collection data after a serialization.
 *
 * @author dimcho.nedev
 *
 */
@SuppressWarnings("unchecked")
public class CollectionsDeserialziationTest extends DataSerializationTestBase {

    @Test
    public void stringListResponseDataDeserializationTest() {
        List<String> commands = new ArrayList<String>();
        commands.add("first");
        commands.add("second");

        List<String> deserializedResponseData = (List<String>) getExpectedResponseData(RoutingAction.EXECUTE_SHELL_COMMAND_SEQUENCE,
                                                                                       commands);
        Assert.assertEquals(commands, deserializedResponseData);
    }

    @Test
    public void stringSetDataDeserializerTest() {
        Set<String> set = new HashSet<String>(Arrays.asList("one", "two", "three"));

        Set<String> deserializedResponseData = (Set<String>) getExpectedResponseData(RoutingAction.GET_WEB_VIEWS, set);

        Assert.assertEquals(set, deserializedResponseData);
    }

    // Check whether Map<String, Object> is used only as Map<String, String>
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

        Assert.assertEquals(listOfMaps, deserializedResponseData);
    }

    // Check whether Map<String, Object> is used only as Map<String, String>
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

    @Test
    public void listOfAccessibilityElementsDeserializerTest() {
        AccessibilityElement firstElement = new AccessibilityElement();
        AccessibilityElement secondElement = new AccessibilityElement();
        AccessibilityElement thirdElement = new AccessibilityElement();

        firstElement.setPath(TestConst.TEST_PATH);
        secondElement.setEnabled(true);
        thirdElement.setBounds(new Bounds(new Point(0, 0), new Point(4, 4)));

        List<AccessibilityElement> list = Arrays.asList(firstElement, secondElement, thirdElement);

        List<AccessibilityElement> deserializedResponseData = (List<AccessibilityElement>) getExpectedResponseData(RoutingAction.GET_UI_ELEMENTS,
                                                                                                                   list);

        AccessibilityElement actualFirstElement = deserializedResponseData.get(0);
        AccessibilityElement actualSecondElement = deserializedResponseData.get(1);
        AccessibilityElement actualThirdElement = deserializedResponseData.get(2);

        Assert.assertEquals(TestConst.TEST_PATH, actualFirstElement.getPath());
        Assert.assertEquals(3, deserializedResponseData.size());
        Assert.assertTrue(actualSecondElement.isEnabled());
        Assert.assertEquals(2, actualThirdElement.getBounds().getCenter().getX());
        Assert.assertEquals(2, actualThirdElement.getBounds().getCenter().getY());
    }

    @Test
    public void listOfPairsDeserializerTest() {
        Pair<Integer, String> firstPair = new Pair<Integer, String>(1, "first_value");
        Pair<Integer, String> secondPair = new Pair<Integer, String>(2, "second_value");
        Pair<Integer, String> thirdPair = new Pair<Integer, String>(3, "third_value");

        List<Pair<Integer, String>> actualData = Arrays.asList(firstPair, secondPair, thirdPair);

        List<Pair<Integer, String>> deserializedResponseData = (List<Pair<Integer, String>>) getExpectedResponseData(RoutingAction.GET_LOGCAT_BUFFER,
                                                                                                                     actualData);
        Assert.assertEquals(actualData, deserializedResponseData);
    }

    @Test
    public void getAllAvailableDevicesDeserializationTest() {
        List<Pair<String, String>> list = new ArrayList<Pair<String,String>>();
        list.add(new Pair<String, String>("key_1", "value_1"));
        list.add(new Pair<String, String>("key_2", "value_2"));
        list.add(new Pair<String, String>("key_3", "value_3"));
        ResponseMessage response = new ResponseMessage(MessageAction.GET_ALL_AVAILABLE_DEVICES, null, list);
        ResponseMessage expected = jsonUtil.deserializeResponse(jsonUtil.serialize(response));

        Assert.assertEquals(list, ((List<Pair<String, String>>)expected.getData()));
        Assert.assertEquals(response.getMessageAction(), expected.getMessageAction());
        Assert.assertNull(expected.getRoutingAction());
    }

}
