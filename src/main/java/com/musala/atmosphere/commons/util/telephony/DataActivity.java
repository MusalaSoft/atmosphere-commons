package com.musala.atmosphere.commons.util.telephony;

/**
 * Enumeration indicating the type of activity on a data connection (cellular).
 * 
 * @author yordan.petrov
 * 
 */
public enum DataActivity {
    /*
     * Data connection is active, but physical link is down
     */
    DATA_ACTIVITY_DORMANT(0),

    /*
     * Data connection activity: Currently receiving IP PPP traffic.
     */
    DATA_ACTIVITY_IN(1),

    /*
     * Data connection activity: Currently both sending and receiving IP PPP traffic.
     */
    DATA_ACTIVITY_INOUT(2),

    /*
     * Data connection activity: No traffic.
     */
    DATA_ACTIVITY_NONE(3),

    /*
     * Data connection activity: Currently sending IP PPP traffic.
     */
    DATA_ACTIVITY_OUT(4);

    private int dataActivityId;

    private DataActivity(int dataActivityId) {
        this.dataActivityId = dataActivityId;
    }

    public int getId() {
        return dataActivityId;
    }

    public static DataActivity getById(int id) {
        DataActivity typeById = null;
        for (DataActivity currentState : DataActivity.values()) {
            if (currentState.getId() == id) {
                typeById = currentState;
                break;
            }
        }

        return typeById;
    }
}
