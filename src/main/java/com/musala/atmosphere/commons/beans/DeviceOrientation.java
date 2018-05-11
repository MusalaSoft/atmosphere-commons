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

package com.musala.atmosphere.commons.beans;

import java.io.Serializable;

import com.musala.atmosphere.commons.parameters.CommandParameter;

/**
 * Container class for the device orientation in space.
 * 
 * @author yordan.petrov
 * 
 */
public class DeviceOrientation implements Serializable, CommandParameter {
    private static final long serialVersionUID = 5579467936945061534L;

    /**
     * Default orientation variables, used in the class constructor.
     */
    private static final float DEFAULT_AZIMUTH = 0;

    private static final float DEFAULT_PITCH = 0;

    private static final float DEFAULT_ROLL = 0;

    /**
     * Azimuth, angle between the magnetic north direction and the y-axis, around the z-axis (0 to 359). 0=North,
     * 90=East, 180=South, 270=West
     */
    private float azimuth;

    /**
     * Pitch, rotation around x-axis (-180 to 180), with positive values when the z-axis moves toward the y-axis.
     */
    private float pitch;

    /**
     * Roll, rotation around the y-axis (-90 to 90) increasing as the device moves clockwise.
     */
    private float roll;

    /**
     * Creates new instance of the class setting the fields to the default variables.
     */
    public DeviceOrientation() {
        azimuth = DEFAULT_AZIMUTH;
        pitch = DEFAULT_PITCH;
        roll = DEFAULT_ROLL;
    }

    /**
     * Creates a new instance of the class setting the fields to the given arguments.
     * 
     * @param azimuth
     *        - angle between the magnetic north direction and the y-axis, around the z-axis (0 to 359). 0=North,
     *        90=East, 180=South, 270=West
     * @param pitch
     *        - rotation around x-axis (-180 to 180), with positive values when the z-axis moves toward the y-axis.
     * @param roll
     *        - rotation around the y-axis (-90 to 90) increasing as the device moves clockwise.
     */
    public DeviceOrientation(float azimuth, float pitch, float roll) {
        if (azimuth < 0 || azimuth >= 360) {
            throw new IllegalArgumentException(azimuth + " is out of azimuth range.");
        } else {
            this.azimuth = azimuth;
        }
        if (pitch < -180 || pitch > 180) {
            throw new IllegalArgumentException(pitch + " is out of pitch range.");
        } else {
            this.pitch = pitch;
        }
        if (roll < -90 || roll > 90) {
            throw new IllegalArgumentException(roll + " is out of roll range.");
        } else {
            this.roll = roll;
        }
    }

    /**
     * Gets new {@link DeviceOrientation} instance in portrait orientation.
     * 
     * @return - new {@link DeviceOrientation} instance in portrait orientation.
     */
    public static DeviceOrientation getPortraitOrientation() {
        final float PORTRAIT_AZIMUTH = 0.0f;
        final float PORTRAIT_PITCH = -90.0f;
        final float PORTRAIT_ROLL = 0.0f;
        DeviceOrientation deviceOrientation = new DeviceOrientation(PORTRAIT_AZIMUTH, PORTRAIT_PITCH, PORTRAIT_ROLL);
        return deviceOrientation;
    }

    /**
     * Gets new {@link DeviceOrientation} instance in landscape orientation.
     * 
     * @return new {@link DeviceOrientation} instance in landscape orientation.
     */
    public static DeviceOrientation getLandscapeOrientation() {
        final float LANDSCAPE_AZIMUTH = 0.0f;
        final float LANDSCAPE_PITCH = 0.0f;
        final float LANDSCAPE_ROLL = -90.0f;
        DeviceOrientation deviceOrientation = new DeviceOrientation(LANDSCAPE_AZIMUTH, LANDSCAPE_PITCH, LANDSCAPE_ROLL);
        return deviceOrientation;
    }

    /**
     * Gets new {@link DeviceOrientation} instance in upside down portrait orientation.
     * 
     * @return - new {@link DeviceOrientation} instance in upside down portrait orientation.
     */
    public static DeviceOrientation getUpsideDownPortrait() {
        final float UPSIDE_DOWN_PORTRAIT_AZIMUTH = 0.0f;
        final float UPSIDE_DOWN_PORTRAIT_PITCH = 90.0f;
        final float UPSIDE_DOWN_PORTRAIT_ROLL = 0.0f;
        DeviceOrientation deviceOrientation = new DeviceOrientation(UPSIDE_DOWN_PORTRAIT_AZIMUTH,
                                                                    UPSIDE_DOWN_PORTRAIT_PITCH,
                                                                    UPSIDE_DOWN_PORTRAIT_ROLL);
        return deviceOrientation;
    }

    /**
     * Gets new {@link DeviceOrientation} instance in upside down landscape orientation.
     * 
     * @return - new {@link DeviceOrientation} instance in upside down landscape orientation.
     */
    public static DeviceOrientation getUpsideDownLandscape() {
        final float UPSIDE_DOWN_LANDSCAPE_AZIMUTH = 0.0f;
        final float UPSIDE_DOWN_LANDSCAPE_PITCH = 0.0f;
        final float UPSIDE_DOWN_LANDSCAPE_ROLL = 90.0f;
        DeviceOrientation deviceOrientation = new DeviceOrientation(UPSIDE_DOWN_LANDSCAPE_AZIMUTH,
                                                                    UPSIDE_DOWN_LANDSCAPE_PITCH,
                                                                    UPSIDE_DOWN_LANDSCAPE_ROLL);
        return deviceOrientation;
    }

    /**
     * Sets device azimuth orientation north.
     */
    public void setOrientationNorth() {
        azimuth = 0.0f;
    }

    /**
     * Sets device azimuth orientation east.
     */
    public void setOrientationEast() {
        azimuth = 90.0f;
    }

    /**
     * Sets device azimuth orientation south.
     */
    public void setOrientationSouth() {
        azimuth = 180.0f;
    }

    /**
     * Sets device azimuth orientation west.
     */
    public void setOrientationWest() {
        azimuth = 270.0f;
    }

    /**
     * Sets device orientation azimuth.
     * 
     * @param azimuth
     *        - angle between the magnetic north direction and the y-axis, around the z-axis (0 to 359). 0=North,
     *        90=East, 180=South, 270=West
     */
    public void setAzimuth(float azimuth) {
        if (azimuth < 0 || azimuth >= 360) {
            throw new IllegalArgumentException(azimuth + "is out of azimuth range.");
        } else {
            this.azimuth = azimuth;
        }
    }

    /**
     * Gets device orientation azimuth.
     * 
     * @return - angle between the magnetic north direction and the y-axis, around the z-axis (0 to 359). 0=North,
     *         90=East, 180=South, 270=West
     */
    public float getAzimuth() {
        return azimuth;
    }

    /**
     * Sets device orientation pitch.
     * 
     * @param pitch
     *        - rotation around x-axis (-180 to 180), with positive values when the z-axis moves toward the y-axis.
     */
    public void setPitch(float pitch) {
        if (pitch < -180 || pitch > 180) {
            throw new IllegalArgumentException(pitch + "is out of pitch range.");
        } else {
            this.pitch = pitch;
        }
    }

    /**
     * Gets device orientation pitch.
     * 
     * @return - rotation around x-axis (-180 to 180), with positive values when the z-axis moves toward the y-axis.
     */
    public float getPitch() {
        return pitch;
    }

    /**
     * Sets device orientation roll.
     * 
     * @param roll
     *        - rotation around the y-axis (-90 to 90) increasing as the device moves clockwise.
     */
    public void setRoll(float roll) {
        if (roll < -90 || roll > 90) {
            throw new IllegalArgumentException(roll + "is out of roll range.");
        } else {
            this.roll = roll;
        }
    }

    /**
     * Gets device orientation roll.
     * 
     * @return - rotation around the y-axis (-90 to 90) increasing as the device moves clockwise.
     */
    public float getRoll() {
        return roll;
    }

    /**
     * Parses the {@link DeviceOrientation} object in format suitable for the emulator console.
     * 
     * @return - string in format suitable to the emulator console.
     */
    public String parseCommand() {

        return String.format("%s:%s:%s", azimuth, pitch, roll);
    }

    @Override
    public String toString() {
        String orientationString = String.format("[azimuth: %s, pitch: %s, roll: %s]", azimuth, pitch, roll);
        return orientationString;
    }

    @Override
    public String getParameterValue(boolean forEmulator) {
        return parseCommand();
    }
}
