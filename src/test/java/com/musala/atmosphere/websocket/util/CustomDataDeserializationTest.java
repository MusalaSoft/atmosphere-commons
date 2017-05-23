package com.musala.atmosphere.websocket.util;

import org.junit.Assert;
import org.junit.Test;

import com.musala.atmosphere.commons.DeviceInformation;
import com.musala.atmosphere.commons.RoutingAction;
import com.musala.atmosphere.commons.beans.DeviceAcceleration;
import com.musala.atmosphere.commons.geometry.Bounds;
import com.musala.atmosphere.commons.geometry.Point;
import com.musala.atmosphere.commons.ui.tree.AccessibilityElement;
import com.musala.atmosphere.commons.util.Pair;
import com.musala.atmosphere.commons.util.structure.tree.Node;
import com.musala.atmosphere.commons.util.structure.tree.Tree;
import com.musala.atmosphere.commons.websocket.message.MessageAction;
import com.musala.atmosphere.commons.websocket.message.RequestMessage;
import com.musala.atmosphere.commons.websocket.message.ResponseMessage;

/**
 * Tests the deserialization of the {@link ResponseMessage} custom response data
 *
 * @author dimcho.nedev
 *
 */
public class CustomDataDeserializationTest extends DataSerializationTestBase {

    @Test
    public void deviceInformationResponseDataDeserializationTest() {
        DeviceInformation deviceInformation = createDeviceInfoObject();

        DeviceInformation deserializedResponseData = (DeviceInformation) getExpectedResponseData(RoutingAction.GET_DEVICE_INFORMATION,
                                                                                                 deviceInformation);

        Assert.assertEquals(TestConst.DEVICE_API_LEVEL, deserializedResponseData.getApiLevel());
        Assert.assertEquals(deviceInformation.getResolution(), deserializedResponseData.getResolution());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void treeOfAccessibilityElementsResponseDataDeserializationTest() {
        // setup elements
        AccessibilityElement rootElement = new AccessibilityElement();
        AccessibilityElement firstChildElement = new AccessibilityElement();
        AccessibilityElement secondChildElement = new AccessibilityElement();
        AccessibilityElement childOfFirstChildElement = new AccessibilityElement();
        Bounds expectedBounds = new Bounds(new Point(0, 0), new Point(4, 4));

        rootElement.setPath(TestConst.TEST_PATH);
        firstChildElement.setText("first_child_text");
        secondChildElement.setEnabled(true);
        childOfFirstChildElement.setBounds(expectedBounds);

        // setup the nodes
        Node<AccessibilityElement> firstChildNode = new Node<AccessibilityElement>(firstChildElement);
        Node<AccessibilityElement> secondChildNode = new Node<AccessibilityElement>(secondChildElement);
        Node<AccessibilityElement> childOfFirstChildNode = new Node<AccessibilityElement>(childOfFirstChildElement);

        firstChildNode.addChild(childOfFirstChildNode);

        // setup the tree
        Tree<AccessibilityElement> tree = new Tree<AccessibilityElement>(rootElement);
        tree.getRoot().addChild(firstChildNode);
        tree.getRoot().addChild(secondChildNode);

        Tree<AccessibilityElement> deserializedResponseData = (Tree<AccessibilityElement>) getExpectedResponseData(RoutingAction.GET_UI_TREE,
                                                                                                                   tree);

        String rootActualPath = deserializedResponseData.getRoot().getData().getPath();
        int rootActualChildrenCount = deserializedResponseData.getRoot().getChildCount();
        Node<AccessibilityElement> actualFirstChild = deserializedResponseData.getRoot().getChildren().get(0);
        Node<AccessibilityElement> actualSecondChild = deserializedResponseData.getRoot().getChildren().get(1);
        String firstChildActualText = actualFirstChild.getData().getText();
        Boolean secondChildActualisEnabled = actualSecondChild.getData().isEnabled();
        Bounds actualBounds = actualFirstChild.getChild(0).getData().getBounds();

        // asserts
        Assert.assertEquals(TestConst.TEST_PATH, rootActualPath);
        Assert.assertEquals(2, rootActualChildrenCount);
        Assert.assertEquals("first_child_text", firstChildActualText);
        Assert.assertTrue(secondChildActualisEnabled);
        Assert.assertEquals(expectedBounds, actualBounds);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void pairOfIntegersDeserializationTest() {
        Pair<Integer, Integer> expectedPair = new Pair<Integer, Integer>(50, 90);

        Pair<Integer, Integer> actualPair = (Pair<Integer, Integer>) getExpectedResponseData(RoutingAction.WEB_ELEMENT_ACTION,
                                                                                             expectedPair);

        Assert.assertEquals(expectedPair, actualPair);
    }

    @Test
    public void requestObjectsDeserializationTest() {
        DeviceInformation deviceInformation = createDeviceInfoObject();

        DeviceAcceleration deviceAcceleration = new DeviceAcceleration(12.34f, 56.78f, 9.10f);

        Boolean booleanData = true;

        RequestMessage requestMessage = new RequestMessage(MessageAction.ROUTING_ACTION,
                                                           RoutingAction.APK_APPEND_DATA,
                                                           deviceInformation,
                                                           deviceAcceleration,
                                                           TestConst.STRING_DATA,
                                                           TestConst.INTEGER_RESPONSE_DATA,
                                                           booleanData);

        String jsonRequest = jsonUtil.serialize(requestMessage);

        RequestMessage deserializedRequest = jsonUtil.deserializeRequest(jsonRequest);
        Object[] data = deserializedRequest.getArguments();

        DeviceInformation actualDeviceInformation = (DeviceInformation) data[0];
        DeviceAcceleration actualDeviceAcceleration = (DeviceAcceleration) data[1];
        String actualStringData = (String) data[2];
        Integer actualIntegerData = (Integer) data[3];
        Boolean actualBooleanData = (Boolean) data[4];

        Assert.assertEquals(TestConst.DEVICE_API_LEVEL, actualDeviceInformation.getApiLevel());
        Assert.assertEquals(TestConst.RESOLUTION_X, actualDeviceInformation.getResolution().getKey());
        Assert.assertEquals(TestConst.RESOLUTION_Y, actualDeviceInformation.getResolution().getValue());
        Assert.assertEquals(12.34f, actualDeviceAcceleration.getAccelerationX(), TestConst.DELTA);
        Assert.assertEquals(56.78f, actualDeviceAcceleration.getAccelerationY(), TestConst.DELTA);
        Assert.assertEquals(9.10f, actualDeviceAcceleration.getAccelerationZ(), TestConst.DELTA);
        Assert.assertEquals(TestConst.STRING_DATA, actualStringData);
        Assert.assertEquals(TestConst.INTEGER_RESPONSE_DATA, actualIntegerData);
        Assert.assertTrue(actualBooleanData);
    }

    @Test
    public void responseWithEmptyArgumentDeserializationTest() {
        String jsonMessage = readFile(jsonPath + "responseWithEmptyArgumentDeserializationTest.txt");

        RequestMessage message = jsonUtil.deserializeRequest(jsonMessage);

        Object[] arguments = message.getArguments();

        Assert.assertEquals(MessageAction.ROUTING_ACTION, message.getMessageAction());
        Assert.assertEquals(RoutingAction.WAIT_FOR_WINDOW_UPDATE, message.getRoutingAction());
        Assert.assertNull(arguments[0]);
        Assert.assertEquals(10000, arguments[1]);
        Assert.assertNull(message.getAgentId());
        Assert.assertEquals("deviceId", message.getDeviceId());
        Assert.assertEquals("sessionId", message.getSessionId());
    }

}
