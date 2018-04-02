package iskills.com.memories.mvp;

import android.widget.Toast;

import dagger.android.DaggerFragment;

/**
 * lennyhicks
 * 4/1/18
 */
public class ViewBase extends DaggerFragment implements BaseView {

    protected int captureRequest = 1;
    protected int loadRequest = 2;

    @Override
    public void showSuccess(String success) {
        showMessage(success);
    }

    @Override
    public void showError(String error) {
        showMessage(error);
    }

    private void showMessage(String msg) {
        Toast.makeText(getActivity().getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
