package com.musala.atmosphere.commons.websocket.message;

import java.io.Serializable;

public class ClientServerRequest implements Serializable {

    private static final long serialVersionUID = -4837681578094033836L;

    private String sessionId;

    private MessageType requestType;

    private String data;

    public ClientServerRequest() {
    }

    public ClientServerRequest(String sessionId, MessageType requestType, String data) {
        this.sessionId = sessionId;
        this.requestType = requestType;
        this.data = data;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public MessageType getRequestType() {
        return requestType;
    }

    public void setRequestType(MessageType requestType) {
        this.requestType = requestType;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
