package com.musala.atmosphere.commons.beans;

import com.musala.atmosphere.commons.exceptions.CommandFailedException;
import com.musala.atmosphere.commons.parameters.CommandParameter;

/**
 * A class that represents the battery level command parameter.
 *
 * @author boris.strandjev
 */
public class BatteryLevel implements CommandParameter
{
	private int level;

	public BatteryLevel(int level) throws CommandFailedException
	{
		verifyLevel();
		this.level = level;
	}

	private void verifyLevel() throws CommandFailedException
	{
		if (level < 0 || level > 100)
		{
			IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Battery level should be in the range [0, 100].");
			throw new CommandFailedException("Illegal argument has been passed to the emulator console class. "
					+ "See the enclosed exception for more information.", illegalArgumentException);
		}
	}

	@Override
	public String getParameterValue(boolean forEmulator)
	{
		return String.valueOf(level);
	}

}
