package iskills.com.memoriesrefactor.screens.common.fragments;

import android.widget.Toast;

import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

public class BaseFragment extends DaggerFragment {

    protected Unbinder unbinder;

    public void showSuccess(String success) {
        Toast.makeText(getActivity(), success, Toast.LENGTH_SHORT).show();
    }

    public void showError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }
}
