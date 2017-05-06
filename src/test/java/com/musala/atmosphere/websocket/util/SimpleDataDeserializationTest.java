package com.musala.atmosphere.websocket.util;

import org.junit.Assert;
import org.junit.Test;

import com.musala.atmosphere.commons.RoutingAction;

/**
 * Tests the deserialization of simple data after a serialization.
 *
 * @author dimcho.nedev
 *
 */
public class SimpleDataDeserializationTest extends BaseDataSerialization {

    @Test
    public void longClassResponseDataDeserializtionTest() {
        Long deserializedResponseData = (Long) getExpectedResponseData(RoutingAction.GET_AVAILABLE_DISK_SPACE,
                                                                       TestConst.LONG_RESPONSE_DATA);

        Assert.assertEquals(TestConst.LONG_RESPONSE_DATA, deserializedResponseData);
    }

    @Test
    public void longResponseDataDeserializtionTest() {
        long deserializedResponseData = (Long) getExpectedResponseData(RoutingAction.GET_FREE_RAM,
                                                                       (long) TestConst.LONG_RESPONSE_DATA);

        Assert.assertEquals((long) TestConst.LONG_RESPONSE_DATA, deserializedResponseData);
    }

    @Test
    public void byteArrayDataDeserializerTest() {
        byte[] byteArray = new byte[] {1, 1, 2, 3, 5, 8, 13, 21};

        byte[] deserializedResponseData = (byte[]) getExpectedResponseData(RoutingAction.GET_SCREENSHOT, byteArray);

        Assert.assertEquals(8, deserializedResponseData.length);
        Assert.assertArrayEquals(byteArray, deserializedResponseData);
    }

    @Test
    public void booleanDeserializerTest() {
        boolean data = true;
        boolean deserializedResponseData = (Boolean) getExpectedResponseData(RoutingAction.WAIT_FOR_WEB_ELEMENT, data);

        Assert.assertTrue(deserializedResponseData);
    }
}
