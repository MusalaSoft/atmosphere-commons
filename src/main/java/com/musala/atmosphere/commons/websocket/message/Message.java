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

package com.musala.atmosphere.commons.websocket.message;

import com.musala.atmosphere.commons.RoutingAction;

/**
 * Represents the abstract WebSocket message properties.
 *
 * @author dimcho.nedev
 *
 */
public abstract class Message {
    private MessageAction messageAction;

    private RoutingAction routingAction;

    private String sessionId;

    private String agentId;

    private String deviceId;

    protected Message() {
    }

    protected Message(MessageAction messageAction, RoutingAction routingAction, String sessionId) {
        this.sessionId = sessionId;
        this.messageAction = messageAction;
        this.routingAction = routingAction;
    }

    protected Message(MessageAction messageAction, RoutingAction routingAction) {
        this(messageAction, routingAction, null);
    }

    /**
     * Gets the {@link MessageAction action} of the message.
     *
     * @return {@link MessageAction message action}
     */
    public MessageAction getMessageAction() {
        return messageAction;
    }

    /**
     * Sets a {@link MessageAction message action}.
     *
     * @param messageAction
     *        - message action
     */
    public void setMessageAction(MessageAction messageAction) {
        this.messageAction = messageAction;
    }

    /**
     * Gets the Session identifier.
     *
     * @return Session identifier
     */
    public String getSessionId() {
        return this.sessionId;
    }

    /**
     * Sets an identifier of the Session
     *
     * @param sessionId
     *        - identifier of the Session
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * Gets a {@link RoutingAction routing action}
     *
     * @return {@link RoutingAction routing action}
     */
    public RoutingAction getRoutingAction() {
        return routingAction;
    }

    /**
     * Sets a {@link RoutingAction routing action}
     *
     * @param routingAction
     *        - {@link RoutingAction routing action}
     */
    public void setRoutingAction(RoutingAction routingAction) {
        this.routingAction = routingAction;
    }

    /**
     * Sets an agent identifier.
     *
     * @param agentId
     *        - agent identifier
     */
    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    /**
     * Gets an identifier of the agent
     *
     * @return agent identifier
     */
    public String getAgentId() {
        return this.agentId;
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

}
