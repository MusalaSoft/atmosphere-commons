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
