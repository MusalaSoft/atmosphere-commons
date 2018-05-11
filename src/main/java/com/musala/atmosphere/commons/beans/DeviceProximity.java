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

package com.musala.atmosphere.commons.beans;

import com.musala.atmosphere.commons.parameters.CommandParameter;

/**
 * A class that represents the parameters of the proximity sensor on a device.
 * 
 * @author simeon.ivanov
 * 
 */

public class DeviceProximity implements CommandParameter {
    /** Binary value denoting a near distance for the proximity sensor. */
    public static final float BINARY_NEAR_VALUE = 0.0f;

    /** Binary value denoting a far distance for the proximity sensor. */
    public static final float BINARY_FAR_VALUE = 1.0f;

    private final float deviceProximity;

    public DeviceProximity(float deviceProximity) {
        this.deviceProximity = deviceProximity;
    }

    public String parseCommand() {
        return String.format("%s", deviceProximity);
    }

    @Override
    public String getParameterValue(boolean forEmulator) {
        return parseCommand();
    }
}
