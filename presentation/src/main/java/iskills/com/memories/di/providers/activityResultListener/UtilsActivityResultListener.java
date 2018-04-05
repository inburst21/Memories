package iskills.com.memories.di.providers.activityResultListener;

import javax.annotation.Nullable;
import javax.inject.Inject;

/**
 * lennyhicks
 * 4/5/18
 */
public class UtilsActivityResultListener {

    private ActivityResult.Listener listener;

    @Inject
    UtilsActivityResultListener() {
    }


    public void onActivityResult(int requestCode, int resultCode, @Nullable String data) {
        if (listener != null)
            listener.onActivityResult(requestCode, resultCode, data);
    }

    public void listen(ActivityResult.Listener listener) {
        this.listener = listener;
    }
}
