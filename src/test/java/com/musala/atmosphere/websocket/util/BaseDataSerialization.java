package com.musala.atmosphere.websocket.util;

import com.musala.atmosphere.commons.DeviceInformation;
import com.musala.atmosphere.commons.RoutingAction;
import com.musala.atmosphere.commons.util.Pair;
import com.musala.atmosphere.commons.websocket.message.MessageAction;
import com.musala.atmosphere.commons.websocket.message.ResponseMessage;
import com.musala.atmosphere.commons.websocket.util.GsonUtil;

/**
 * A base class for the serialization/deserialization tests with commonly used actions and fields.
 *
 * @author dimcho.nedev
 *
 */
public class BaseDataSerialization {
    protected static GsonUtil jsonUtil = new GsonUtil();

    protected Object getExpectedResponseData(RoutingAction action, Object data) {
        ResponseMessage responseMessage = new ResponseMessage(MessageAction.ROUTING_ACTION, action, data);
        String jsonResponse = jsonUtil.serialize(responseMessage);

        return jsonUtil.deserializeResponse(jsonResponse).getData();
    }

    protected DeviceInformation createDeviceInfoObject() {
        DeviceInformation deviceInformation = new DeviceInformation();
        deviceInformation.setApiLevel(TestConst.DEVICE_API_LEVEL);
        deviceInformation.setResolution(new Pair<Integer, Integer>(TestConst.RESOLUTION_X, TestConst.RESOLUTION_Y));

        return deviceInformation;
    }
}
