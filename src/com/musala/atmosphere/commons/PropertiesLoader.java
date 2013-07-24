package com.musala.atmosphere.commons;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Handles the opening and reading of properties files.
 * 
 * @author valyo.yolovski
 * 
 */
public class PropertiesLoader
{
	private Properties configProperties;

	private final static Logger LOGGER = Logger.getLogger(PropertiesLoader.class.getCanonicalName());

	private String configFileLocation;

	private static HashMap<String, PropertiesLoader> configFileToPropertiesLoaderInstances = new HashMap<String, PropertiesLoader>();

	/**
	 * Returns the {@link PropertiesLoader PropertiesLoader} instance for the specified file.
	 * 
	 * @param configFileLocation
	 *        - the config file which we want an instance for.
	 * @return the requested {@link PropertiesLoader PropertiesLoader} instance.
	 */
	public static PropertiesLoader getInstance(String configFileLocation)
	{
		PropertiesLoader propertiesLoaderInstance = configFileToPropertiesLoaderInstances.get(configFileLocation);

		if (propertiesLoaderInstance == null)
		{
			PropertiesLoader propertiesLoader = new PropertiesLoader(configFileLocation);
			configFileToPropertiesLoaderInstances.put(configFileLocation, propertiesLoader);

			return propertiesLoader;
		}
		else
		{
			return propertiesLoaderInstance;
		}
	}

	private PropertiesLoader(String configFileLocation)
	{
		this.configFileLocation = configFileLocation;
	}

	private synchronized Properties readInConfigFile(String fileName)
	{
		try
		{
			Properties properties = new Properties();
			FileReader readInPropertiesFile = new FileReader(fileName);
			properties.load(readInPropertiesFile);
			LOGGER.info(fileName + " has been loaded.");
			return properties;
		}
		catch (IOException e)
		{
			LOGGER.fatal(fileName + " loading failed.", e);
			throw new RuntimeException("Could not load config file.");
		}
	}

	/**
	 * Returns the desired property from the config file in String type.
	 * 
	 * @param property
	 *        The Agent property to be returned.
	 * @return Returns the desired agent property value. Returns String properties only!
	 */
	public synchronized String getPropertyString(String property)
	{
		if (configProperties == null)
		{
			configProperties = readInConfigFile(configFileLocation);
		}

		String resultProperty = configProperties.getProperty(property);
		if (resultProperty == null)
		{
			LOGGER.fatal("Property " + property + " could not be found in the properties file.");
			throw new RuntimeException("Property " + property + " could not be found in the properties file.");
		}

		return resultProperty;
	}
}
