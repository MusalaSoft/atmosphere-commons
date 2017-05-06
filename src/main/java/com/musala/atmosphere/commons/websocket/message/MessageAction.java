package com.musala.atmosphere.commons.websocket.message;

/**
 * List of all types of message actions.
 *
 * @author dimcho.nedev
 *
 */
public enum MessageAction {
    REGISTER_AGENT,
    DEVICE_CHANGED,
    ROUTING_ACTION,
    DEVICE_ALLOCATION_INFORMATION,
    GET_ALL_AVAILABLE_DEVICES,
    RELEASE_DEVICE,
    PING,
    ERROR
}
