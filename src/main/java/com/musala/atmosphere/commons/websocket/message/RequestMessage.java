package com.musala.atmosphere.commons.websocket.message;

import com.musala.atmosphere.commons.RoutingAction;

/**
 * Represents a common class for all WebSocket request actions.
 *
 * @author dimcho.nedev
 *
 */
public class RequestMessage extends Message {
    private Object[] arguments;

    private String deviceId;

    public RequestMessage() {
    }

    public RequestMessage(MessageAction messageAction, RoutingAction routingAction, Object... arguments) {
        super(messageAction, routingAction);
        this.arguments = arguments;
    }

    public RequestMessage(MessageAction messageAction, Object... arguments) {
        this(messageAction, null, arguments);
    }

    /**
     * Sets the serial number of the device.
     *
     * @param deviceId
     *        - serial number of the device
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * Gets the serial number of the device.
     *
     * @return the serial number of the device.
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Gets the arguments of the request message.
     *
     * @return an array of {@link Object java objects}
     */
    public Object[] getArguments() {
        return arguments;
    }

    /**
     * Sets the request arguments of the {@link RequestMessage request message}.
     *
     * @param arguments
     *        - an array of {@link Object java objects}
     */
    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }

}
