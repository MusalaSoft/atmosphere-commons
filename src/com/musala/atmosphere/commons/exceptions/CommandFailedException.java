package com.musala.atmosphere.commons.exceptions;

/**
 * Thrown when a command passed to the shell of a device has failed to execute.
 * 
 * @author georgi.gaydarov
 * 
 */
public class CommandFailedException extends Exception
{
	private static final long serialVersionUID = -3879797786566060077L;

	public CommandFailedException()
	{
	}

	public CommandFailedException(String message)
	{
		super(message);
	}

	public CommandFailedException(String message, Throwable inner)
	{
		super(message, inner);
	}
}
