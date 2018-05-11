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

package com.musala.atmosphere.commons;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.musala.atmosphere.commons.beans.DeviceAcceleration;

public class DeviceAccelerationTest {

    @Test
    public void EqualsPositiveTest() {
        DeviceAcceleration acceleration1 = new DeviceAcceleration();
        DeviceAcceleration acceleration2 = new DeviceAcceleration(0, 0, 0);
        assertTrue("Equal DeviceAcceleration objects are reported as unequal", acceleration1.equals(acceleration2));
    }

    @Test
    public void EqualsNegativeTest() {
        DeviceAcceleration acceleration1 = new DeviceAcceleration();
        DeviceAcceleration acceleration2 = new DeviceAcceleration(1, 1, 1);
        assertFalse("Unequal DeviceAcceleration objects are reported as equal", acceleration1.equals(acceleration2));
    }
}
