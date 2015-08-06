package com.musala.atmosphere.commons.connectivity;

/**
 *
 * Class that represents a bound profile of the augmented network.
 *
 * @author konstantin.ivanov
 *
 */
public class WifiConfiguration {

    /**
     * Represents bandwidth in Kbps.
     */
    private int rate;

    /**
     * Represents latency in ms.
     */
    private int latency;

    /**
     * Represents package loss in percents.
     */
    private int loss;

    public WifiConfiguration() {
        rate = 0;
        latency = 0;
        loss = 0;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getLatency() {
        return latency;
    }

    public void setLatency(int latency) {
        this.latency = latency;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }
}
