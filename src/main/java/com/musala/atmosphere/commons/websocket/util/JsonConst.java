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

package com.musala.atmosphere.commons.websocket.util;

import com.musala.atmosphere.commons.websocket.message.RequestMessage;
import com.musala.atmosphere.commons.websocket.message.ResponseMessage;

/**
 * An interface that holds commonly used constants when serialize/deserialize {@link RequestMessage request} or
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
