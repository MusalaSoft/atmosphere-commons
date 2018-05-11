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
 * Enumeration indicating a device phone type.
 * 
 * @author yordan.petrov
 * 
 */
public enum PhoneType {
    /*
     * Phone radio is CDMA.
     */
    PHONE_TYPE_CDMA(0),

    /*
     * Phone radio is GSM.
     */
    PHONE_TYPE_GSM(1),

    /*
     * No phone radio.
     */
    PHONE_TYPE_NONE(2),

    /*
     * Phone is via SIP.
     */
    PHONE_TYPE_SIP(3);

    private int phoneTypeId;

    private PhoneType(int phoneTypeId) {
        this.phoneTypeId = phoneTypeId;
    }

    public int getId() {
        return phoneTypeId;
    }

    public static PhoneType getById(int id) {
        PhoneType typeById = null;
        for (PhoneType currentState : PhoneType.values()) {
            if (currentState.getId() == id) {
                typeById = currentState;
                break;
            }
        }

        return typeById;
    }
}
