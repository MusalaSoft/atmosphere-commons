package com.musala.atmosphere.commons.connectivity;

/**
 * Holds different connection qualities. {@link WifiConnectionQuality.POOR} will set the rate in the range 100-140 kbps,
 * {@link WifiConnectionQuality.MODERATE} will set the rate in the range 320-360 kbps,
 * {@link WifiConnectionQuality.GOOD} will set the rate in the range 1000-1040 kbps,
 * {@link WifiConnectionQuality.EXCELLENT} will set the rate in the range 2200-2240 kbps.
 * 
 * @author konstantin.ivanov
 *
 */
public enum WifiConnectionQuality {

    /**
     * Range is 60 - 100.
     */
    POOR(60, 100),

    /**
     * Range is 320 - 360.
     */
    MODERATE(320, 360),

    /**
     * Range is 1000-1040.
     */
    GOOD(1000, 1040),

    /**
     * Range is 2200-2240.
     */
    EXCELLENT(2200, 2240);

    private int lowerRate;

    private int upperRate;

    private WifiConnectionQuality(int lowerRate, int upperRate) {
        this.lowerRate = lowerRate;
        this.upperRate = upperRate;
    }

    public int getLowerRate() {
        return this.lowerRate;
    }

    public int getUpperRate() {
        return this.upperRate;
    }

}
