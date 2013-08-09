package com.musala.atmosphere.commons;

import java.io.Serializable;


/**
 * <p>
 * Information container for the basic device properties, which will be used in the device selection process.
 * </p>
 * 
 * @author georgi.gaydarov
 * 
 */
public class DeviceInformation implements Serializable
{
	public static final Integer FALLBACK_DISPLAY_DENSITY = 0;

	public static final Integer FALLBACK_RAM_AMOUNT = 0;

	public static final Pair<Integer, Integer> FALLBACK_SCREEN_RESOLUTION = new Pair<Integer, Integer>(0, 0);

	public static final boolean FALLBACK_ISEMULATOR_SETTING = true;

	public static final String FALLBACK_MODEL_VALUE = "not set";

	public static final String FALLBACK_OS_VALUE = "not set";

	public static final String FALLBACK_SERIALNUMBER_VALUE = "not set";

	public static final String FALLBACK_CPU_IDENTIFIER = "unknown";

	/**
	 * Default constructor that fills this structure with the FALLBACK constants.
	 */
	public DeviceInformation()
	{
		isEmulator = FALLBACK_ISEMULATOR_SETTING;
		dpi = FALLBACK_DISPLAY_DENSITY;
		model = FALLBACK_MODEL_VALUE;
		os = FALLBACK_OS_VALUE;
		resolution = FALLBACK_SCREEN_RESOLUTION;
		serialNumber = FALLBACK_SERIALNUMBER_VALUE;
		ram = FALLBACK_RAM_AMOUNT;
		cpu = FALLBACK_CPU_IDENTIFIER;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6289200803789024053L;

	/**
	 * Serial number of the device.
	 */
	private String serialNumber;

	/**
	 * True if this device is an emulator, false if the device is physical.
	 */
	private boolean isEmulator;

	/**
	 * Device screen resolution.
	 */
	private Pair<Integer, Integer> resolution;

	/**
	 * Operating system of the device.
	 */
	private String os;

	/**
	 * Device model.
	 */
	private String model;

	/**
	 * Dots per inch on the device screen.
	 */
	private int dpi;

	/**
	 * Random access memory (RAM) available to the device.
	 */
	private int ram;

	/**
	 * CPU identifier.
	 */
	private String cpu;

	public String getSerialNumber()
	{
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber)
	{
		this.serialNumber = serialNumber;
	}

	public boolean isEmulator()
	{
		return isEmulator;
	}

	public void setEmulator(boolean isEmulator)
	{
		this.isEmulator = isEmulator;
	}

	public Pair<Integer, Integer> getResolution()
	{
		return resolution;
	}

	public void setResolution(Pair<Integer, Integer> resolution)
	{
		this.resolution = resolution;
	}

	public String getOS()
	{
		return os;
	}

	public void setOs(String os)
	{
		this.os = os;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public int getDpi()
	{
		return dpi;
	}

	public void setDpi(int dpi)
	{
		this.dpi = dpi;
	}

	public int getRam()
	{
		return ram;
	}

	public void setRam(int ram)
	{
		this.ram = ram;
	}

	public void setCpu(String cpu)
	{
		this.cpu = cpu;
	}

	public String getCpu()
	{
		return cpu;
	}
}
