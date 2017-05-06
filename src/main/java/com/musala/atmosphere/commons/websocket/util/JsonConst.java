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
public class JsonConst {

    public static final String KEY = "mKey";

    public static final String VALUE = "mValue";

    public static final String MESSAGE_ACTION = "messageAction";

    public static final String ROUTING_ACTION = "routingAction";

    public static final String ATTRIBUTE_PROJECTION_MAP = "attributeProjectionMap";

    public static final String ARGUMENTS = "arguments";

    public static final String CONTENTS = "contents";

    public static final String AGENT_ID = "agentId";

    public static final String DEVICE_ID = "deviceId";

    public static final String SESSION_ID = "sessionId";

    public static final String DATA = "data";

    public static final String DEVICE_PASSKEY = "passkey";

    public static final String ASYNC = "async";

    public static final String EXCEPTION = "exception";

    public final static String FAILED_TO_FIND_CLASS = "Failed to find a Class with name %s .";
}
