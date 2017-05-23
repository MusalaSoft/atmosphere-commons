package com.musala.atmosphere.commons.websocket.util;

import com.musala.atmosphere.commons.websocket.message.RequestMessage;
import com.musala.atmosphere.commons.websocket.message.ResponseMessage;

/**
 * A class that holds commonly used constants when serialize/deserialize {@link RequestMessage request} or
 * {@link ResponseMessage response message}.
 *
 * @author dimcho.nedev
 *
 */
public interface JsonConst {
    String KEY = "mKey";

    String VALUE = "mValue";

    String MESSAGE_ACTION = "messageAction";

    String ROUTING_ACTION = "routingAction";

    String ATTRIBUTE_PROJECTION_MAP = "attributeProjectionMap";

    String ARGUMENTS = "arguments";

    String CONTENTS = "contents";

    String AGENT_ID = "agentId";

    String DEVICE_ID = "deviceId";

    String SESSION_ID = "sessionId";

    String DATA = "data";

    String DEVICE_PASSKEY = "passkey";

    String ASYNC = "async";

    String EXCEPTION = "exception";

    String FAILED_TO_FIND_CLASS = "Failed to find a Class with name %s .";
}
