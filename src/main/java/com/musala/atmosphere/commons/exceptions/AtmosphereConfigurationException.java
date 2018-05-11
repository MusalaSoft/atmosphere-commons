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
 * Thrown in cases of wrong configuration set.
 *
 * @author filareta.yordanova
 *
 */
public class AtmosphereConfigurationException extends AtmosphereRuntimeException {
    private static final long serialVersionUID = -5550348639878749992L;

    /**
     * Creates new {@link AtmosphereConfigurationException AtmosphereConfigurationException}.
     */
    public AtmosphereConfigurationException() {
        super();
    }

    /**
     * Creates new {@link AtmosphereConfigurationException AtmosphereConfigurationException} with the given message.
     *
     * @param message
     *        - message representing the error that occurred
     */
    public AtmosphereConfigurationException(String message) {
        super(message);
    }

    /**
     * Creates new {@link AtmosphereConfigurationException AtmosphereConfigurationException} with the given message and
     * the {@link Throwable cause} for the exception.
     *
     * @param message
     *        - message representing the error that occurred
     * @param cause
     *        - the cause for the exception
     */
    public AtmosphereConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
