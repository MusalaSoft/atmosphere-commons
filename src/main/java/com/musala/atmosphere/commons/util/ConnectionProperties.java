package com.musala.atmosphere.commons.util;

/**
 * Template used in classes that contain information about a remote connection.
 * 
 * @author yordan.petrov
 * 
 */
public interface ConnectionProperties {
    /**
     * Gets the remote IP address used for connection.
     * 
     * @return the remote IP address used for connection.
     */
    public String getIp();

    /**
     * Sets the remote IP address used for connection.
     * 
     * @param ip
     *        the remote IP address used for connection.
     */
    public void setIp(String ip);

    /**
     * Gets the remote port used for connection.
     * 
     * @return the remote port used for connection.
     */
    public int getPort();

    /**
     * Sets the remote port used for connection.
     * 
     * @param port
     *        the remote port used for connection.
     */
    public void setPort(int port);

    /**
     * Gets the maximum number of reconnection attempts.
     * 
     * @return the maximum number of reconnection attempts.
     */
    public int getConnectionRetryLimit();

    /**
     * Sets the maximum number of reconnection attempts.
     * 
     * @param connectionRetryLimit
     *        the maximum number of reconnection attempts.
     */
    public void setConnectionRetryLimit(int connectionRetryLimit);
}
