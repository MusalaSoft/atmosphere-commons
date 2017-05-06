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

    private String[] typeNames;

    private String deviceId;

    public RequestMessage(MessageAction messageAction, RoutingAction routingAction, Object... arguments) {
        super(messageAction, routingAction);
        this.arguments = arguments;
        typeNames = new String[arguments.length];

        for (int i = 0; i < arguments.length; i++) {
            if (arguments[i] != null) {
                typeNames[i] = arguments[i].getClass().getName();
            }
        }
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
     * Sets the arguments of the request message.
     *
     * @param arguments
     *        - an array of {@link Object java objects}
     */
    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }

    /**
     * Gets string representations of the all argument's types.
     * 
     * @return an array of the argument's types
     */
    public String[] getTypeNames() {
        return typeNames;
    }

}
