package com.musala.atmosphere.commons;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * A class that represents a simple SMS structure
 * 
 * @author kiril.petrov
 * 
 */
public class SmsMessage implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String phoneNumber;

	private String text;

	public SmsMessage(String phoneNumber, String text) throws IllegalArgumentException
	{
		this.phoneNumber = verifyPhone(phoneNumber);
		this.text = text;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public String getText()
	{
		return text;
	}

	private String verifyPhone(String phoneNumber) throws IllegalArgumentException
	{
		if (phoneNumber.length() == 0)
		{
			throw new IllegalArgumentException("Zero length phone number.");
		}
		if (!Pattern.matches("[+]*[0-9]+", phoneNumber))
		{
			throw new IllegalArgumentException("Phone number is not according expected pattern [+](0-9)* .");
		}
		return phoneNumber;
	}
}
