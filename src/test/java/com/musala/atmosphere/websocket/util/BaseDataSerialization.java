package com.musala.atmosphere.websocket.util;

import com.musala.atmosphere.commons.DeviceInformation;
import com.musala.atmosphere.commons.RoutingAction;
import com.musala.atmosphere.commons.util.Pair;
import com.musala.atmosphere.commons.websocket.message.MessageAction;
import com.musala.atmosphere.commons.websocket.message.ResponseMessage;
import com.musala.atmosphere.commons.websocket.util.GsonUtil;

/**
 * TODO: Add a javadoc
 *
 * @author dimcho.nedev
 *
 */
public class BaseDataSerialization {
    protected static GsonUtil jsonUtil = new GsonUtil();

    protected static final Long LONG_RESPONSE_DATA = 1L << 60;

    protected static final int DEVICE_API_LEVEL = 23;

    public static final Integer RESOLUTION_X = 1280;

    public static final Integer RESOLUTION_Y = 720;

    protected static final String TEST_PATH = "root/test/path";

    protected Object getExpectedResponseData(RoutingAction action, Object data) {
        ResponseMessage responseMessage = new ResponseMessage(MessageAction.ROUTING_ACTION, action, data);
        String jsonResponse = jsonUtil.serialize(responseMessage);

        return jsonUtil.deserializeResponse(jsonResponse).getData();
    }

    protected DeviceInformation createDeviceInfoObject() {
        DeviceInformation deviceInformation = new DeviceInformation();
        deviceInformation.setApiLevel(DEVICE_API_LEVEL);
        deviceInformation.setResolution(new Pair<Integer, Integer>(RESOLUTION_X, RESOLUTION_Y));

        return deviceInformation;
    }
}
