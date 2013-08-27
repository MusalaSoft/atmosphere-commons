package com.musala.atmosphere.commons;

/**
 * Holds different screen orientations.
 * 
 * @author nikola.taushanov
 * 
 */
public enum ScreenOrientation
{
	LANDSCAPE(0), PORTRAIT(1), UPSIDE_DOWN_LANDSCAPE(2), UPSIDE_DOWN_PORTRAIT(3);

	private int orientationNumber;

	private ScreenOrientation(int orientationNumber)
	{
		this.orientationNumber = orientationNumber;
	}

	public int getOrientationNumber()
	{
		return orientationNumber;
	}
}
