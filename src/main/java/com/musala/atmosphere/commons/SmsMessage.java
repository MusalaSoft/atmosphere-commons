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

import java.io.Serializable;

import com.musala.atmosphere.commons.beans.PhoneNumber;

/**
 * A class that represents a simple SMS structure
 * 
 * @author kiril.petrov
 * 
 */
public class SmsMessage implements Serializable {
    private static final long serialVersionUID = 581600099577260811L;

    private PhoneNumber phoneNumber;

    private String text;

    public SmsMessage(PhoneNumber phoneNumber, String text) {
        this.phoneNumber = phoneNumber;
        this.text = text;
    }

    public SmsMessage(String phoneNumber, String text) throws IllegalArgumentException {
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.text = text;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public String getText() {
        return text;
    }
}
