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

package com.musala.atmosphere.websocket.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
public class DataSerializationTestBase {
    protected static final GsonUtil jsonUtil = new GsonUtil();

    protected static final String jsonPath = "./src/main/resources/json/";

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

    protected String readFile(String path) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try {
            br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
    }

}
