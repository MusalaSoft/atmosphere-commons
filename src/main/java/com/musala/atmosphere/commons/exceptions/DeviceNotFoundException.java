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

package com.musala.atmosphere.commons.exceptions;

/**
 * This exception is thrown when an action fails, because the server fails to find the target device or an Agent method
 * was invoked with serial number of a device that is not present on the Agent.
 *
 * @author yavor.stankov, georgi.gaydarov
 *
 */
public class DeviceNotFoundException extends Exception {
    private static final long serialVersionUID = 339776069590257729L;

    /**
     * Creates new {@link DeviceNotFoundException} with the given message.
     * 
     * @param message
     *        - message representing the error that occurred
     */
    public DeviceNotFoundException(String message) {
        super(message);
    }

    /**
     * Creates new {@link DeviceNotFoundException} with the given message and {@link Throwable throwable}.
     * 
     * @param message
     *        - message representing the error that occurred
     * @param throwable
     *        - the cause for the exception
     */
    public DeviceNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

}