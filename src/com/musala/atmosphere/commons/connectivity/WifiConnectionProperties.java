package com.musala.atmosphere.commons.connectivity;

import java.io.Serializable;

/**
 * Container for the WiFi connection properties that will be modified for a given device.
 * 
 * @author filareta.yordanova
 *
 */
public class WifiConnectionProperties implements Serializable {
    // TODO: Provide suitable implementation including desired connection properties.

    public String serialize() {
        // TODO: Return all the properties in suitable JSON format.

        return "{\"up\":{\"rate\":\"2\",\"delay\":{\"delay\":\"3\",\"jitter\":0,\"correlation\":0},"
                + "\"loss\":{\"percentage\":\"30\",\"correlation\":0},"
                + "\"reorder\":{\"percentage\":\"4\",\"correlation\":0,\"gap\":0},"
                + "\"corruption\":{\"percentage\":\"5\",\"correlation\":0},\"iptables_options\":[]},"
                + "\"down\":{\"rate\":\"7\",\"delay\":{\"delay\":\"4\",\"jitter\":0,\"correlation\":0},"
                + "\"loss\":{\"percentage\":\"20\",\"correlation\":0},"
                + "\"reorder\":{\"percentage\":\"5\",\"correlation\":0,\"gap\":0},"
                + "\"corruption\":{\"percentage\":\"4\",\"correlation\":0},\"iptables_options\":[]}}";
    }
}