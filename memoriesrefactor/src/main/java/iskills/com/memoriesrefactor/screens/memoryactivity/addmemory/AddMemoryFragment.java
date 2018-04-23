package iskills.com.memoriesrefactor.screens.memoryactivity.addmemory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import iskills.com.memoriesrefactor.R;
import iskills.com.memoriesrefactor.screens.common.fragments.BaseFragment;

/**
 * lennyhicks
 * 3/30/18
 */
public class AddMemoryFragment extends BaseFragment implements AddMemoryView{

    @Inject
    protected AddMemoryPresenter presenterAddMemory;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_memory, container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }

    @OnClick(R.id.buttonCapturePhoto)
    public void onClickCapture() {
        presenterAddMemory.onCaptureClicked();
    }

    @OnClick(R.id.buttonLoadPhoto)
    public void onClickLoad() {
        presenterAddMemory.onLoadPhotoTapped();
    }

}