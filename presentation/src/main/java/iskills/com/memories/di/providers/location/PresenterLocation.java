package iskills.com.memories.di.providers.location;

/**
 * lennyhicks
 * 4/1/18
 */

public interface PresenterLocation  {
    double getLat();
    double getLng();
    String getAddress();

    void searchForLocation(CharSequence charSequence);

    void listen(Listener listener);

    void tryToGetCurrentLocation();

    interface Listener {
        void onLocationFound(double lat, double lng, String address);
    }
}
