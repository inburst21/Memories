package iskills.com.memories.di.providers.location;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;

import java.io.IOException;

import io.reactivex.Observable;


/**
 * lennyhicks
 * 3/31/18
 */
public class ProviderLocation extends Activity implements PresenterLocation {
    private Context context;
    private Observable<Location> currentLocation;
    private Address currentAddress;
    private LocationManager locationManager;
    private Geocoder geocoder;
    private String provider;
    private Criteria criteria = new Criteria();
    private String[] requiredPermissions = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};

    ProviderLocation(Context context) {
        this.context = context;
        startModule();
    }

    @SuppressLint("MissingPermission")
    private void getCurrentLocation(boolean forceUpdate) {
        if (currentLocation == null || forceUpdate) {
            currentLocation = Observable.just(locationManager.getLastKnownLocation(provider));
            try {
                if(Geocoder.isPresent()) {
                    currentAddress = geocoder.getFromLocation(getCurrentLocation().getLatitude(), getCurrentLocation().getLongitude(), 1).get(0);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Location getCurrentLocation() {
        if (currentLocation == null) {
            getCurrentLocation(true);
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

    @SuppressLint("MissingPermission")
    private void startModule() {
        if (!checkPermissions()) {
            ActivityCompat.requestPermissions(this, requiredPermissions, 1);
        } else if (checkPermissions()) {

            locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
            // Gets best provider depending on criteria, @enabledOnly checks to make sure the provider is available
            if (locationManager != null) {
                provider = locationManager.getBestProvider(criteria, true);
                locationManager.getLastKnownLocation(provider);
            }

        }
    }

    private boolean checkPermissions() {
        for (String requiredPermission : requiredPermissions) {
            if (ActivityCompat.checkSelfPermission(context, requiredPermission) != PackageManager.PERMISSION_GRANTED)
                return false;
        }
        return true;
    }

    public void setGeocoder(Activity activity){
        geocoder = new Geocoder(activity);
    }
}
