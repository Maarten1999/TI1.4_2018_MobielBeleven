package com.a5.mobielbeleven.Adapters;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.util.Log;


import java.util.ArrayList;
import java.util.Collection;
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

    protected void onCreate()
    {

//        beaconManager = BeaconManager.getInstanceForApplication(this);
//        beaconManager.getBeaconParsers().clear();
//        beaconManager.getBeaconParsers().add(new BeaconParser().setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24"));
//        beaconManager.bind(this);
    }



    public void scan()
    {
        mWifiManager.startScan();
    }

//    public void onBeaconServiceConnect(){
//        Log.d(TAG, "Beacon service connected.  Starting ranging.");
//
//        try {
//            beaconManager.startRangingBeaconsInRegion(new Region("allbeacons", null, null, null));
//            beaconManager.addRangeNotifier(this);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//    }

    public void didRangeBeaconsInRegion() {
        if (!wifiList.isEmpty())
        {
            for (ScanResult beacon: wifiList) {

                switch (beacon.SSID)
                {
                    case "COBRA_ATTRACTION_BEACON":
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

    public boolean getInRange()
    {
        return bool;
    }

    public String getssid()
    {
        return ssid;
    }
}
