package com.musala.atmosphere.commons.connectivity;

/**
 * Builder class used for constructing the (@link WifiConnectionProperties).
 *
 * @author konstantin.ivanov
 *
 */
public class WifiConfigurationPropertiesBuilder {

    /**
     * Field used to represents the upper bound of the WifiConfiguration.
     */
    private WifiConfiguration upLink;

    /**
     * Field used to represents the lower bound of the WifiConfiguration.
     */
    private WifiConfiguration downLink;

    public WifiConfigurationPropertiesBuilder() {
        this.upLink = new WifiConfiguration();
        this.downLink = new WifiConfiguration();
    }

    /**
     * Set the upper bound of the bandwidth in Kbps.
     *
     * @param rate
     *        - represents the bandwidth in Kbps
     * @return this instance
     */
    public WifiConfigurationPropertiesBuilder rateMax(int rate) {
        this.upLink.setRate(rate);
        return this;
    }

    /**
     * Sets the lower bound of the bandwidth in Kbps.
     *
     * @param rate
     *        - represents the bandwidth in Kbps
     * @return this instance
     */
    public WifiConfigurationPropertiesBuilder rateMin(int rate) {
        this.downLink.setRate(rate);
        return this;
    }

    /**
     * Sets the range of the bandwidth in Kbps.
     *
     * @param upperRate
     *        - upper bound of the bandwidth in Kbps
     * @param lowerRate
     *        - lower bound of the bandwidth in Kbps
     * @return this instance
     */
    public WifiConfigurationPropertiesBuilder rate(int upperRate, int lowerRate) {
        this.upLink.setRate(upperRate);
        this.downLink.setRate(lowerRate);
        return this;
    }

    /**
     * Sets the upper bound of the latency in ms.
     *
     * @param latency
     *        - upper bound of the latency in ms
     * @return this instance
     */
    public WifiConfigurationPropertiesBuilder latencyMax(int latency) {
        this.upLink.setLatency(latency);
        return this;
    }

    /**
     * Sets the lower bound of the latency in ms.
     *
     * @param latency
     *        - lower bound of the latency in ms
     * @return this instance
     */
    public WifiConfigurationPropertiesBuilder latencyMin(int latency) {
        this.downLink.setLatency(latency);
        return this;
    }

    /**
     * Sets the range for the latency.
     *
     * @param upperLatency
     *        - upper bound of the latency in ms
     * @param lowerLatency
     *        - lower bound of the latency in ms
     * @return this instance
     */
    public WifiConfigurationPropertiesBuilder latency(int upperLatency, int lowerLatency) {
        this.upLink.setLatency(upperLatency);
        this.downLink.setLatency(lowerLatency);
        return this;
    }

    /**
     * Sets the upper bound for package loss.
     *
     * @param loss
     *        - upper bound for package loss in percents
     * @return this instance
     */
    public WifiConfigurationPropertiesBuilder lossMax(int loss) {
        this.upLink.setLoss(loss);
        return this;
    }

    /**
     * Sets the lower bound for package loss.
     *
     * @param loss
     *        - lower bound for package loss in percents
     * @return this instance
     */
    public WifiConfigurationPropertiesBuilder lossMin(int loss) {
        this.downLink.setLoss(loss);
        return this;
    }

    /**
     * Sets the range for package loss.
     *
     * @param upperLoss
     *        - upper bound for package loss in percents.
     * @param lowerLoss
     *        - lower bound for package loss in percents
     * @return this instance
     */
    public WifiConfigurationPropertiesBuilder loss(int upperLoss, int lowerLoss) {
        this.upLink.setLoss(upperLoss);
        this.downLink.setLoss(lowerLoss);
        return this;
    }

    /**
     * Builds (@link WifiConnectionProperties).
     *
     * @return <code>WifiConnectionProperties</code> instance
     */
    public WifiConnectionProperties build() {
        return new WifiConnectionProperties(upLink, downLink);
    }
}
