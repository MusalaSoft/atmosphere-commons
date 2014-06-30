package com.musala.atmosphere.commons.beans;

import java.io.Serializable;

import com.musala.atmosphere.commons.parameters.CommandParameter;

/**
 * Enumerator for device power supply source. Values used are as seen on <a
 * href="http://developer.android.com/reference/android/os/BatteryManager.html">Android Developer BatteryManager
 * documentation.</a>
 * 
 * @author georgi.gaydarov
 * 
 */
public enum PowerSource implements CommandParameter, Serializable {
    /**
     * Device is unplugged.
     */
    UNPLUGGED(0),
    /**
     * Power source is an AC charger.
     */
    PLUGGED_AC(1),
    /**
     * Power source is a USB port.<br>
     * <b>Note</b> : For emulators, this option is interpreted as {@link #PLUGGED_AC}.
     */
    PLUGGED_USB(2),
    /**
     * Power source is wireless.<br>
     * <b>Note</b> : For emulators, this option is interpreted as {@link #PLUGGED_AC}.
     */
    PLUGGED_WIRELESS(4);

    private int stateId;

    private PowerSource(int stateId) {
        this.stateId = stateId;
    }

    public int getStateId() {
        return stateId;
    }

    public static PowerSource getStateById(int stateId) {
        PowerSource stateToReturn = null;
        for (PowerSource state : PowerSource.values()) {
            if (state.getStateId() == stateId) {
                stateToReturn = state;
                break;
            }
        }
        return stateToReturn;
    }

    @Override
    public String getParameterValue(boolean forEmulator) {
        if (forEmulator) {
            return (this == UNPLUGGED ? "off" : "on");
        }
        return toString();
    }
}
