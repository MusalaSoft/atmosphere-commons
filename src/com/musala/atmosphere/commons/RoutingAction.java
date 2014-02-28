package com.musala.atmosphere.commons;

import java.io.Serializable;
import java.util.List;

import com.musala.atmosphere.commons.beans.DeviceAcceleration;
import com.musala.atmosphere.commons.beans.DeviceOrientation;
import com.musala.atmosphere.commons.beans.MobileDataState;
import com.musala.atmosphere.commons.beans.PhoneNumber;
import com.musala.atmosphere.commons.gesture.Gesture;
import com.musala.atmosphere.commons.ui.UiElementDescriptor;
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
    CLEAR_FIELD(UiElementDescriptor.class),
    /**
     * Invokes the device free RAM amount getting method, which returns a {@link Long} instance (memory in Mb).
     */
    GET_FREE_RAM,
    /**
     * Invokes the method behind device shell command execution, which returns a {@link String} instance (result of the
     * execution).
     */
    EXECUTE_SHELL_COMMAND(String.class),
    /**
     * Invokes the method behind sequential shell command execution (passed as a {@link List<String>}, which returns a
     * {@link List<String> instance (command execution results).
     */
    EXECUTE_SHELL_COMMAND_SEQUENCE(List.class),
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
    APK_APPEND_DATA(byte[].class, Integer.class),
    /**
     * Invokes the method behind building, uploading and installing the transfered .apk file on the current device.
     */
    APK_BUILD_AND_INSTALL,
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
    SET_POWER_PROPERTIES(PowerProperties.class),
    /**
     * Invokes the method that sets the device WiFi state (on or off). Requires a boolean (the new WiFi state) as a
     * parameter.
     */
    SET_WIFI_STATE,
    /**
     * Invokes the method that sets the device mobile data state of an <b>emulator</b>. Requires a
     * {@link MobileDataState} instance (the new mobile data state) as a parameter.
     */
    SET_MOBILE_DATA_STATE(MobileDataState.class),
    /**
     * Invokes the method that sets the device acceleration readings of an <b>emulator</b>. Requires a
     * {@link DeviceAcceleration} instance (the new acceleration readings) as a parameter.
     */
    SET_ACCELERATION(DeviceAcceleration.class),
    /**
     * Invokes the method that sets the device orientation of an <b>emulators</b>. Requires a {@link DeviceOrientation}
     * instance (the new device acceleration readings) as a parameter.
     */
    SET_ORIENTATION(DeviceOrientation.class),
    /**
     * Invokes the method that sets the device maximum upload/download speed. Reqiores a {@link Pair<Integer, Integer>}
     * instance (the new upload/download speeds) as a parameter.
     */
    SET_NETWORK_SPEED(Pair.class),
    /**
     * Invokes the method behind predefined gesture execution. Requires a {@link Gesture} instance (the predefined
     * gesture) as a parameter.
     */
    PLAY_GESTURE(Gesture.class),
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
     * Invokes the method that gets the device acceleration. The orientation sensor on the device must be active.
     * Returns a {@link DeviceAcceleration} data container instance.
     * */
    GET_DEVICE_ACCELERATION,
    /**
     * Invokes the method that gets the device mobile data state of an <b>emulator</b>. Returns a
     * {@link MobileDataState} enum instance.
     */
    GET_MOBILE_DATA_STATE,
    /**
     * Invokes the method that cancels a call to an emulator. Requires a {@link PhoneNumber} instance (the phone number
     * that cancels the call) as a parameter.
     */
    CALL_CANCEL(PhoneNumber.class),
    /**
     * Invokes the method that holds a call to an emulator. Requires a {@link PhoneNumber} instance (the phone number
     * that holds the call) as a parameter.
     */
    CALL_HOLD(PhoneNumber.class),
    /**
     * Invokes the method that sends a call to an emulator. Requires a {@link PhoneNumber} instance (the phone number
     * that makes the call) as a parameter.
     */
    CALL_RECEIVE(PhoneNumber.class),
    /**
     * Invokes the method that accepts a call to an emulator. Requires a {@link PhoneNumber} instance (the phone number
     * that calls and should be answered) as a parameter.
     */
    CALL_ACCEPT(PhoneNumber.class),
    /**
     * Invokes the method that sends an SMS to an emulator. Requires a {@link SmsMessage} instance (the SMS information)
     * as a parameter.
     */
    SMS_RECEIVE(SmsMessage.class);

    private Class<?>[] argumentTypes;

    /**
     * Validates if the passed arguments are valid for the current command.
     * 
     * @param args
     *        - the command arguments.
     * @throws IllegalArgumentException
     */
    public void validateArguments(Object[] args) throws IllegalArgumentException {
        if (argumentTypes.length != args.length) {
            throw new IllegalArgumentException("Passed arguments count does not match expected argument count.");
        }
        for (int i = 0; i < argumentTypes.length; i++) {
            if (!argumentTypes[i].isInstance(args[i])) {
                String expectedClass = argumentTypes[i].getName();
                String actualClass = args[i].getClass().getName();
                String message = String.format("Argument [%d] is not a valid instance of %s (instead is %s).",
                                               i,
                                               expectedClass,
                                               actualClass);
                throw new IllegalArgumentException(message);
            }
        }
    }

    private RoutingAction(Class<?>... classes) {
        argumentTypes = classes;
    }
}
