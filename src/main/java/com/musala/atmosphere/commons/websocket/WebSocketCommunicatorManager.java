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

package com.musala.atmosphere.commons.websocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.musala.atmosphere.commons.websocket.message.ResponseMessage;

/**
 * Manages the {@link ResponseMessage response messages}
 *
 * @author alexander.ivanov
 *
 */
public class WebSocketCommunicatorManager {
    private Map<String, Object> lockObjectMap;

    private Map<String, ResponseMessage> responseMap;

    private WebSocketCommunicatorManager() {
        lockObjectMap = new ConcurrentHashMap<String, Object>();
        responseMap = new ConcurrentHashMap<String, ResponseMessage>();
    }

    private static class WebSocketCommunicatorManagerLoader {
        private static final WebSocketCommunicatorManager INSTANCE = new WebSocketCommunicatorManager();
    }

    public static WebSocketCommunicatorManager getInstance() {
        return WebSocketCommunicatorManagerLoader.INSTANCE;
    }

    /**
     * Gets a {@link Object synchronization object} by a session identifier.
     *
     * @param sessionId
     *        - session identifier
     * @return {@link Object synchronization object}
     */
    public Object getSynchronizationObject(String sessionId) {
        if (lockObjectMap.containsKey(sessionId)) {
            return lockObjectMap.get(sessionId);
        }

        Object syncObj = new Object();
        lockObjectMap.put(sessionId, syncObj);
        return syncObj;
    }

    /**
     * Gets a {@link ResponseMessage response message} by a session identifier.
     *
     * @param sessionId
     *        - session identifier
     * @return {@link ResponseMessage response message}
     */
    public ResponseMessage popResponse(String sessionId) {
        ResponseMessage response = responseMap.remove(sessionId);

        return response;
    }

    /**
     * Sets a {@link ResponseMessage response message} to the {@link WebSocketCommunicatorManager}
     *
     * @param response
     *        - {@link ResponseMessage response message}
     */
    public void addResponse(ResponseMessage response) {
        String sessionId = response.getSessionId();
        responseMap.put(sessionId, response);
        Object lockObject = lockObjectMap.get(sessionId);
        synchronized (lockObject) {
            lockObject.notify();
        }
    }
}
