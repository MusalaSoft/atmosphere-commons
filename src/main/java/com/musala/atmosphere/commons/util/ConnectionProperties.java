// This file is part of the ATMOSPHERE mobile testing framework.
// Copyright (C) 2016 MusalaSoft
//
// ATMOSPHERE is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// ATMOSPHERE is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with ATMOSPHERE.  If not, see <http://www.gnu.org/licenses/>.

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
