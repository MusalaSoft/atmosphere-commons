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

package com.musala.atmosphere.commons.util.telephony;

/**
 * Enumeration indicating the network type for current data connection.
 * 
 * 
 * @author yordan.petrov
 * 
 */
public enum NetworkType {
    /*
     * Current network is 1xRTT
     */
    NETWORK_TYPE_1xRTT(0),

    /*
     * Current network is CDMA: Either IS95A or IS95B
     */
    NETWORK_TYPE_CDMA(1),

    /*
     * Current network is EDGE
     */
    NETWORK_TYPE_EDGE(2),

    /*
     * Current network is eHRPD
     */
    NETWORK_TYPE_EHRPD(3),

    /*
     * Current network is EVDO revision 0
     */
    NETWORK_TYPE_EVDO_0(4),

    /*
     * Current network is EVDO revision A
     */
    NETWORK_TYPE_EVDO_A(5),

    /*
     * Current network is EVDO revision B
     */
    NETWORK_TYPE_EVDO_B(6),

    /*
     * Current network is GPRS
     */
    NETWORK_TYPE_GPRS(7),

    /*
     * Current network is HSDPA
     */
    NETWORK_TYPE_HSDPA(8),

    /*
     * Current network is HSPA
     */
    NETWORK_TYPE_HSPA(9),

    /*
     * Current network is HSPA+
     */
    NETWORK_TYPE_HSPAP(10),

    /*
     * Current network is HSUPA
     */
    NETWORK_TYPE_HSUPA(11),

    /*
     * Current network is iDen
     */
    NETWORK_TYPE_IDEN(12),

    /*
     * Current network is LTE
     */
    NETWORK_TYPE_LTE(13),

    /*
     * Current network is UMTS
     */
    NETWORK_TYPE_UMTS(14),

    /*
     * Network type is unknown
     */
    NETWORK_TYPE_UNKNOWN(16);

    private int networkTypeId;

    private NetworkType(int networkTypeId) {
        this.networkTypeId = networkTypeId;
    }

    public int getId() {
        return networkTypeId;
    }

    public static NetworkType getById(int id) {
        NetworkType typeById = null;
        for (NetworkType currentState : NetworkType.values()) {
            if (currentState.getId() == id) {
                typeById = currentState;
                break;
            }
        }

        return typeById;
    }
}
