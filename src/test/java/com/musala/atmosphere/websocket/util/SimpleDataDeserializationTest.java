package com.musala.atmosphere.websocket.util;

import org.junit.Assert;
import org.junit.Test;

import com.musala.atmosphere.commons.RoutingAction;

/**
 * TODO: Add a javadoc
 *
 * @author dimcho.nedev
 *
 */
public class SimpleDataDeserializationTest extends BaseDataSerialization {
    @Test
    public void longClassResponseDataDeserializtionTest() {
        Long deserializedResponseData = (Long) getExpectedResponseData(RoutingAction.GET_AVAILABLE_DISK_SPACE,
                                                                       LONG_RESPONSE_DATA);

        Assert.assertEquals(LONG_RESPONSE_DATA, deserializedResponseData);
    }

    @Test
    public void longResponseDataDeserializtionTest() {
        long deserializedResponseData = (Long) getExpectedResponseData(RoutingAction.GET_FREE_RAM,
                                                                       (long) LONG_RESPONSE_DATA);

        Assert.assertEquals((long) LONG_RESPONSE_DATA, deserializedResponseData);
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
