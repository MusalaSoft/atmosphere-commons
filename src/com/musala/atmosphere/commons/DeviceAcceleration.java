package com.musala.atmosphere.commons;

import java.io.Serializable;

/**
 * Class containing information about the device acceleration.
 * 
 * @author yordan.petrov
 * 
 */
public class DeviceAcceleration implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3379968408421438681L;

	/**
	 * Acceleration on the X axis.
	 */
	private float accelerationX;

	/**
	 * Acceleration on the Y axis.
	 */
	private float accelerationY;

	/**
	 * Acceleration on the Z axis.
	 */
	private float accelerationZ;

	/**
	 * Creates new {@link DeviceAcceleration} instance setting all fields to 0.0f.
	 */
	public DeviceAcceleration()
	{
		this(0.0f, 0.0f, 0.0f);
	}

	/**
	 * Creates new {@link DeviceAcceleration} setting fields to the given parameters' value.
	 * 
	 * @param accelerationX
	 *        - acceleration on the X axis.
	 * @param accelerationY
	 *        - acceleration on the Y axis.
	 * @param accelerationZ
	 *        - acceleration on the Z axis.
	 */
	public DeviceAcceleration(float accelerationX, float accelerationY, float accelerationZ)
	{
		this.accelerationX = accelerationX;
		this.accelerationY = accelerationY;
		this.accelerationZ = accelerationZ;
	}

	/**
	 * Returns a new {@link DeviceAcceleration} instance representing device in portrait perspective.
	 * 
	 * @return - a new {@link DeviceAcceleration} instance representing device in portrait perspective.
	 */
	public static DeviceAcceleration getPortrait()
	{
		final float portraitAccelerationX = 0.0f;
		final float portraitAccelerationY = 9.81f;
		final float portraitAccelerationZ = 0.0f;

		return new DeviceAcceleration(portraitAccelerationX, portraitAccelerationY, portraitAccelerationZ);
	}

	/**
	 * Returns a new {@link DeviceAcceleration} instance representing device in reverse portrait perspective.
	 * 
	 * @return - a new {@link DeviceAcceleration} instance representing device in reverse portrait perspective.
	 */
	public static DeviceAcceleration getReversePortrait()
	{
		final float reversePortraitAccelerationX = 0.0f;
		final float reversePortraitAccelerationY = -9.81f;
		final float reversePortraitAccelerationZ = 0.0f;

		return new DeviceAcceleration(	reversePortraitAccelerationX,
										reversePortraitAccelerationY,
										reversePortraitAccelerationZ);
	}

	/**
	 * Returns a new {@link DeviceAcceleration} instance representing device in landscape perspective.
	 * 
	 * @return - a new {@link DeviceAcceleration} instance representing device in landscape perspective.
	 */
	public static DeviceAcceleration getLandscape()
	{
		final float landscapeAccelerationX = 9.81f;
		final float landscapeAccelerationY = 0.0f;
		final float landscapeAccelerationZ = 0.0f;

		return new DeviceAcceleration(landscapeAccelerationX, landscapeAccelerationY, landscapeAccelerationZ);
	}

	/**
	 * Returns a new {@link DeviceAcceleration} instance representing device in reverse landscape perspective.
	 * 
	 * @return - a new {@link DeviceAcceleration} instance representing device in reverse landscape perspective.
	 */
	public static DeviceAcceleration getReverseLandscape()
	{
		final float reverseLandscapeAccelerationX = -9.81f;
		final float reverseLandscapeAccelerationY = 0.0f;
		final float reverseLandscapeAccelerationZ = 0.0f;

		return new DeviceAcceleration(	reverseLandscapeAccelerationX,
										reverseLandscapeAccelerationY,
										reverseLandscapeAccelerationZ);
	}

	/**
	 * Returns a new {@link DeviceAcceleration} instance representing device in lie down perspective.
	 * 
	 * @return - a new {@link DeviceAcceleration} instance representing device in lie down perspective.
	 */
	public static DeviceAcceleration getLieDown()
	{
		final float lieDownAccelerationX = 0.0f;
		final float lieDownAccelerationY = 0.0f;
		final float lieDownAccelerationZ = 9.81f;

		return new DeviceAcceleration(lieDownAccelerationX, lieDownAccelerationY, lieDownAccelerationZ);
	}

	/**
	 * Returns a new {@link DeviceAcceleration} instance representing device in reverse lie down perspective.
	 * 
	 * @return - a new {@link DeviceAcceleration} instance representing device in reverse lie down perspective.
	 */
	public static DeviceAcceleration getReverseLieDown()
	{
		final float reverseLieDownAccelerationX = 0.0f;
		final float reverseLieDownAccelerationY = 0.0f;
		final float reverseLieDownAccelerationZ = -9.81f;

		return new DeviceAcceleration(	reverseLieDownAccelerationX,
										reverseLieDownAccelerationY,
										reverseLieDownAccelerationZ);
	}

	/**
	 * Gets the acceleration on the X axis.
	 * 
	 * @return - the acceleration on the X axis.
	 */
	public float getAccelerationX()
	{
		return accelerationX;
	}

	/**
	 * Gets the acceleration on the Y axis.
	 * 
	 * @return - the acceleration on the Y axis.
	 */
	public float getAccelerationY()
	{
		return accelerationY;
	}

	/**
	 * Gets the acceleration on the Z axis.
	 * 
	 * @return - the acceleration on the Z axis.
	 */
	public float getAccelerationZ()
	{
		return accelerationZ;
	}

	public String parseCommand()
	{

		return String.format("%s:%s:%s", accelerationX, accelerationY, accelerationZ);
	}

	@Override
	public String toString()
	{
		return String.format("[X: %s, Y: %s, Z: %s]", accelerationX, accelerationY, accelerationZ);
	}
}