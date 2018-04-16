package iskills.com.memoriesrefactor.di.activity.utils.location;

/**
 * lennyhicks
 * 4/1/18
 */

public interface PresenterLocation  {
    String getAddress();

    void searchForLocation(CharSequence charSequence);

    void listen(Listener listener);

    interface Listener {
        void onLocationFound(double lat, double lng, String address);
    }
}
