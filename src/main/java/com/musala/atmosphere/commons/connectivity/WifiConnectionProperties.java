package com.musala.atmosphere.commons.connectivity;

import java.io.Serializable;

/**
 * Container for the WiFi connection properties that will be modified for a given device.
 *
 * @author filareta.yordanova
 *
 */
public class WifiConnectionProperties implements Serializable {
    private static final long serialVersionUID = -1238602101763163867L;

    private WifiConfiguration upLink;

    private WifiConfiguration downLink;

    public WifiConnectionProperties(WifiConfiguration upLink, WifiConfiguration downLink) {
        this.upLink = upLink;
        this.downLink = downLink;
    }

    /**
     * Generates string in JSON format, used by a network augmentation tool.
     *
     * @return string in JSON format
     */
    public String serialize() {
        // TODO: Use suitable library for JSON serialization, e.g. GSON
        return "{\"up\":{\"rate\":" + upLink.getRate() + ",\"delay\":{\"delay\":" + upLink.getLatency()
                + ",\"jitter\":0,\"correlation\":0}," + "\"loss\":{\"percentage\":" + upLink.getLoss()
                + ",\"correlation\":0}," + "\"reorder\":{\"percentage\":\"0\",\"correlation\":0,\"gap\":0},"
                + "\"corruption\":{\"percentage\":\"0\",\"correlation\":0},\"iptables_options\":[]},"
                + "\"down\":{\"rate\":" + downLink.getRate() + ",\"delay\":{\"delay\":" + downLink.getLatency()
                + ",\"jitter\":0,\"correlation\":0}," + "\"loss\":{\"percentage\":" + downLink.getLoss()
                + ",\"correlation\":0}," + "\"reorder\":{\"percentage\":\"0\",\"correlation\":0,\"gap\":0},"
                + "\"corruption\":{\"percentage\":\"0\",\"correlation\":0},\"iptables_options\":[]}}";

    }
}