package iskills.com.memories.di.providers.location;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import iskills.com.memories.MainActivity;


/**
 * lennyhicks
 * 3/31/18
 */
public class ProviderLocation implements PresenterLocation {
    public MainActivity activity;
    private Observable<Location> currentLocation;
    private Address currentAddress;
    private LocationManager locationManager;
    private Geocoder geocoder;
    private String provider;
    private Criteria criteria = new Criteria();
    private String[] requiredPermissions = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};

    private Listener listener;


    @Inject
    ProviderLocation(MainActivity mainActivity) {
        this.activity = mainActivity;
        startModule();
    }

    @SuppressLint("MissingPermission")
    private void getCurrentLocation(boolean forceUpdate) {
        if (currentLocation == null || forceUpdate) {
            currentLocation = Observable.just(locationManager.getLastKnownLocation(provider));
            try {
                if (Geocoder.isPresent()) {
                    List<Address> address = geocoder.getFromLocation(getCurrentLocation().getLatitude(), getCurrentLocation().getLongitude(), 1);
                    if (address.size() > 0) {
                        currentAddress = address.get(0);
                        updateListeners();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateListeners() {
        Log.d("test", "udating location");
        if(listener != null)
        listener.onLocationFound(currentAddress.getLatitude(), currentAddress.getLongitude(), getAddress());
    }

    private Location getCurrentLocation() {
        if (currentLocation == null) {
            getCurrentLocation(false);
        }
        return currentLocation.blockingSingle();
    }

    @Override
    public double getLat() {
        return getCurrentLocation().getLatitude();
    }

    @Override
    public double getLng() {
        return getCurrentLocation().getLongitude();
    }

    @Override
    public String getAddress() {
        if (currentAddress == null) {
            getCurrentLocation(true);
        } else {
            return currentAddress.getLocality() + ", " + currentAddress.getAdminArea();
        }
        return "Error getting Address";
    }

    @Override
    public void searchForLocation(CharSequence charSequence) {
        if (Geocoder.isPresent()) {
            List<Address> address = null;
            try {
                address = geocoder.getFromLocationName(charSequence.toString(), 1);
                if (address.size() > 0) {
                    currentAddress = address.get(0);
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
                locationManager.getLastKnownLocation(provider);

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

}
