package com.musala.atmosphere.commons;

public enum MobileDataState
{
	UNREGISTERED("unregistered"), HOME("home"), ROAMING("roaming"), SEARCHING("searching"), DENIED("denied");

	private String mobileDataStateValue;

	private MobileDataState(String state)
	{
		this.mobileDataStateValue = state;
	}

	@Override
	public String toString()
	{
		return mobileDataStateValue;
	}
}
