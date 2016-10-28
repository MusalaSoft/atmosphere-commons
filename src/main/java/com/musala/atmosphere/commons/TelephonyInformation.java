package com.musala.atmosphere.commons;

import java.io.Serializable;

import com.musala.atmosphere.commons.util.telephony.CallState;
import com.musala.atmosphere.commons.util.telephony.DataActivity;
import com.musala.atmosphere.commons.util.telephony.DataState;
import com.musala.atmosphere.commons.util.telephony.NetworkType;
import com.musala.atmosphere.commons.util.telephony.PhoneType;
import com.musala.atmosphere.commons.util.telephony.SimState;

/**
 * Provides access to information about the telephony services on the device. Applications can use the methods in this
 * class to determine telephony services and states, as well as to access some types of subscriber information.<br />
 * <i>This class is basically a wrapper of the Android's TelephonyManager class.</i>
 * 
 * @author yordan.petrov
 * 
 */
public class TelephonyInformation implements Serializable {
    private static final long serialVersionUID = -1482637719107518924L;

    private CallState callState;

    private DataActivity dataActivity;

    private DataState dataState;

    private NetworkType networkType;

    private PhoneType phoneType;

    private SimState simState;

    private String deviceId;

    private String deviceSoftwareVersion;

    private String line1Number;

    private String networkCountryIso;

    private String networkOperator;

    private String networkOperatorName;

    private String simOperator;

    private String simOperatorName;

    private String subscriberId;

    private String voiceMailAlphaTag;

    private String voiceMailNumber;

    /**
     * Returns a constant indicating the call state (cellular) on the device.
     * 
     * @return {@link CallState} member.
     */
    public CallState getCallState() {
        return callState;
    }

    public void setCallState(CallState callState) {
        this.callState = callState;
    }

    /**
     * Returns a constant indicating the type of activity on a data connection (cellular).
     * 
     * @return {@link DataActivity} member.
     */
    public DataActivity getDataActivity() {
        return dataActivity;
    }

    /**
     * 
     * 
     * @param dataActivity
     */
    public void setDataActivity(DataActivity dataActivity) {
        this.dataActivity = dataActivity;
    }

    /**
     * Returns a constant indicating the current data connection state (cellular).
     * 
     * @return {@link DataState} member.
     */
    public DataState getDataState() {
        return dataState;
    }

    public void setDataState(DataState dataState) {
        this.dataState = dataState;
    }

    /**
     * Returns a constant indicating the device network type.
     * 
     * @return {@link NetworkType} member.
     */
    public NetworkType getNetworkType() {
        return networkType;
    }

    public void setNetworkType(NetworkType networkType) {
        this.networkType = networkType;
    }

    /**
     * Returns a constant indicating the device phone type.
     * 
     * @return {@link PhoneType} member.
     */
    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    /**
     * Returns a constant indicating the state of the device SIM card.
     * 
     * @return {@link SimState} member.
     */
    public SimState getSimState() {
        return simState;
    }

    public void setSimState(SimState simState) {
        this.simState = simState;
    }

    /**
     * Returns the unique device ID, for example, the IMEI for GSM and the MEID or ESN for CDMA phones.
     * 
     * @return the unique device ID.
     */
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * Returns the software version number for the device, for example, the IMEI/SV for GSM phones.
     * 
     * @return the software version number.
     */
    public String getDeviceSoftwareVersion() {
        return deviceSoftwareVersion;
    }

    public void setDeviceSoftwareVersion(String deviceSoftwareVersion) {
        this.deviceSoftwareVersion = deviceSoftwareVersion;
    }

    /**
     * Returns the phone number string for line 1, for example, the MSISDN for a GSM phone.
     * 
     * @return the phone number string for line 1, for example, the MSISDN for a GSM phone.
     */
    public String getLine1Number() {
        return line1Number;
    }

    public void setLine1Number(String line1Number) {
        this.line1Number = line1Number;
    }

    /**
     * Returns the ISO country code equivalent of the current registered operator's MCC (Mobile Country Code).
     * 
     * @return the ISO country code equivalent of the current registered operator's MCC (Mobile Country Code).
     */
    public String getNetworkCountryIso() {
        return networkCountryIso;
    }

    public void setNetworkCountryIso(String networkCountryIso) {
        this.networkCountryIso = networkCountryIso;
    }

    /**
     * Returns the numeric name (MCC+MNC) of current registered operator.
     * 
     * @return the numeric name (MCC+MNC) of current registered operator.
     */
    public String getNetworkOperator() {
        return networkOperator;
    }

    public void setNetworkOperator(String networkOperator) {
        this.networkOperator = networkOperator;
    }

    /**
     * Returns the alphabetic name of current registered operator.
     * 
     * @return the alphabetic name of current registered operator.
     */
    public String getNetworkOperatorName() {
        return networkOperatorName;
    }

    public void setNetworkOperatorName(String networkOperatorName) {
        this.networkOperatorName = networkOperatorName;
    }

    /**
     * Returns the MCC+MNC (mobile country code + mobile network code) of the provider of the SIM.
     * 
     * @return the MCC+MNC (mobile country code + mobile network code) of the provider of the SIM.
     */
    public String getSimOperator() {
        return simOperator;
    }

    public void setSimOperator(String simOperator) {
        this.simOperator = simOperator;
    }

    /**
     * Returns the Service Provider Name (SPN).
     * 
     * @return the Service Provider Name (SPN).
     */
    public String getSimOperatorName() {
        return simOperatorName;
    }

    public void setSimOperatorName(String simOperatorName) {
        this.simOperatorName = simOperatorName;
    }

    /**
     * Returns the unique subscriber ID, for example, the IMSI for a GSM phone.
     * 
     * @return the unique subscriber ID, for example, the IMSI for a GSM phone.
     */
    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    /**
     * Retrieves the alphabetic identifier associated with the voice mail number.
     * 
     * @return the alphabetic identifier associated with the voice mail number.
     */
    public String getVoiceMailAlphaTag() {
        return voiceMailAlphaTag;
    }

    public void setVoiceMailAlphaTag(String voiceMailAlphaTag) {
        this.voiceMailAlphaTag = voiceMailAlphaTag;
    }

    /**
     * Returns the voice mail number.
     * 
     * @return the voice mail number.
     */
    public String getVoiceMailNumber() {
        return voiceMailNumber;
    }

    public void setVoiceMailNumber(String voiceMailNumber) {
        this.voiceMailNumber = voiceMailNumber;
    }
}
