package com.musala.atmosphere.commons.websocket.message;

import java.io.Serializable;

public class ClientServerResponse implements Serializable {

    private static final long serialVersionUID = -1256869328234379319L;

    private String sessionId;

    private MessageType responseType;

    private String responseData;

    public ClientServerResponse() {
    }

    public ClientServerResponse(String sessionId, MessageType responseType, String responseData) {
        this.sessionId = sessionId;
        this.responseType = responseType;
        this.responseData = responseData;
    }

    public ClientServerResponse(MessageType responseType, String responseData) {
        this(null, responseType, responseData);
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public MessageType getResponseType() {
        return responseType;
    }

    public void setResponseType(MessageType messageType) {
        this.responseType = messageType;
    }

    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }
}
