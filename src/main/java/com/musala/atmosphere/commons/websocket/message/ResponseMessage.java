package com.musala.atmosphere.commons.websocket.message;

import com.musala.atmosphere.commons.RoutingAction;

/**
 * Represents a common class for all WebSocket response actions.
 * 
 * @author dimcho.nedev
 *
 */
public class ResponseMessage extends Message {
    private String typeName;

    private Object data;

    private Exception exception;

    private String excpetionTypeName;

    public ResponseMessage(MessageAction messageAction, RoutingAction routingAction, Object data) {
        super(messageAction, routingAction);
        this.data = data;
        if (data != null) {
            this.typeName = data.getClass().getName();
        }
    }

    /**
     * Gets the response data.
     * 
     * @return response {@link Object data}
     */
    public Object getData() {
        return data;
    }

    /**
     * Sets the response data
     * 
     * @param {@link
     *        - Object response data}
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Gets the response data.
     * 
     * @return the type of the response data as a String
     */
    public String getTypeName() {
        return this.typeName;
    }

    /**
     * Gets the name of the exception type.
     * 
     * @return String name of the exception type
     */
    public String getExceptionTypeName() {
        return this.excpetionTypeName;
    }

    /**
     * Sets an exception to the response.
     * 
     * @param exception
     */
    public void setException(Exception exception) {
        this.exception = exception;
        if (excpetionTypeName == null) {
            this.excpetionTypeName = exception.getClass().getName();
        }
    }

    /**
     * Gets the exception from the response message.
     * 
     * @return {@link Exception exception}
     */
    public Exception getException() {
        return this.exception;
    }

}
