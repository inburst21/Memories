package iskills.com.memories.di.providers.activityResultListener;

/**
 * lennyhicks
 * 4/5/18
 */
public interface ActivityResult {
    interface Listener {
        void onActivityResult(int requestCode, int resultCode, String data);
    }
}
