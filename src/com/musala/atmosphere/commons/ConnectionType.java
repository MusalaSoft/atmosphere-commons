package com.musala.atmosphere.commons;

public enum ConnectionType
{
	MOBILE("MOBILE"), WIFI("WIFI"), NONE("NONE");

	String connectionType;

	private ConnectionType(String connectionType)
	{
		this.connectionType = connectionType;
	}

	ConnectionType getMemberByString(String typeString)
	{
		ConnectionType typeToReturn = null;
		for (ConnectionType connectionType : ConnectionType.values())
		{
			String connectionTypeString = connectionType.toString();

			if (connectionTypeString.equals(typeString.toUpperCase()))
			{
				typeToReturn = connectionType;
				break;
			}
		}
		return typeToReturn;
	}
}
