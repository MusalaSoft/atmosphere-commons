package com.musala.atmosphere.commons;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DeviceAccelerationTest
{

	@Test
	public void EqualsPositiveTest()
	{
		DeviceAcceleration acceleration1 = new DeviceAcceleration();
		DeviceAcceleration acceleration2 = new DeviceAcceleration(0, 0, 0);
		assertTrue("Equal DeviceAcceleration objects are reported as unequal", acceleration1.equals(acceleration2));
	}

	@Test
	public void EqualsNegativeTest()
	{
		DeviceAcceleration acceleration1 = new DeviceAcceleration();
		DeviceAcceleration acceleration2 = new DeviceAcceleration(1, 1, 1);
		assertFalse("Unequal DeviceAcceleration objects are reported as equal", acceleration1.equals(acceleration2));
	}
}
