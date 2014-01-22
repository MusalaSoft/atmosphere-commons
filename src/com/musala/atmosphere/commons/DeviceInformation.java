package com.musala.atmosphere.commons;

import java.io.Serializable;

import com.musala.atmosphere.commons.util.Pair;

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

	public static final int FALLBACK_API_LEVEL = 0;

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
		apiLevel = FALLBACK_API_LEVEL;
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

	/**
	 * Device API level.
	 */
	private int apiLevel;

	/**
	 * @return the serial number of the device.
	 */
	public String getSerialNumber()
	{
		return serialNumber;
	}

	/**
	 * Sets device serial number in this DeviceInformation.
	 * 
	 * @param serialNumber
	 *        - the serial number to be set.
	 */
	public void setSerialNumber(String serialNumber)
	{
		this.serialNumber = serialNumber;
	}

	/**
	 * @return <code>true</code> if this device is an emulator.<br>
	 *         <code>false</code> if the device is real physical device.
	 */
	public boolean isEmulator()
	{
		return isEmulator;
	}

	/**
	 * Sets device type in this DeviceInformation.
	 * 
	 * @param isEmulator
	 *        - <code>true</code> for emulator, <code>false</code> for real device.
	 */
	public void setEmulator(boolean isEmulator)
	{
		this.isEmulator = isEmulator;
	}

	/**
	 * 
	 * @return {@link Pair} object, containing the resolution (width, height) of device's screen.
	 */
	public Pair<Integer, Integer> getResolution()
	{
		return resolution;
	}

	/**
	 * Sets the device resolution in this DeviceInformation.
	 * 
	 * @param resolution
	 *        - (width, height) pair to be set as device's resolution.
	 */
	public void setResolution(Pair<Integer, Integer> resolution)
	{
		this.resolution = resolution;
	}

	/**
	 * 
	 * @return device's operating system.
	 */
	public String getOS()
	{
		return os;
	}

	/**
	 * Sets the device's operating system in this DeviceInformation.
	 * 
	 * @param os
	 *        - operating system to set.
	 */
	public void setOs(String os)
	{
		this.os = os;
	}

	/**
	 * 
	 * @return Android API level of device.
	 */
	public int getApiLevel()
	{
		return apiLevel;
	}

	/**
	 * Sets device's Android API level in this DeviceInformation.
	 * 
	 * @param os
	 *        - operating system to set.
	 */
	public void setApiLevel(int apiLevel)
	{
		this.apiLevel = apiLevel;
	}

	/**
	 * 
	 * @return device model.
	 */
	public String getModel()
	{
		return model;
	}

	/**
	 * Sets device model in this DeviceInformation.
	 * 
	 * @param model
	 *        - device model to set.
	 */
	public void setModel(String model)
	{
		this.model = model;
	}

	/**
	 * 
	 * @return the dpi (dots per inch) of device's screen.
	 */
	public int getDpi()
	{
		return dpi;
	}

	/**
	 * Sets device screen dpi (dots per inch) in this DeviceInformation.
	 * 
	 * @param dpi
	 *        - screen dpi to set.
	 */
	public void setDpi(int dpi)
	{
		this.dpi = dpi;
	}

	/**
	 * 
	 * @return total device RAM.
	 */
	public int getRam()
	{
		return ram;
	}

	/**
	 * Sets total device RAM in this DeviceInformation.
	 * 
	 * @param ram
	 *        - device RAM to set.
	 */
	public void setRam(int ram)
	{
		this.ram = ram;
	}

	/**
	 * Sets device CPU model identifier in this DeviceInformation.
	 * 
	 * @param cpu
	 *        - device CPU model to set.
	 */
	public void setCpu(String cpu)
	{
		this.cpu = cpu;
	}

	/**
	 * 
	 * @return device CPU model identifier.
	 */
	public String getCpu()
	{
		return cpu;
	}

	@Override
	public String toString()
	{
		return String.format(	"[Emulator: %s, Model: %s, OS: %s, API: %s, RAM: %s, CPU: %s, Resolution: %s, Dpi: %s, SerialNo: %s]",
								isEmulator,
								model,
								os,
								apiLevel,
								ram,
								cpu,
								resolution,
								dpi,
								serialNumber);
	}
}
