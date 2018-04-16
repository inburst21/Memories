package iskills.com.memoriesrefactor.screens.common.fragments;

import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

public class BaseFragment extends DaggerFragment {

    protected Unbinder unbinder;

    public void showSuccess(String success) {

    }

    public void showError(String error) {

    }
}
