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

/**
 * Enumeration that contains the different network connection types as defined by android.net.ConnectivityManager.
 * 
 * @author yordan.petrov
 * 
 */
public enum ConnectionType {
    /**
     * The Bluetooth data connection. When active, all data traffic will use this network type's interface by default
     * (it has a default route).
     */
    BLUETOOTH(7),

    /**
     * Dummy data connection. This should not be used on shipping devices.
     */
    DUMMY(8),

    /**
     * The Ethernet data connection. When active, all data traffic will use this network type's interface by default (it
     * has a default route).
     */
    ETHERNET(9),

    /**
     * The Mobile data connection. When active, all data traffic will use this network type's interface by default (it
     * has a default route).
     */
    MOBILE(0),

    /**
     * A DUN-specific Mobile data connection. This network type may use the same network interface as
     * {@link ConnectionType#MOBILE} or it may use a different one. This is sometimes by the system when setting up an
     * upstream connection for tethering so that the carrier is aware of DUN traffic.
     */
    MOBILE_DUN(4),

    /**
     * A High Priority Mobile data connection. This network type uses the same network interface as
     * {@link ConnectionType#MOBILE} but the routing setup is different.
     */
    MOBILE_HIPRI(5),

    /**
     * An MMS-specific Mobile data connection. This network type may use the same network interface as
     * {@link ConnectionType#MOBILE} or it may use a different one. This is used by applications needing to talk to the
     * carrier's Multimedia Messaging Service servers.
     */
    MOBILE_MMS(2),

    /**
     * A SUPL-specific Mobile data connection. This network type may use the same network interface as
     * {@link ConnectionType#MOBILE} or it may use a different one. This is used by applications needing to talk to the
     * carrier's Secure User Plane Location servers for help locating the device.
     */
    MOBILE_SUPL(3),

    /**
     * The WIFI data connection. When active, all data traffic will use this network type's interface by default (it has
     * a default route).
     */
    WIFI(1),

    /**
     * The WiMAX data connection. When active, all data traffic will use this network type's interface by default (it
     * has a default route).
     */
    WIMAX(6),

    /**
     * The device is not connected to any network.
     */
    NONE(-1);

    private int intValue;

    private ConnectionType(int intValue) {
        this.intValue = intValue;
    }

    /**
     * Gets the connection type identifier.
     * 
     * @return the connection type identifier.
     */
    public int getId() {
        return intValue;
    }

    /**
     * Returns a {@link ConnectionType} object by a given identifier.
     * 
     * @param id
     *        - the connection type identifier.
     * @return a {@link ConnectionType} object by a given identifier.
     */
    public static ConnectionType getById(int id) {
        ConnectionType typeById = null;
        for (ConnectionType currentType : ConnectionType.values()) {
            if (currentType.getId() == id) {
                typeById = currentType;
                break;
            }
        }

        return typeById;
    }
}
