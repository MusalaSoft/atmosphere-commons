package com.musala.atmosphere.commons.beans;

import com.musala.atmosphere.commons.parameters.CommandParameter;

/**
 * Enumeration of possible mobile data states for a device.
 * 
 * 
 */
public enum MobileDataState implements CommandParameter {
    /**
     * No network available.
     */
    UNREGISTERED("unregistered"),
    /**
     * On local network, non-roaming.
     */
    HOME("home"),
    /**
     * On roaming network.
     */
    ROAMING("roaming"),
    /**
     * Searching networks.
     */
    SEARCHING("searching"),
    /**
     * Emergency calls only.
     */
    DENIED("denied");

    private String mobileDataStateValue;

    private MobileDataState(String state) {
        this.mobileDataStateValue = state;
    }

    @Override
    public String getParameterValue(boolean forEmulator) {
        return mobileDataStateValue;
    }
}
