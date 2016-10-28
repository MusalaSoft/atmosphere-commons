package com.musala.atmosphere.commons;

/**
 * Enumeration that contains the different network connection types as defined by android.net.ConnectivityManager.
 * 
 * @author yordan.petrov
 * 
 */
public enum ConnectionType {
    /**
     * The Bluetooth data connection. When active, all data traffic will use this network type's interface by default
     * (it has a default route).
     */
    BLUETOOTH(7),

    /**
     * Dummy data connection. This should not be used on shipping devices.
     */
    DUMMY(8),

    /**
     * The Ethernet data connection. When active, all data traffic will use this network type's interface by default (it
     * has a default route).
     */
    ETHERNET(9),

    /**
     * The Mobile data connection. When active, all data traffic will use this network type's interface by default (it
     * has a default route).
     */
    MOBILE(0),

    /**
     * A DUN-specific Mobile data connection. This network type may use the same network interface as
     * {@link ConnectionType#MOBILE} or it may use a different one. This is sometimes by the system when setting up an
     * upstream connection for tethering so that the carrier is aware of DUN traffic.
     */
    MOBILE_DUN(4),

    /**
     * A High Priority Mobile data connection. This network type uses the same network interface as
     * {@link ConnectionType#MOBILE} but the routing setup is different.
     */
    MOBILE_HIPRI(5),

    /**
     * An MMS-specific Mobile data connection. This network type may use the same network interface as
     * {@link ConnectionType#MOBILE} or it may use a different one. This is used by applications needing to talk to the
     * carrier's Multimedia Messaging Service servers.
     */
    MOBILE_MMS(2),

    /**
     * A SUPL-specific Mobile data connection. This network type may use the same network interface as
     * {@link ConnectionType#MOBILE} or it may use a different one. This is used by applications needing to talk to the
     * carrier's Secure User Plane Location servers for help locating the device.
     */
    MOBILE_SUPL(3),

    /**
     * The WIFI data connection. When active, all data traffic will use this network type's interface by default (it has
     * a default route).
     */
    WIFI(1),

    /**
     * The WiMAX data connection. When active, all data traffic will use this network type's interface by default (it
     * has a default route).
     */
    WIMAX(6),

    /**
     * The device is not connected to any network.
     */
    NONE(-1);

    private int intValue;

    private ConnectionType(int intValue) {
        this.intValue = intValue;
    }

    /**
     * Gets the connection type identifier.
     * 
     * @return the connection type identifier.
     */
    public int getId() {
        return intValue;
    }

    /**
     * Returns a {@link ConnectionType} object by a given identifier.
     * 
     * @param id
     *        - the connection type identifier.
     * @return a {@link ConnectionType} object by a given identifier.
     */
    public static ConnectionType getById(int id) {
        ConnectionType typeById = null;
        for (ConnectionType currentType : ConnectionType.values()) {
            if (currentType.getId() == id) {
                typeById = currentType;
                break;
            }
        }

        return typeById;
    }
}
