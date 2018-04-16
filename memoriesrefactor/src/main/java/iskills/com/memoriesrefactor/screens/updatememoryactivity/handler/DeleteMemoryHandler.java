package iskills.com.memoriesrefactor.screens.updatememoryactivity.handler;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.View;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatDialogFragment;

/**
 * lennyhicks
 * 4/16/18
 */
public class DeleteMemoryHandler extends DaggerAppCompatDialogFragment {

    @Inject
    PresenterDeleteMemory presenterDeleteMemory;

    @Inject
    FragmentManager fragmentManager;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        show(fragmentManager, "test");
    }

    DialogInterface.OnDismissListener onDismissListener = new DialogInterface.OnDismissListener() {
        @Override
        public void onDismiss(DialogInterface dialogInterface) {

        }
    };

}
