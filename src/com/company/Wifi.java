package com.company;

/**
 * @author Dren Bilalli
 */

public class Wifi {


    private String wifiName;
    private String wifiPassword;
    private String wifiType;
    private String wifiNetworkType;

    public Wifi(String wifiName, String wifiPassword, String wifiType, String wifiNetworkType) throws WifiException {
        if (UtilityClass.isStringEmpty(wifiName)) {
            throw new WifiException("Name of wifi must not be empty");
        }
        if (UtilityClass.isStringEmpty(wifiType)) {
            throw new WifiException("Name of wifiType must not be empty");
        }
        if (UtilityClass.isStringEmpty(wifiPassword)) {
            throw new WifiException("Password must not be empty");
        }
        if (UtilityClass.isStringEmpty(wifiNetworkType)) {
            throw new WifiException("Name of wifiNetworkType must not be empty");
        }
        this.wifiName = wifiName;
        this.wifiPassword = wifiPassword;
        this.wifiType = wifiType;
        this.wifiNetworkType = wifiNetworkType;
    }

    public Wifi() {

    }

    public Wifi(String name) {
        this.wifiName = name;
    }

    public String getWifiName() {
        return wifiName;
    }

    public void setWifiName(String wifiName) {
        this.wifiName = wifiName;
    }

    public String getWifiPassword() {
        return wifiPassword;
    }

    public void setWifiPassword(String wifiPassword) {
        this.wifiPassword = wifiPassword;
    }

    public String getWifiType() {
        return wifiType;
    }

    public void setWifiType(String wifiType) {
        this.wifiType = wifiType;
    }

    public String getWifiNetworkType() {
        return wifiNetworkType;
    }

    public void setWifiNetworkType(String wifiNetworkType) {
        this.wifiNetworkType = wifiNetworkType;
    }

    @Override
    public String toString() {
        return "Wifi{" +
                "wifiName='" + wifiName + '\'' +
                ", wifiPassword='" + wifiPassword + '\'' +
                ", wifiType='" + wifiType + '\'' +
                ", wifiNetworkType='" + wifiNetworkType + '\'' +
                '}';
    }


}
