package com.musala.atmosphere.commons;

/**
 * Enumerates all possible states of the battery - unknown, charging, discharging, not charging and full
 * 
 * @author vladimir.vladimirov
 * 
 */

public enum BatteryState
{
	UNKNOWN("unknown", 1), CHARGING("charging", 2), DISCHARGING("discharging", 3), NOT_CHARGING("not_charging", 4), FULL(
			"full", 5);

	private String batteryStateValue;

	private int batteryStateNumberValue;

	private BatteryState(String deviceBatteryState, int stateNumber)
	{
		this.batteryStateValue = deviceBatteryState;
		this.batteryStateNumberValue = stateNumber;
	}

	@Override
	public String toString()
	{
		return batteryStateValue;
	}

	public int getStateId()
	{
		return batteryStateNumberValue;
	}

	public static BatteryState getStateById(int stateId)
	{
		BatteryState stateToReturn = null;
		for (BatteryState state : BatteryState.values())
		{
			if (state.getStateId() == stateId)
			{
				stateToReturn = state;
				break;
			}
		}
		return stateToReturn;
	}
}