package com.musala.atmosphere.commons.websocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.musala.atmosphere.commons.websocket.message.ResponseMessage;

public class WebSocketCommunicatorManager {
    private static WebSocketCommunicatorManager instance = null;

    private static Map<String, Object> lockObjectMap;

    private static Map<String, ResponseMessage> responseMap;

    private WebSocketCommunicatorManager() {
        lockObjectMap = new ConcurrentHashMap<String, Object>();
        responseMap = new ConcurrentHashMap<String, ResponseMessage>();
    }

    public static WebSocketCommunicatorManager getInstance() {
        if (instance == null) {
            synchronized (WebSocketCommunicatorManager.class) {
                if (instance == null) {
                    instance = new WebSocketCommunicatorManager();
                }
            }
        }

        return instance;
    }

    public Object getSynchronizationObject(String sessionId) {
        if (lockObjectMap.containsKey(sessionId)) {
            return lockObjectMap.get(sessionId);
        }

        Object syncObj = new Object();
        lockObjectMap.put(sessionId, syncObj);
        return syncObj;
    }

    public ResponseMessage getServerResponse(String sessionId) {
        if (!responseMap.containsKey(sessionId)) {
            return null;
        }
        ResponseMessage response = responseMap.get(sessionId);
        responseMap.remove(sessionId);

        return response;
    }

    public void setServerResponse(ResponseMessage response) {
        String sessionId = response.getSessionId();
        responseMap.put(sessionId, response);
        Object lockObject = lockObjectMap.get(sessionId);
        synchronized(lockObject) {
            lockObject.notify();
        }
    }
}