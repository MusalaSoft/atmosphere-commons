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
