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

import java.io.Serializable;

import com.musala.atmosphere.commons.parameters.CommandParameter;

/**
 * 
 * @author yavor.stankov
 * 
 */

public class DeviceMagneticField implements Serializable, CommandParameter {
    private static final long serialVersionUID = 5892409383516887320L;

    /**
     * Geomagnetic field strength along the x axis.
     */
    private float xAxis;

    /**
     * Geomagnetic field strength along the y axis.
     */
    private float yAxis;

    /**
     * Geomagnetic field strength along the z axis.
     */
    private float zAxis;

    /**
     * Creates new {@link DeviceMagneticField} instance setting all fields to 0.0f.
     */
    public DeviceMagneticField() {
        this(0.0f, 0.0f, 0.0f);
    }

    /**
     * Creates new {@link DeviceAcceleration} setting fields to the given parameters' value.
     * 
     * @param xAxis
     *        - magnetic field on the X axis.
     * @param yAxis
     *        - magnetic field on the Y axis.
     * @param zAxis
     *        - magnetic field on the Z axis.
     */
    public DeviceMagneticField(float xAxis, float yAxis, float zAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.zAxis = zAxis;
    }

    public float getXAxis() {
        return xAxis;
    }

    public float getYAxis() {
        return yAxis;
    }

    public float getZAxis() {
        return zAxis;
    }

    public String parseCommand() {
        return String.format("%s:%s:%s", xAxis, yAxis, zAxis);
    }

    @Override
    public String getParameterValue(boolean forEmulator) {
        return parseCommand();
    }

}
