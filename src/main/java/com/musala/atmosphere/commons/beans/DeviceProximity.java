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