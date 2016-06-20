package com.musala.atmosphere.commons.util.telephony;

/**
 * Enumeration indicating a device phone type.
 * 
 * @author yordan.petrov
 * 
 */
public enum PhoneType {
    /*
     * Phone radio is CDMA.
     */
    PHONE_TYPE_CDMA(0),

    /*
     * Phone radio is GSM.
     */
    PHONE_TYPE_GSM(1),

    /*
     * No phone radio.
     */
    PHONE_TYPE_NONE(2),

    /*
     * Phone is via SIP.
     */
    PHONE_TYPE_SIP(3);

    private int phoneTypeId;

    private PhoneType(int phoneTypeId) {
        this.phoneTypeId = phoneTypeId;
    }

    public int getId() {
        return phoneTypeId;
    }

    public static PhoneType getById(int id) {
        PhoneType typeById = null;
        for (PhoneType currentState : PhoneType.values()) {
            if (currentState.getId() == id) {
                typeById = currentState;
                break;
            }
        }

        return typeById;
    }
}
