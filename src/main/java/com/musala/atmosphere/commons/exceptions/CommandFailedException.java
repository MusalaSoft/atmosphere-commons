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
 * Thrown when an action execution on a device has failed.
 * 
 * @author georgi.gaydarov
 * 
 */
public class CommandFailedException extends Exception {
    private static final long serialVersionUID = -3879797786566060077L;

    public CommandFailedException() {
    }

    public CommandFailedException(String message) {
        super(message);
    }

    public CommandFailedException(String message, Throwable inner) {
        super(message, inner);
    }
}
