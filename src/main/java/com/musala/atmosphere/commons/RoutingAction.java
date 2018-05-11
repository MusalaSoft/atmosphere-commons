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
import com.musala.atmosphere.commons.connectivity.WifiConnectionProperties;
import com.musala.atmosphere.commons.geometry.Point;
import com.musala.atmosphere.commons.gesture.Gesture;
import com.musala.atmosphere.commons.ui.UiElementPropertiesContainer;
import com.musala.atmosphere.commons.ui.selector.UiElementSelector;
import com.musala.atmosphere.commons.ui.tree.AccessibilityElement;
import com.musala.atmosphere.commons.util.AtmosphereIntent;
import com.musala.atmosphere.commons.util.GeoLocation;
import com.musala.atmosphere.commons.util.Pair;
import com.musala.atmosphere.commons.webelement.action.WebElementAction;
import com.musala.atmosphere.commons.webelement.action.WebElementWaitCondition;
import com.musala.atmosphere.commons.webview.selection.WebViewSelectionCriterion;

/**
 * Enumerates all actions that can be invoked on a device wrapper instance in the agent component.
 *
 * @author georgi.gaydarov
 *
 */
public enum RoutingAction implements Serializable {
    /**
     * Invokes the method behind UI element field clearing. Requires a {@link UiElementPropertiesContainer} instance
     * (the element properties container for the element that should be cleared) as a parameter.
     */
    CLEAR_FIELD(new RoutingActionArgumentValidator(UiElementPropertiesContainer.class)),
    /**
     * Invokes the method behind UI element wait for existence. Requires a {@link UiElementPropertiesContainer} instance
     * (the properties for the element that should exist after given time) as a parameter.
     */
    WAIT_FOR_EXISTS(new RoutingActionArgumentValidator(UiElementPropertiesContainer.class), new RoutingActionArgumentValidator(Integer.class)),
    /**
     * Invokes the method behind UI element wait until gone. Requires a {@link UiElementPropertiesContainer} instance
     * (the element properties for the element that should exist after given time) as a parameter.
     */
    WAIT_UNTIL_GONE(new RoutingActionArgumentValidator(UiElementPropertiesContainer.class), new RoutingActionArgumentValidator(Integer.class)),
    /**
     * Invokes the method behind waiting for a window update event to occur for a given package. Requires a
     * <code>String</code> package name and a <code>int</code> timeout value.
     */
    WAIT_FOR_WINDOW_UPDATE(new RoutingActionArgumentValidator(String.class,
                                                              true), new RoutingActionArgumentValidator(Integer.class)),
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
     * Invokes the method behind sequential shell command execution (passed as a {@link List}, which returns a
     * {@link List} instance (command execution results).
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
    APK_APPEND_DATA(new RoutingActionArgumentValidator(String.class), new RoutingActionArgumentValidator(Integer.class)),
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
     * Invokes the method that sets the device maximum upload/download speed. Requires a {@link Pair}
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
     */
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
     * Invokes the method behind UI element swiping. Requires a {@link UiElementPropertiesContainer} instance (the element
     * descriptor for the element that should be swiped) and {@link SwipeDirection} enum member (the swipe direction) as
     * parameters.
     */
    ELEMENT_SWIPE(new RoutingActionArgumentValidator(UiElementPropertiesContainer.class), new RoutingActionArgumentValidator(SwipeDirection.class)),
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
     * Routes scrolling in some direction to the ATMOSPHERE Service. Requires {@link UiElementPropertiesContainer}
     * instance (the UI element that would be scrolled), maximum swipes and steps to execute and a boolean to determine
     * whether the view is with vertical orientation or not.
     */
    SCROLL_TO_DIRECTION(new RoutingActionArgumentValidator(ScrollDirection.class), new RoutingActionArgumentValidator(UiElementPropertiesContainer.class), new RoutingActionArgumentValidator(Integer.class), new RoutingActionArgumentValidator(Integer.class), new RoutingActionArgumentValidator(Boolean.class)),
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
     * Grants the specified permission to an application. Requires a {@link String} package name and a {@link String}
     * permission parameters.
     * @see <a href="https://developer.android.com/reference/android/Manifest.permission.html" target="_top">Android Manifest permissions</a>
     */
    GRANT_APP_PERMISSION(new RoutingActionArgumentValidator(String.class), new RoutingActionArgumentValidator(String.class)),
    /**
     * Revokes the specified permission from an application. Requires a {@link String} package name and a {@link String}
     * permission parameters.
     * @see <a href="https://developer.android.com/reference/android/Manifest.permission.html" target="_top">Android Manifest permissions</a>
     */
    REVOKE_APP_PERMISSION(new RoutingActionArgumentValidator(String.class), new RoutingActionArgumentValidator(String.class)),
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
     * Gets all UI elements matching the given element selector.
     */
    GET_UI_ELEMENTS(new RoutingActionArgumentValidator(UiElementSelector.class), new RoutingActionArgumentValidator(Boolean.class)),
    /**
     * Starts recording actions executed on the device, with given maximum recording duration.
     */
    START_RECORDING(new RoutingActionArgumentValidator(Integer.class), new RoutingActionArgumentValidator(Boolean.class)),
    /**
     * Stops recording actions executed on the device.
     */
    STOP_RECORDING(new RoutingActionArgumentValidator(String.class)),
    /**
     * Used to open the location settings activity of the device.
     */
    OPEN_LOCATION_SETTINGS,
    /**
     * Checks if there is an audio currently playing on the device.
     */
    IS_AUDIO_PLAYING,
    /**
     * Used to check the GPS location state of the device.
     */
    IS_GPS_LOCATION_ENABLED,
    /**
     * Used to enable the GPS Location of the device.
     */
    ENABLE_GPS_LOCATION,
    /**
     * Used to disable the GPS Location of the device.
     */
    DISABLE_GPS_LOCATION,
    /**
     * Used to obtain the text of the last detected toast message.
     */
    GET_LAST_TOAST,
    /**
     * Used to press a device hardware button with the specified ID.
     */
    PRESS_HARDWARE_BUTTON(new RoutingActionArgumentValidator(Integer.class)),
    /**
     * Used to show the tap locations on the current device screen.
     */
    SHOW_TAP_LOCATION(new RoutingActionArgumentValidator(Point.class)),
    /**
     * Checks whether the given {@link AccessibilityElement} is present on the screen. Set the second argument to
     * <code>true</code> if only visible nodes should be traversed, <code>false</code> otherwise.
     */
    CHECK_ELEMENT_PRESENCE(new RoutingActionArgumentValidator(AccessibilityElement.class), new RoutingActionArgumentValidator(Boolean.class)),
    /**
     * Gets children of the given {@link AccessibilityElement} that are matching the given {@link UiElementSelector} if
     * the third argument is
     * <code>true</code> then only the direct children are returned otherwise all will be considered. Set the fourth argument to
     * <code>true</code> if only visible nodes should be traversed, <code>false</code> otherwise.
     */
    GET_CHILDREN(new RoutingActionArgumentValidator(AccessibilityElement.class), new RoutingActionArgumentValidator(UiElementSelector.class), new RoutingActionArgumentValidator(Boolean.class), new RoutingActionArgumentValidator(Boolean.class)),
    /**
     * Gets the WebView present on the active screen. The string represent the package of the application that is
     * currently tested.
     */
    GET_WEB_VIEW(new RoutingActionArgumentValidator(String.class)),
    /**
     * Sets an implicit wait timeout for the web view
     */
    SET_WEB_VIEW_IMPLICIT_WAIT(new RoutingActionArgumentValidator(Integer.class)),
    /**
     * Clears the saved data of a given application.
     */
    CLEAR_APP_DATA(new RoutingActionArgumentValidator(String.class)),
    /**
     * Performs an action on a web element.
     */
    WEB_ELEMENT_ACTION(new RoutingActionArgumentValidator(WebElementAction.class), new RoutingActionArgumentValidator(String.class)),
    /**
     * Finds a web element by the xpath query given as an argument.
     */
    FIND_WEB_ELEMENT(new RoutingActionArgumentValidator(String.class)),
    /**
     * Finds a list of web elements by the xpath query given as an argument..
     */
    FIND_WEB_ELEMENTS(new RoutingActionArgumentValidator(String.class)),
    /**
     * Closes the instance of the Chrome driver that is currently in use.
     */
    CLOSE_CHROME_DRIVER,
    /**
     * Gets the value of a given CSS property.
     */
    GET_CSS_VALUE(new RoutingActionArgumentValidator(String.class), new RoutingActionArgumentValidator(String.class)),
    /**
     * Waits for web element to meet a given condition.
     */
    WAIT_FOR_WEB_ELEMENT(new RoutingActionArgumentValidator(String.class), new RoutingActionArgumentValidator(WebElementWaitCondition.class), new RoutingActionArgumentValidator(Integer.class)),
    /**
     * Sends {@link WifiConnectionProperties data} for modifying WiFi connection properties.
     */
    SHAPE_DEVICE(new RoutingActionArgumentValidator(WifiConnectionProperties.class)),
    /**
     * Restores WiFi connection properties for the device.
     */
    UNSHAPE_DEVICE,
    /**
     * Sends request for executing XPath queries when searching elements on the screen. The first argument is the XPath
     * query to be executed. The second argument denotes whether only visible nodes should be matched from the screen
     * hierarchy.
     */
    EXECUTE_XPATH_QUERY(new RoutingActionArgumentValidator(String.class), new RoutingActionArgumentValidator(Boolean.class)),
    /**
     * Sends request for executing XPath queries when searching elements on the screen. The first argument is the XPath
     * query to be executed. The second argument denotes whether only visible nodes should be matched and the last one
     * is {@link AccessibilityElement local root} from the screen hierarchy.
     */
    EXECUTE_XPATH_QUERY_ON_LOCAL_ROOT(new RoutingActionArgumentValidator(String.class), new RoutingActionArgumentValidator(Boolean.class), new RoutingActionArgumentValidator(AccessibilityElement.class)),
    /**
     * Gets the available disk space for the device.
     */
    GET_AVAILABLE_DISK_SPACE,
    /**
     * Gives access to the device LogCat. Accepts filter, applied when retrieving the log, as an argument.
     */
    GET_DEVICE_LOGCAT(new RoutingActionArgumentValidator(String.class)),
    /**
     * Clears the logcat from the device.
     */
    CLEAR_LOGCAT,
    /**
     * Start a logcat command for a specific device.
     */
    START_DEVICE_LOGCAT(new RoutingActionArgumentValidator(String.class), new RoutingActionArgumentValidator(String.class)),
    /**
     * Gets the logcat buffer for a specific device.
     */
    GET_LOGCAT_BUFFER(new RoutingActionArgumentValidator(String.class)),
    /**
     * Stops buffering a logcat for a specific device.
     */
    STOP_LOGCAT(new RoutingActionArgumentValidator(String.class)),
    /**
     * Switches to another web view by the xPath query given as an argument.
     */
    SWITCH_TO_WEBVIEW_BY_CHILD(new RoutingActionArgumentValidator(String.class)),
    /**
     * Switches to another web view by the xPath {@link WebViewSelectionCriterion criterion} given as an argument.
     */
    SWITCH_TO_WEBVIEW(new RoutingActionArgumentValidator(WebViewSelectionCriterion.class), new RoutingActionArgumentValidator(String.class)),
    /**
     * Gets the title of the current web view.
     */
    GET_WEBVIEW_TITLE,
    /**
     * Gets the url of the current web view.
     */
    GET_WEBVIEW_URL,
    /**
     * Gets all web view window handlers that present on the current screen.
     */
    GET_WEB_VIEWS,
    /**
     * Sends the text that needs to be input and the interval in which it should be input.
     */
    IME_INPUT_TEXT(new RoutingActionArgumentValidator(String.class), new RoutingActionArgumentValidator(Long.class)),
    /**
     * Used to clear the text from a TextView.
     */
    IME_CLEAR_TEXT,
    /**
     * Used to select the whole text in a TextView.
     */
    IME_SELECT_ALL_TEXT,
    /**
     * Used to copy the text from a TextView.
     */
    IME_COPY_TEXT,
    /**
     * Used to cut the text from a TextView.
     */
    IME_CUT_TEXT,
    /**
     * Used to paste the text currently in the clipboard into a TextView.
     */
    IME_PASTE_TEXT,
    /**
     * Invokes the method that executes a tap on the coordinates provided as a {@link Point}.
     */
    GESTURE_TAP(new RoutingActionArgumentValidator(Point.class)),
    /**
     * Invokes the method that executes a long press on the coordinates provided as a {@link Point}
     * for the specified interval in milliseconds.
     */
    GESTURE_LONG_PRESS(new RoutingActionArgumentValidator(Point.class), new RoutingActionArgumentValidator(Integer.class)),
    /**
     * Invokes the method that executes a double tap on the coordinates provided as a {@link Point}.
     */
    GESTURE_DOUBLE_TAP(new RoutingActionArgumentValidator(Point.class)),
    /**
     * Invokes the method that executes a pinch in on the coordinates provided as {@link Point Points}.
     */
    GESTURE_PINCH_IN(new RoutingActionArgumentValidator(Point.class), new RoutingActionArgumentValidator(Point.class)),
    /**
     * Invokes the method that executes a pinch out on the coordinates provided as {@link Point Points}.
     */
    GESTURE_PINCH_OUT(new RoutingActionArgumentValidator(Point.class), new RoutingActionArgumentValidator(Point.class)),
    /**
     * Invokes the method that executes a swipe on the coordinates provided as a {@link Point}
     * in the specified direction.
     */
    GESTURE_SWIPE(new RoutingActionArgumentValidator(Point.class), new RoutingActionArgumentValidator(SwipeDirection.class)),
    /**
     * Invokes the method that executes a drag between the coordinates provided as {@link Point Points}.
     */
    GESTURE_DRAG(new RoutingActionArgumentValidator(Point.class), new RoutingActionArgumentValidator(Point.class)),
    /**
     * Gets a {@link ScreenOrientation} instance that contains information about the orientation of the screen.
     */
    GET_SCREEN_ORIENTATION,
    /**
     * Sets a new screen orientation for this device.
     */
    SET_SCREEN_ORIENTATION(new RoutingActionArgumentValidator(ScreenOrientation.class)),
    /**
     * Gets the auto rotation state of the device.
     */
    IS_AUTO_ROTATION_ON,
    /**
     * Sets the auto rotation state of the device.
     */
    SET_SCREEN_AUTO_ROTATION(new RoutingActionArgumentValidator(Boolean.class)),
    /**
     * Gets the airplane mode state of the device.
     */
    GET_AIRPLANE_MODE,
    /**
     * Sets the airplane mode state of the device.
     */
    SET_AIRPLANE_MODE(new RoutingActionArgumentValidator(Boolean.class)),
    /**
     * Gets the timeout in the system settings, after which the screen is turned off.
     */
    GET_SCREEN_OFF_TIMEOUT,
    /**
     * Sets the timeout in the system settings, after which the screen is turned off.
     */
    SET_SCREEN_OFF_TIMEOUT(new RoutingActionArgumentValidator(Long.class));

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
