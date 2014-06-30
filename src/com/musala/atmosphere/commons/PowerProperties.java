package com.musala.atmosphere.commons;

import java.io.Serializable;

import com.musala.atmosphere.commons.beans.BatteryLevel;
import com.musala.atmosphere.commons.beans.BatteryState;
import com.musala.atmosphere.commons.beans.PowerSource;

/**
 * Data container used for fetching device power-related state and modifying this same environment state. Houses
 * {@link BatteryState}, battery level and external power supply connectivity state.
 * 
 * @author georgi.gaydarov
 * 
 */
public class PowerProperties implements Serializable {
    /**
     * auto-generated serialization id
     */
    private static final long serialVersionUID = -7654104783965352503L;

    /**
     * When this {@link PowerProperties} object will be used for environment modifying, setting this constant as the new
     * battery state will result in leaving the battery state on the device unchanged.
     */
    public static final BatteryState LEAVE_BATTERY_STATE_UNCHANGED = null;

    /**
     * When this {@link PowerProperties} object will be used for environment modifying, setting this constant as the new
     * battery level will result in leaving the battery level on the device unchanged.
     */
    public static final BatteryLevel LEAVE_BATTERY_LEVEL_UNCHANGED = null;

    /**
     * When this {@link PowerProperties} object will be used for environment modifying, setting this constant as the new
     * external power supply connectivity state will result in leaving the power state on the device unchanged.
     */
    public static final PowerSource LEAVE_POWER_SOURCE_UNCHANGED = null;

    /**
     * Constructor that sets all the power related fields to their corresponding LEAVE UNCHANGED values.
     */
    public PowerProperties() {
        batteryState = LEAVE_BATTERY_STATE_UNCHANGED;
        batteryLevel = LEAVE_BATTERY_LEVEL_UNCHANGED;
        powerSource = LEAVE_POWER_SOURCE_UNCHANGED;
    }

    private BatteryState batteryState;

    private BatteryLevel batteryLevel;

    private PowerSource powerSource;

    /**
     * Sets the battery state that will be used when this {@link PowerProperties} is sent to the device.<br>
     * <i>On real devices, the battery state will only remain the set value for limited time, until Android
     * BatteryManager updates the battery information.</i>
     * 
     * @param batteryState
     *        - new {@link BatteryState} to be set (or {@link PowerProperties#LEAVE_BATTERY_STATE_UNCHANGED}).
     * @return this instance.
     */
    public PowerProperties setBatteryState(BatteryState state) {
        batteryState = state;
        return this;
    }

    /**
     * If this object was fetched from a device, returns the battery state of the device at the fetching moment.<br>
     * If this object is intended to be sent to a device for environment modifying, returns the currently set battery
     * state in this container.
     * 
     * @return Battery state of a device, or a set value for environment modifying.
     */
    public BatteryState getBatteryState() {
        return batteryState;
    }

    /**
     * Sets the battery level that will be used when this {@link PowerProperties} is sent to the device.<br>
     * <i>On real devices, the battery level will only remain the set value for limited time, until Android
     * BatteryManager updates the battery information.</i>
     * 
     * @param batteryLevel
     *        - new battery level in percent to be set (or {@link PowerProperties#LEAVE_BATTERY_LEVEL_UNCHANGED}).
     * @return this instance.
     */
    public PowerProperties setBatteryLevel(BatteryLevel level) {
        batteryLevel = level;
        return this;
    }

    /**
     * If this object was fetched from a device, returns the battery level of the device at the fetching moment.<br>
     * If this object is intended to be sent to a device for environment modifying, returns the currently set battery
     * level in this container.
     * 
     * @return Battery level of a device, or a set value for environment modifying.
     */
    public BatteryLevel getBatteryLevel() {
        return batteryLevel;
    }

    /**
     * Sets the external power source state of this device.<br>
     * <i>On real devices, the power state will only remain the set value for limited time, until Android BatteryManager
     * updates the power connection state information.</i>
     * 
     * @param powerSource
     *        - a {@link PowerSource} enum instance.
     * @return this instance.
     */
    public PowerProperties setPowerSource(PowerSource powerSource) {
        this.powerSource = powerSource;
        return this;
    }

    /**
     * If this object was fetched from a device, returns the external power supply connectivity state of the device at
     * the fetching moment.<br>
     * If this object is intended to be sent to a device for environment modifying, returns the currently set external
     * power supply connectivity state in this container.
     * 
     * @return external power supply connectivity state of a device, or a set value for environment modifying.
     */
    public PowerSource getPowerSource() {
        return powerSource;
    }
}
