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
