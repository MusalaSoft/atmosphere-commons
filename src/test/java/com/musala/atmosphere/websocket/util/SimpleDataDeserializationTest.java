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

/**
 * Tests the deserialization of simple data after a serialization.
 *
 * @author dimcho.nedev
 *
 */
public class SimpleDataDeserializationTest extends DataSerializationTestBase {

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

        Assert.assertArrayEquals(byteArray, deserializedResponseData);
    }

    @Test
    public void booleanDeserializerTest() {
        boolean data = true;
        boolean deserializedResponseData = (Boolean) getExpectedResponseData(RoutingAction.WAIT_FOR_WEB_ELEMENT, data);

        Assert.assertTrue(deserializedResponseData);
    }
}
