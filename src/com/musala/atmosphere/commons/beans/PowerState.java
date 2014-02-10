package com.musala.atmosphere.commons.beans;

import com.musala.atmosphere.commons.parameters.CommandParameter;

/**
 * A console command parameter for power state
 *
 * @author boris.strandjev
 */
public class PowerState implements CommandParameter
{
	private boolean state;

	public PowerState(boolean state)
	{
		this.state = state;
	}

	@Override
	public String getParameterValue(boolean forEmulator)
	{
		return state ? "on" : "off";
	}
}
