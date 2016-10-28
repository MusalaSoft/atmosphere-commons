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
