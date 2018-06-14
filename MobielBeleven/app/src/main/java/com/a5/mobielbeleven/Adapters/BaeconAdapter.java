package com.a5.mobielbeleven.Adapters;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;



import java.util.ArrayList;
import java.util.List;


public class BaeconAdapter {
    private static final String TAG = BaeconAdapter.class.getSimpleName();
    private boolean bool;
    private String ssid;
    private ArrayList<String> ssidl;
    WifiManager mWifiManager;
    List<ScanResult> wifiList;



    public BaeconAdapter(Context con)
    {

        ssidl = new ArrayList<String>();
        mWifiManager = (WifiManager) con.getSystemService(Context.WIFI_SERVICE);
        con.registerReceiver(mWifiScanReceiver,
                new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        if(mWifiManager.isWifiEnabled()==false)
        {
            mWifiManager.setWifiEnabled(true);
        }
        mWifiManager.startScan();
    }

    // het aanmaken van de receiver en het bouwen van de wifi scan voor beacons
    private final BroadcastReceiver mWifiScanReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context c, Intent intent) {
            if (intent.getAction().equals(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)) {
                wifiList = mWifiManager.getScanResults();
                boolean bl = mWifiManager.getScanResults().isEmpty();
                didRangeBeaconsInRegion();
            }
        }
    };


    public void scan()

    {
        if(wifiList != null)
        {
            wifiList.clear();
        }
        if(ssidl != null)
        {
            ssidl.clear();
        }
        mWifiManager.startScan();
    }



    // code voor het kijken of er beacons in range zijn en welke word geselecteerd voor het spel
    public void didRangeBeaconsInRegion() {
        if (!wifiList.isEmpty())
        {
            for (ScanResult beacon: wifiList) {

                switch (beacon.SSID)
                {
                    case "COBRA_ATTRACTION_BEACON":
                        ssidl.add(beacon.SSID);
                        break;


                    case "PIETER_ATTRACTION_BEACON":
                        ssidl.add(beacon.SSID);
                        break;

                    case "AMPERA_ATTRACTION_BEACON":
                        ssidl.add(beacon.SSID);
                        break;

                    default:
                        ssid = "0";
                        break;
                }

            }
            if(!ssidl.isEmpty())
            {
                ssid = ssidl.get(0);
                bool = true;
            }
            else
            {
                bool = false;
            }

        }
        else
        {
            bool = false;
        }

    }

    // get methode voor de waarde InRange
    public boolean getInRange()
    {
        return bool;
    }

    // get  methode voor het ssid van de de beacon die in range is

    public String getssid()
    {
        return ssid;
    }
}
