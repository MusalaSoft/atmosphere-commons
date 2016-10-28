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
