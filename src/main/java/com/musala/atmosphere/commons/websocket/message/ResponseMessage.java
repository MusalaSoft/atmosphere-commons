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
