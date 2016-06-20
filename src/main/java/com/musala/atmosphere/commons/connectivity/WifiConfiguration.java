package com.musala.atmosphere.commons.connectivity;

import java.io.Serializable;

/**
 *
 * Class that represents a bound profile of the augmented network.
 *
 * @author konstantin.ivanov
 *
 */
class WifiConfiguration implements Serializable {

    /**
     * auto-generated serialization id
     */
    private static final long serialVersionUID = 3480556825327675604L;

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

    /**
     * Returns the rate.
     * 
     * @return the rate if it was previously set, 0 otherwise
     */
    public int getRate() {
        return rate;
    }

    /**
     * Sets the rate.
     * 
     * @param rate
     *        - must be a positive integer
     */
    public void setRate(int rate) {
        this.rate = rate;
    }

    /**
     * Returns the latency.
     * 
     * @return the latency if it was previously set, 0 otherwise
     */
    public int getLatency() {
        return latency;
    }

    /**
     * Sets the latency.
     * 
     * @param latency
     *        - must be nonnegative
     */
    public void setLatency(int latency) {
        this.latency = latency;
    }

    /**
     * Returns the loss.
     * 
     * @return the loss if it was previously set, 0 otherwise
     */
    public int getLoss() {
        return loss;
    }

    /**
     * Sets the loss.
     * 
     * @param loss
     *        - must be in the range 0 to 100
     */
    public void setLoss(int loss) {
        this.loss = loss;
    }
}
