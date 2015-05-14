package com.musala.atmosphere.commons.sa.exceptions;

import com.musala.atmosphere.commons.exceptions.AtmosphereRuntimeException;

/**
 * Thrown when there is no available device to get.
 * 
 * @author yavor.stankov
 * 
 */
public class NoAvailableDeviceFoundException extends AtmosphereRuntimeException {

    private static final long serialVersionUID = 6041987155545023840L;

    public NoAvailableDeviceFoundException() {
    }

    public NoAvailableDeviceFoundException(String message) {
        super(message);
    }

    public NoAvailableDeviceFoundException(String message, Throwable inner) {
        super(message, inner);
    }

}
