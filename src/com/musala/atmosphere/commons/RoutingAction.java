package com.musala.atmosphere.commons;

import java.io.Serializable;
import java.util.List;

import com.musala.atmosphere.commons.beans.DeviceAcceleration;
import com.musala.atmosphere.commons.beans.DeviceMagneticField;
import com.musala.atmosphere.commons.beans.DeviceOrientation;
import com.musala.atmosphere.commons.beans.DeviceProximity;
import com.musala.atmosphere.commons.beans.MobileDataState;
import com.musala.atmosphere.commons.beans.PhoneNumber;
import com.musala.atmosphere.commons.beans.SwipeDirection;
import com.musala.atmosphere.commons.gesture.Gesture;
import com.musala.atmosphere.commons.ui.UiElementDescriptor;
import com.musala.atmosphere.commons.util.AtmosphereIntent;
import com.musala.atmosphere.commons.util.GeoLocation;
import com.musala.atmosphere.commons.util.Pair;

/**
 * Enumerates all actions that can be invoked on a device wrapper instance in the agent component.
 * 
 * @author georgi.gaydarov
 * 
 */
public enum RoutingAction implements Serializable {
    /**
     * Invokes the method behind UI element field clearing. Requires a {@link UiElementDescriptor} instance (the element
     * descriptor for the element that should be cleared) as a parameter.
     */
    CLEAR_FIELD(new RoutingActionArgumentValidator(UiElementDescriptor.class)),
    /**
     * Invokes the method behind UI element wait for existence. Requires a {@link UiElementDescriptor} instance (the
     * element descriptor for the element that should exist after given time) as a parameter.
     */
    WAIT_FOR_EXISTS(new RoutingActionArgumentValidator(UiElementDescriptor.class), new RoutingActionArgumentValidator(Integer.class)),
    /**
     * Invokes the method behind UI element wait until gone. Requires a {@link UiElementDescriptor} instance (the
     * element descriptor for the element that should exist after given time) as a parameter.
     */
    WAIT_UNTIL_GONE(new RoutingActionArgumentValidator(UiElementDescriptor.class), new RoutingActionArgumentValidator(Integer.class)),
    /**
     * Invokes the method behind waiting for a window update event to occur for a given package. Requires a
     * <code>String</code> package name and a <code>int</code> timeout value.
     */
    WAIT_FOR_WINDOW_UPDATE(new RoutingActionArgumentValidator(String.class, true), new RoutingActionArgumentValidator(Integer.class)),
    /**
     * Invokes the device free RAM amount getting method, which returns a {@link Long} instance (memory in Mb).
     */
    GET_FREE_RAM,
    /**
     * Invokes the method behind device shell command execution, which returns a {@link String} instance (result of the
     * execution).
     */
    EXECUTE_SHELL_COMMAND(new RoutingActionArgumentValidator(String.class)),
    /**
     * Invokes the method behind sequential shell command execution (passed as a {@link List<String>}, which returns a
     * {@link List<String> instance (command execution results).
     */
    EXECUTE_SHELL_COMMAND_SEQUENCE(new RoutingActionArgumentValidator(List.class)),
    /**
     * Broadcast the given intent to all interested BroadcastReceivers on the current device.
     */
    SEND_BROADCAST(new RoutingActionArgumentValidator(AtmosphereIntent.class)),
    /**
     * Invokes the method behind fetching a {@link DeviceInformation DeviceInformation} instance for the current device.
     */
    GET_DEVICE_INFORMATION,
    /**
     * Invokes the method that gets a JPEG screenshot image and returns it as an array of bytes that, when dumped to a
     * file, shows the device display.
     */
    GET_SCREENSHOT,
    /**
     * Invokes the method that prepares a device for APK file transfer and installation.
     */
    APK_INIT_INSTALL,
    /**
     * Invokes the method behind appending bytes to the .apk file that is currently being built. Requires a byte array
     * (the actual data) and an integer (the byte array length) as parameters.
     */
    APK_APPEND_DATA(new RoutingActionArgumentValidator(byte[].class), new RoutingActionArgumentValidator(Integer.class)),
    /**
     * Invokes the method behind building, uploading and installing the transfered .apk file on the current device.
     * Requires a boolean (to force install or not) as parameter.
     */
    APK_BUILD_AND_INSTALL(new RoutingActionArgumentValidator(Boolean.class)),
    /**
     * Invokes the method behind discarding all data that was previously transferred using {@link #APK_APPEND_DATA} and
     * frees the resources allocated by using {@link #APK_INIT_INSTALL}.
     */
    APK_DISCARD,
    /**
     * Invokes the method that gets the UIAutomator UI XML dump from a device and returns it as a string.
     */
    GET_UI_XML_DUMP,
    /**
     * Invokes the method that gets the device power environment properties as a {@link PowerProperties} instance.
     */
    GET_POWER_PROPERTIES,
    /**
     * Invokes the method that sets the device power-related environment properties. Requires a {@link PowerProperties}
     * instance (the new power environment data container) as a parameter.
     */
    SET_POWER_PROPERTIES(new RoutingActionArgumentValidator(PowerProperties.class)),
    /**
     * Invokes the method that sets the device WiFi state (on or off). Requires a boolean (the new WiFi state) as a
     * parameter.
     */
    SET_WIFI_STATE(new RoutingActionArgumentValidator(Boolean.class)),
    /**
     * Invokes the method that sets the device mobile data state of an <b>emulator</b>. Requires a
     * {@link MobileDataState} instance (the new mobile data state) as a parameter.
     */
    SET_MOBILE_DATA_STATE(new RoutingActionArgumentValidator(MobileDataState.class)),
    /**
     * Invokes the method that sets the device acceleration readings of an <b>emulator</b>. Requires a
     * {@link DeviceAcceleration} instance (the new acceleration readings) as a parameter.
     */
    SET_ACCELERATION(new RoutingActionArgumentValidator(DeviceAcceleration.class)),
    /**
     * Invokes the method that sets the device magnetic field of an <b>emulator</b>. Requires a
     * {@link DeviceMagneticField} instance (the new acceleration readings) as a parameter.
     */
    SET_MAGNETIC_FIELD(new RoutingActionArgumentValidator(DeviceMagneticField.class)),
    /**
     * Invokes the method that sets the device proximity readings of an <b>emulator</b>. Requires a
     * {@link DeviceProximity} instance (the new proximity readings) as a parameter.
     */
    SET_PROXIMITY(new RoutingActionArgumentValidator(Float.class)),
    /**
     * Invokes the method that sets the device orientation of an <b>emulators</b>. Requires a {@link DeviceOrientation}
     * instance (the new device acceleration readings) as a parameter.
     */
    SET_ORIENTATION(new RoutingActionArgumentValidator(DeviceOrientation.class)),
    /**
     * Invokes the method that sets the device maximum upload/download speed. Requires a {@link Pair<Integer, Integer>}
     * instance (the new upload/download speeds) as a parameter.
     */
    SET_NETWORK_SPEED(new RoutingActionArgumentValidator(Pair.class)),
    /**
     * Invokes the method behind predefined gesture execution. Requires a {@link Gesture} instance (the predefined
     * gesture) as a parameter.
     */
    PLAY_GESTURE(new RoutingActionArgumentValidator(Gesture.class)),
    /**
     * Invokes the method that obtains information about the telephony services on the device. Returns a
     * {@link TelephonyInformation} data container instance.
     */
    GET_TELEPHONY_INFO,
    /**
     * Invokes the method that gets the device mobile data state. Returns a {@link ConnectionType} instance.
     */
    GET_CONNECTION_TYPE,
    /**
     * Invokes the method that gets the device orientation. The orientation sensor on the device must be active. Returns
     * a {@link DeviceOrientation} data container instance.
     */
    GET_DEVICE_ORIENTATION,
    /**
     * Invokes the method that gets the device acceleration. The acceleration sensor on the device must be active.
     * Returns a {@link DeviceAcceleration} data container instance.
     * */
    GET_DEVICE_ACCELERATION,
    /**
     * Invokes the method that gets the device proximity. The proximity sensor on the device must be active. Returns a
     * float representing the device proximity.
     */
    GET_DEVICE_PROXIMITY,
    /**
     * Invokes the method that gets the device mobile data state of an <b>emulator</b>. Returns a
     * {@link MobileDataState} enum instance.
     */
    GET_MOBILE_DATA_STATE,
    /**
     * Invokes the method that cancels a call to an emulator. Requires a {@link PhoneNumber} instance (the phone number
     * that cancels the call) as a parameter.
     */
    CALL_CANCEL(new RoutingActionArgumentValidator(PhoneNumber.class)),
    /**
     * Invokes the method that holds a call to an emulator. Requires a {@link PhoneNumber} instance (the phone number
     * that holds the call) as a parameter.
     */
    CALL_HOLD(new RoutingActionArgumentValidator(PhoneNumber.class)),
    /**
     * Invokes the method that sends a call to an emulator. Requires a {@link PhoneNumber} instance (the phone number
     * that makes the call) as a parameter.
     */
    CALL_RECEIVE(new RoutingActionArgumentValidator(PhoneNumber.class)),
    /**
     * Invokes the method that accepts a call to an emulator. Requires a {@link PhoneNumber} instance (the phone number
     * that calls and should be answered) as a parameter.
     */
    CALL_ACCEPT(new RoutingActionArgumentValidator(PhoneNumber.class)),
    /**
     * Invokes the method that sends an SMS to an emulator. Requires a {@link SmsMessage} instance (the SMS information)
     * as a parameter.
     */
    SMS_RECEIVE(new RoutingActionArgumentValidator(SmsMessage.class)),
    /**
     * Invokes the method behind UI element swiping. Requires a {@link UiElementDescriptor} instance (the element
     * descriptor for the element that should be swiped) and {@link SwipeDirection} enum member (the swipe direction) as
     * parameters.
     */
    ELEMENT_SWIPE(new RoutingActionArgumentValidator(UiElementDescriptor.class), new RoutingActionArgumentValidator(SwipeDirection.class)),
    /**
     * Invokes the method that starts an application in the service. Requires a {@link String} package name as a
     * parameter. Returns a <code>boolean</code> indicator of the operation success.
     */
    START_APP(new RoutingActionArgumentValidator(String.class)),
    /**
     * Queries the ATMOSPHERE Service for the awake status of the device. Returns <code>true</code> if the device is
     * awake and <code>false</code>.
     */
    GET_AWAKE_STATUS,
    /**
     * Invokes the method that checks if there are running Processes with the given package. Returns <code>true</code>
     * if there are such processes and <code>false</code> otherwise.
     */
    GET_PROCESS_RUNNING(new RoutingActionArgumentValidator(String.class)),
    /**
     * Invokes the method that force stops a process by given package. Requires a {@link String} package name as a
     * parameter.
     */
    FORCE_STOP_PROCESS(new RoutingActionArgumentValidator(String.class)),
    /**
     * Invokes the method that save stops a background process by given package. Requires a {@link String} package name
     * as a parameter.
     */
    STOP_BACKGROUND_PROCESS(new RoutingActionArgumentValidator(String.class)),
    /**
     * Routes scrolling in some direction to the ATMOSPHERE Service. Requires {@link UiElementDescriptor} instance (the
     * UI element that would be scrolled), maximum swipes and steps to execute and a boolean to determine whether the
     * view is with vertical orientation or not.
     */
    SCROLL_TO_DIRECTION(new RoutingActionArgumentValidator(ScrollDirection.class), new RoutingActionArgumentValidator(UiElementDescriptor.class), new RoutingActionArgumentValidator(Integer.class), new RoutingActionArgumentValidator(Integer.class), new RoutingActionArgumentValidator(Boolean.class)),
    /**
     * Invokes the method behind UI device open notification bar.
     */
    OPEN_NOTIFICATION_BAR,
    /**
     * Invokes the method behind UI device open quick settings.
     */
    OPEN_QUICK_SETTINGS,
    /**
     * Sets the IME with the given ID as default on the device.
     */
    SET_DEFAULT_INPUT_METHOD(new RoutingActionArgumentValidator(String.class)),
    /**
     * Sets the Atmosphere IME as default on the device.
     */
    SET_ATMOSPHERE_IME_AS_DEFAULT,
    /**
     * Invokes the method that uninstalls an application process by given package. Requires a {@link String} package
     * name as a parameter.
     */
    UNINSTALL_APP(new RoutingActionArgumentValidator(String.class)),
    /**
     * Mocks the current location of the device. Requires a {@link GeoLocation} object representing the location to be
     * mocked.
     */
    MOCK_LOCATION(new RoutingActionArgumentValidator(GeoLocation.class)),
    /**
     * Disables mocking a location provider on the device. Requires a {@link String} object representing the provider
     * name.
     */
    DISABLE_MOCK_LOCATION(new RoutingActionArgumentValidator(String.class)),
    /**
     * Sets the state of the keyguard of the device.
     */
    SET_KEYGUARD(new RoutingActionArgumentValidator(Boolean.class)),
    /**
     * Used to request bring to front a given task on the device.
     */
    BRING_TASK_TO_FRONT(new RoutingActionArgumentValidator(Integer.class), new RoutingActionArgumentValidator(Integer.class)),
    /**
     * Used to request getting the running tasks ids on the device.
     */
    GET_RUNNING_TASK_IDS(new RoutingActionArgumentValidator(Integer.class)),
    /**
     * Used to request wait method for the given task to go to the given position in Running tasks.
     */
    WAIT_FOR_TASKS_UPDATE(new RoutingActionArgumentValidator(Integer.class), new RoutingActionArgumentValidator(Integer.class), new RoutingActionArgumentValidator(Integer.class)),
    /**
     * Used to execute shell command in a separated thread.
     */
    EXECUTE_SHELL_COMMAND_IN_BACKGROUND(new RoutingActionArgumentValidator(String.class)),
    /**
     * Used to interrupt the execution of a process that is executed in a separate thread.
     */
    INTERRUPT_BACKGROUND_SHELL_PROCESS(new RoutingActionArgumentValidator(String.class)),
    /**
     * Used to check the lock state of the device.
     */
    IS_LOCKED,
    /**
     * Pulls a single file from the device and saves it locally.
     */
    PULL_FILE(new RoutingActionArgumentValidator(String.class), new RoutingActionArgumentValidator(String.class)),
    /**
     * Gets the UI tree representation of the current screen.
     */
    GET_UI_TREE(new RoutingActionArgumentValidator(Boolean.class)),
    /**
     * Starts recording actions executed on the device.
     */
    START_RECORDING,
    /**
     * Stops recording actions executed on the device.
     */
    STOP_RECORDING,
    /**
     * Used to open the location settings activity of the device.
     */
    OPEN_LOCATION_SETTINGS,
    /**
     * Used to check the GPS location state of the device.
     */
    IS_GPS_LOCATION_ENABLED;

    private RoutingActionArgumentValidator[] argumentValidators;

    /**
     * Validates if the passed arguments are valid for the current command.
     * 
     * @param args
     *        - the command arguments.
     */
    public void validateArguments(Object[] args) {
        if (argumentValidators.length != args.length) {
            throw new IllegalArgumentException("Passed arguments count does not match expected argument count.");
        }

        for (int i = 0; i < argumentValidators.length; i++) {
            try {
                argumentValidators[i].validateArgument(args[i]);
            } catch (IllegalArgumentException e) {
                String errorMessage = String.format("Validation of command argument number %d failed.", i);
                throw new IllegalArgumentException(errorMessage, e);
            }
        }
    }

    private RoutingAction(RoutingActionArgumentValidator... validators) {
        argumentValidators = validators;
    }
}
