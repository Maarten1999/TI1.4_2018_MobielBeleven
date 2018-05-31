package com.a5.mobielbeleven.Adapters;

import android.app.Activity;
import android.os.RemoteException;
import android.util.Log;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;

import java.util.Collection;


public class BaeconAdapter extends Activity implements BeaconConsumer, RangeNotifier {
    private static final String TAG = BaeconAdapter.class.getSimpleName();
    private boolean bool;
    private BeaconManager beaconManager;


    protected void onCreate()
    {
        beaconManager = BeaconManager.getInstanceForApplication(this);
        beaconManager.getBeaconParsers().clear();
        beaconManager.getBeaconParsers().add(new BeaconParser("iBeacon").setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24"));
        beaconManager.bind(this);
    }

    public void onBeaconServiceConnect(){
        Log.d(TAG, "Beacon service connected.  Starting ranging.");

        try {
            beaconManager.startRangingBeaconsInRegion(new Region("allbeacons", null, null, null));
            beaconManager.addRangeNotifier(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void didRangeBeaconsInRegion(Collection<Beacon> beacons, Region region) {
        if (!beacons.isEmpty())
        {
            bool = true;
        }
        else
        {
            bool = false;
        }
        for (Beacon beacon: beacons) {
        Log.d(TAG, "Detected beacon: "+beacon);
    }
    }
    public boolean getInRange()
    {

        return bool;
    }
}
