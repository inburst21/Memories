package iskills.com.memoriesrefactor.di.activity.utils.activityresult;

import javax.annotation.Nullable;

/**
 * lennyhicks
 * 4/15/18
 */
public class ActivityResultListener {
    ActivityResultListener.Listener listener;

    public void listen(ActivityResultListener.Listener listener){
        this.listener = listener;
    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable String data){
        if(listener != null)
        listener.onActivityResult(requestCode, resultCode, data);
    }

    public interface Listener {
        void onActivityResult(int requestCode, int resultCode, @Nullable String data);
    }
}
