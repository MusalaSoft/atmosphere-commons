package com.musala.atmosphere.websocket.util;

import java.io.Serializable;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.JsonSyntaxException;
import com.musala.atmosphere.commons.RoutingAction;
import com.musala.atmosphere.commons.util.AtmosphereIntent;
import com.musala.atmosphere.commons.util.Pack;
import com.musala.atmosphere.commons.websocket.message.RequestMessage;

import android.content.Intent;

/**
 * Tests the deserialization of the {@link Intent intent data}.
 *
 * @author dimcho.nedev
 *
 */
public class IntentDataDeserializationTest extends DataSerializationTestBase {

    @Test
    public void atmosphereIntentDataDeserializationTest() {
        AtmosphereIntent intent = new AtmosphereIntent(TestConst.STRING_DATA);
        intent.addCategory("cat_1");
        intent.addCategory("cat_2");
        intent.addFlag(1);
        intent.addFlag(2);
        intent.putExtra("key", true);
        Set<Integer> expectedFlags = intent.getFlags();
        Set<String> expectedCategories = intent.getCategories();

        AtmosphereIntent deserializedResponseData = (AtmosphereIntent) getExpectedResponseData(RoutingAction.SEND_BROADCAST,
                                                                                               intent);
        Set<Integer> actualFlags = deserializedResponseData.getFlags();
        Set<String> actialCategories = deserializedResponseData.getCategories();

        Assert.assertEquals(TestConst.STRING_DATA, deserializedResponseData.getAction());
        Assert.assertEquals(true, deserializedResponseData.getBooleanExtra("key", false));
        Assert.assertEquals(expectedFlags, actualFlags);
        Assert.assertEquals(expectedCategories, actialCategories);
    }

    @Test
    public void atmosphereIntentDataDeserializationRealDataTest() throws JsonSyntaxException, ClassNotFoundException {
        String jsonMessage = readFile(jsonPath + "atmosphereIntentDataDeserializationRealDataTest.txt");

        RequestMessage response = jsonUtil.deserializeRequest(jsonMessage);
        AtmosphereIntent intent = (AtmosphereIntent) response.getArguments()[0];

        Assert.assertEquals("atmosphere.intent.ime.action.INPUT", intent.getAction());
        Assert.assertEquals("Letters", intent.getStringExtra("text"));
        Assert.assertEquals(0L, intent.getLongExtra("input_speed", 0));
        Assert.assertEquals(0, intent.getFlags().size());
        Assert.assertEquals(0, intent.getCategories().size());
    }

    private class Person implements Serializable {
        private static final long serialVersionUID = -2621088938537970998L;

        public String name = "Name";

        public int age = 26;

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Person)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            Person person = (Person) obj;

            return this.name.equals(person.name) && this.age == person.age;
        }
    }

    @Test
    public void packDataDeserializationTest() {
        Person person = new Person();
        final short shortInt = 10;
        final byte byteInt = 16;

        Pack packObj = new Pack();
        packObj.putBoolean("boolean", true);
        packObj.putLong("long", TestConst.LONG_RESPONSE_DATA);
        packObj.putFloat("float", TestConst.FLOAT_DATA);
        packObj.putDouble("double", TestConst.DOUBLE_DATA);
        packObj.putInt("int", TestConst.INTEGER_RESPONSE_DATA);
        packObj.putChar("char", '1');
        packObj.putShort("short", shortInt);
        packObj.putByte("byte", byteInt);
        packObj.putSerializable("person", person);

        Pack pack = (Pack) getExpectedResponseData(RoutingAction.SEND_BROADCAST, packObj);

        Assert.assertFalse(pack.isEmpty());
        Assert.assertEquals(true, pack.getBoolean("boolean", false));
        Assert.assertTrue(TestConst.LONG_RESPONSE_DATA.equals(pack.getLong("long", 123)));
        Assert.assertEquals(String.valueOf(TestConst.FLOAT_DATA), String.valueOf(pack.getFloat("float", 123)));
        Assert.assertTrue(TestConst.DOUBLE_DATA.equals(pack.getDouble("double", 123d)));
        Assert.assertTrue(TestConst.INTEGER_RESPONSE_DATA.equals(pack.getInt("int", 123)));
        Assert.assertTrue(((Character) '1').equals(pack.getChar("char", '0')));
        Assert.assertEquals(shortInt, pack.getShort("short", (short) 123));
        Assert.assertEquals((byte) 16, pack.getByte("byte", (byte) 0));
        Assert.assertEquals(person, packObj.getSerializable("person"));
    }

    @Test
    public void emptyPackDataDeserializationTest() {
        Pack packObj = new Pack();

        Pack pack = (Pack) getExpectedResponseData(RoutingAction.SEND_BROADCAST, packObj);

        Assert.assertTrue(pack.isEmpty());
    }
}
