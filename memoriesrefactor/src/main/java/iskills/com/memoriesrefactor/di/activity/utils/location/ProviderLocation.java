package iskills.com.memoriesrefactor.di.activity.utils.location;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;


/**
 * lennyhicks
 * 3/31/18
 */
class ProviderLocation implements PresenterLocation, LocationListener {
    private Activity activity;
    private Location currentLocation;
    private Address currentAddress;
    private LocationManager locationManager;
    private Geocoder geocoder;
    private String provider;
    private Criteria criteria = new Criteria();
    private String[] requiredPermissions = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};

    private Listener listener;
    boolean forceUpdate = false;


    @Inject
    ProviderLocation(Activity mainActivity) {
        this.activity = mainActivity;
    }

    @SuppressLint("MissingPermission")
    private Location getCurrentLocation() {
        if (currentLocation == null || forceUpdate) {
            currentLocation = locationManager.getLastKnownLocation(provider);
        }
        return currentLocation;
    }

    private void updateListeners() {
        if (listener != null)
            listener.onLocationFound(currentLocation.getLatitude(), currentLocation.getLongitude(), getAddress());
    }


    @Override
    public String getAddress() {
        if (currentAddress == null) {
            getCurrentLocation();
        } else {
            return currentAddress.getLocality() + ", " + currentAddress.getAdminArea();
        }
        return "Error getting Address";
    }

    @Override
    public void searchForLocation(CharSequence charSequence) {
        if (charSequence.length() < 3) return;
        if (Geocoder.isPresent()) {
            List<Address> address;
            try {
                address = geocoder.getFromLocationName(charSequence.toString(), 1);
                if (address.size() > 0) {
                    currentAddress = address.get(0);
                    getCurrentLocation().setLatitude(currentAddress.getLatitude());
                    getCurrentLocation().setLongitude(currentAddress.getLongitude());
                    updateListeners();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void listen(Listener listener) {
        this.listener = listener;
        startModule();
    }

    @SuppressLint("MissingPermission")
    private void startModule() {
        if (!checkPermissions()) {
            ActivityCompat.requestPermissions(activity, requiredPermissions, 1);
        } else if (checkPermissions()) {
            geocoder = new Geocoder(activity);
            locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
            // Gets best provider depending on criteria, @enabledOnly checks to make sure the provider is available
            if (locationManager != null) {
                provider = locationManager.getBestProvider(criteria, true);
                locationManager.requestSingleUpdate(provider, this, null);
            }
        }
    }

    private boolean checkPermissions() {
        for (String requiredPermission : requiredPermissions) {
            if (ActivityCompat.checkSelfPermission(activity, requiredPermission) != PackageManager.PERMISSION_GRANTED)
                return false;
        }
        return true;
    }

    @Override
    public void onLocationChanged(Location location) {
        currentLocation = location;

        updateAddress();
    }

    private void updateAddress() {
        try {
            if (Geocoder.isPresent()) {
                List<Address> address;
                try {
                    address = geocoder.getFromLocation(currentLocation.getLatitude(), currentLocation.getLongitude(), 1);

                    if (address.size() > 0) {
                        currentAddress = address.get(0);
                        updateListeners();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            updateListeners();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
