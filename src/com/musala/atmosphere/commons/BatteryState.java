package com.musala.atmosphere.commons;

/**
 * Enumerates all possible states of the battery - unknown, charging, discharging, not charging and full
 * 
 * @author vladimir.vladimirov
 * 
 */

public enum BatteryState
{
	UNKNOWN("unknown"), CHARGING("charging"), DISCHARGING("discharging"), NOT_CHARGING("not_charging"), FULL("full");

	private String value;

	private BatteryState(String deviceBatteryState)
	{
		this.value = deviceBatteryState;
	}

	@Override
	public String toString()
	{
		return value;
	}

}