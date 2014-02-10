package com.musala.atmosphere.commons.parameters;

/**
 * A generic interface for all command parameters for the different console implementations.
 *
 * @author boris.strandjev
 */
public interface CommandParameter
{
	/**
	 * @param forEmulator Whether the parameter is needed for emulator console command.
	 * @return The string value of the parameter to be used in the console command.
	 */
	public String getParameterValue(boolean forEmulator);
}
