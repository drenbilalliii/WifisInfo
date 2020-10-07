package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Dren Bilalli on 10/7/2020
 */

public class FindingWifiProfiles {


    private ArrayList<String> wifiNames;
    private ArrayList<Wifi> listofWifi;
    private Runtime runtime;
    private BufferedReader bufferedReader;
    static ArrayList<Wifi> c = new ArrayList<>();


    public FindingWifiProfiles(){
        wifiNames = new ArrayList<>();
        listofWifi = new ArrayList<>();
        runtime = Runtime.getRuntime();
    }

    public ArrayList<String> getWifiNames() {
        return wifiNames;
    }

    public ArrayList<Wifi> getListofWifi() {
        return listofWifi;
    }

    /**
     * @throws IOException
     *
     */
    private void findNames() throws IOException {

        Process process = runtime.exec("netsh wlan show profiles");

        bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String wifiName = "";

        while ((wifiName = bufferedReader.readLine()) != null) {
            if (wifiName.contains("All User Profile")) {
                wifiNames.add(wifiName.split(":")[1]);
            }
        }

    }

    private int getSizeOfWifis(){
        return wifiNames.size();
    }
    private void findInfoForAllWifi() throws IOException,WifiException {

        ArrayList<String> list = getWifiNames();

        if(list.size() <=0){
            throw new WifiException("There is no Wifi registred on your computer");
        }

        Wifi w = null;

        for (int i = 0; i < list.size(); i++) {
            w = new Wifi();
            Process p = runtime.exec("netsh wlan show profile " + list.get(i) + " key=clear");
            bufferedReader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String lines = "";
            String wifiName = "";
            String wifiPassword = "";
            String wifiType = "";
            String wifiNetworkType = "";

            while ((lines = bufferedReader.readLine()) != null) {
                if (lines.contains("Name")) {
                    wifiName = lines.split(":")[1];
                    w.setWifiName(wifiName);
                } else if (lines.contains("Type")) {
                    wifiType = lines.split(":")[1];
                    w.setWifiType(wifiType);
                } else if (lines.contains("Key Content")) {
                    wifiPassword = lines.split(":")[1];
                    w.setWifiPassword(wifiPassword);
                } else if (lines.contains("Network type")) {
                    wifiNetworkType = lines.split(":")[1];
                    w.setWifiNetworkType(wifiNetworkType);
                }

            }
            listofWifi.add(w);
        }

    }



    public static void main(String[] args) {

        FindingWifiProfiles findingWifiProfiles = new FindingWifiProfiles();
        try {
            findingWifiProfiles.findNames();
             findingWifiProfiles.findInfoForAllWifi();

            var list = findingWifiProfiles.getListofWifi();

            String s = (list.size() <=1) ? "There is " + list.size() + " wifi found" : "There are " + list.size() + " wifis found";

            System.out.println(s);

            System.out.println("Description");

            list.stream().forEach(System.out::println);


        } catch (IOException | WifiException e) {
            e.printStackTrace();
        }

    }


}
