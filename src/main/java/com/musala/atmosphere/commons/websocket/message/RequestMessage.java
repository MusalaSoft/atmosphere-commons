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
 * Represents a common class for all WebSocket request actions.
 *
 * @author dimcho.nedev
 *
 */
public class RequestMessage extends Message {
    private Object[] arguments;

    private Long passkey;

    private boolean async;

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

    /**
     * Gets a invocation passkey.
     *
     * @return an invocation passkey
     */
    public Long getPasskey() {
        return passkey;
    }

    /**
     * Sets a invocation passkey to the request.
     *
     * @param passkey
     *        - an invocation passkey
     */
    public void setPasskey(Long passkey) {
        this.passkey = passkey;
    }

    /**
     * Gets whether the request {@link RoutingAction routing action} will be executed asynchronously on the Agent
     *
     * @return whether the request action will be executed asynchronously
     */
    public boolean isAsync() {
        return async;
    }

    /**
     * Sets whether the request {@link RoutingAction routing action} will be executed asynchronously on the Agent.
     *
     * @param async
     *        - whether the request action will be executed asynchronously
     */
    public void setAsync(boolean async) {
        this.async = async;
    }

}
