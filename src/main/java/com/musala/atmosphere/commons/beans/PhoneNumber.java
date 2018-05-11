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
import java.util.regex.Pattern;

import com.musala.atmosphere.commons.parameters.CommandParameter;

/**
 * A class that represents a phone number.
 * 
 * @author yordan.petrov
 * 
 */
public class PhoneNumber implements Serializable, CommandParameter {
    private static final long serialVersionUID = -5016732032561627449L;

    private String phoneNumber;

    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = verifyPhone(phoneNumber);
    }

    @Override
    public String getParameterValue(boolean forEmulator) {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return phoneNumber;
    }

    private String verifyPhone(String phoneNumber) throws IllegalArgumentException {
        if (phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Zero length phone number.");
        }
        if (!Pattern.matches("[+]*[0-9]+", phoneNumber)) {
            throw new IllegalArgumentException("Phone number is not according expected pattern [+](0-9)* .");
        }
        return phoneNumber;
    }
}
