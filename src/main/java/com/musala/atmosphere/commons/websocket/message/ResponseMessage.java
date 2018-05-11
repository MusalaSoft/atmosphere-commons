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
 * Represents a common class for all WebSocket response actions.
 *
 * @author dimcho.nedev
 *
 */
public class ResponseMessage extends Message {
    private Object data;

    private Exception exception;

    public ResponseMessage() {
    }

    public ResponseMessage(MessageAction messageAction, RoutingAction routingAction, Object data) {
        super(messageAction, routingAction);
        this.data = data;
    }

    public ResponseMessage(MessageAction messageAction, Object data) {
        this(messageAction, null, data);
    }

    /**
     * Gets the response data.
     *
     * @return response {@link Object response data}
     */
    public Object getData() {
        return data;
    }

    /**
     * Sets the response data to the {@link ResponseMessage response message}.
     *
     * @param data
     *        - {@link Object response data}
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Sets an exception to the {@link ResponseMessage response message}. Used when an exception occurs when trying to
     * execute a request.
     *
     * @param exception
     *        - an exception occurred during the request execution
     */
    public void setException(Exception exception) {
        this.exception = exception;
    }

    /**
     * Gets the exception from the response message.
     *
     * @return {@link Exception exception} occurred during the request execution
     */
    public Exception getException() {
        return this.exception;
    }

}
