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

import java.io.Serializable;

import android.location.LocationManager;

/**
 * A data class representing a geographical location.
 * 
 * @author delyan.dimitrov
 * 
 */
public class GeoLocation implements Serializable {
    private static final long serialVersionUID = 8984864257255168643L;

    private static final String DEFAULT_PROVIDER = LocationManager.GPS_PROVIDER;

    private static final float DEFAULT_ACCURACY = 0;

    private double latitude;

    private double longitude;

    private float accuracy;

    private Double altitude;

    private Float bearing;

    private Float speed;

    private String provider;

    /**
     * Creates a location instance with the given latitude and longitude. A default {@link GeoLocation#DEFAULT_PROVIDER
     * provider} will be used as a provider for this location.
     * 
     * @param latitude
     *        - the latitude of the created location, in degrees
     * @param longitude
     *        - the longitude of the created location, in degrees
     */
    public GeoLocation(double latitude, double longitude) {
        this();

        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Creates a location instance with the given latitude, longitude and provider.
     * 
     * @param latitude
     *        - the latitude of the created location, in degrees
     * @param longitude
     *        - the longitude of the created location, in degrees
     * @param provider
     *        - the provider of the created location
     */
    public GeoLocation(double latitude, double longitude, String provider) {
        this(latitude, longitude);

        this.provider = provider;
    }

    private GeoLocation() {
        accuracy = DEFAULT_ACCURACY;
        provider = DEFAULT_PROVIDER;
    }

    /**
     * Get the latitude, in degrees.
     * 
     * @return a double representing the latitude of this location in degrees
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Get the longitude, in degrees.
     * 
     * @return a double number representing the longitude of this location in degrees
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Get the altitude if available, in meters above sea level.
     * 
     * @return a double number representing the altitude of this location if such is set, and null otherwise
     */
    public Double getAltitude() {
        return altitude;
    }

    /**
     * Get the estimated accuracy of this location, in meters.
     * 
     * @return a double number representing the accuracy of this location in meters, 0 if no accuracy is set
     */
    public float getAccuracy() {
        return accuracy;
    }

    /**
     * Get the bearing, in degrees. Bearing is the horizontal direction of travel of this device, and is not related to
     * the device orientation.
     * 
     * @return a double number representing the bearing of this location if such is set, and null otherwise
     */
    public Float getBearing() {
        return bearing;
    }

    /**
     * Get the name of the provider that generated location.
     * 
     * @return the provider of this location
     */
    public String getProvider() {
        return provider;
    }

    /**
     * Get the speed, in meters per second over ground.
     * 
     * @return the speed value, in meters/second over ground, if it is set, null otherwise
     */
    public Float getSpeed() {
        return speed;
    }

    /**
     * Set the latitude, in degrees.
     * 
     * @param latitude
     *        - the latitude of this location, in degrees
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Set the longitude, in degrees.
     * 
     * @param longitude
     *        - the longitude of this location, in degrees
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Set the altitude, in meters above sea level.
     * 
     * @param altitude
     *        - the altitude of this location, in meters above sea level
     */
    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    /**
     * Set the estimated accuracy of this location, in meters.
     * 
     * @param accuracy
     *        - the estimated accuracy of this location, in meters
     */
    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    /**
     * Set the bearing, in degrees. Bearing is the horizontal direction of travel of this device, and is not related to
     * the device orientation. The bearing has to be in the range (0.0, 360].
     * 
     * @param bearing
     *        - the bearing of this location, in degrees
     */
    public void setBearing(Float bearing) {
        this.bearing = bearing;
    }

    /**
     * Sets the name of the provider that generated this location.
     * 
     * @param provider
     *        - the name of the provider that generated this location
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }

    /**
     * Set the speed, in meters per second over ground.
     * 
     * @param speed
     *        - the speed value, in meters/second
     */
    public void setSpeed(Float speed) {
        this.speed = speed;
    }
}
