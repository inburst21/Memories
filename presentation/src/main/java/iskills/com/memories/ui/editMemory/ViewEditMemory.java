package iskills.com.memories.ui.editMemory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.OnTextChanged;
import iskills.com.memories.R;
import iskills.com.memories.di.providers.utilsAndroid.UtilsAndroid;
import iskills.com.memories.mvp.ViewBase;

/**
 * lennyhicks
 * 4/5/18
 */
public class ViewEditMemory extends ViewBase implements ContractEditMemory.View {

    @Inject
    public ContractEditMemory.Presenter presenter;

    @Inject
    public UtilsAndroid utilsAndroid;

    @BindView(R.id.image_view)
    ImageView imageView;

    @BindView(R.id.input_memory_title)
    TextInputEditText inputMemoryTitle;

    @BindView(R.id.input_memory_comment)
    TextInputEditText inputMemoryComment;

    @BindView(R.id.input_memory_location)
    TextInputEditText inputMemoryLocation;

    @BindView(R.id.input_memory_date)
    TextInputEditText inputMemoryDate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_memory, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
//        presenter.showMemory();
    }


    @Override
    public void loadImage(byte[] imageBytes) {
        imageView.setImageBitmap(utilsAndroid.getBitmapFromByteArray(imageBytes));
    }

    @OnClick(R.id.button_save_memory)
    public void onSaveMemory() {
        presenter.saveMemory();
    }

    @OnTextChanged(R.id.input_memory_title)
    public void onTitleChanged(CharSequence charSequence) {
        presenter.onTitleChanged(charSequence);
    }

    @OnTextChanged(R.id.input_memory_comment)
    public void onCommentChanged(CharSequence charSequence) {
        presenter.onCommentChanged(charSequence);
    }

    @OnFocusChange(R.id.input_memory_location)
    public void onLocationChanged(boolean focused) {
        if (!focused) presenter.onLocationChanged(inputMemoryLocation.getText());
    }

    @OnClick(R.id.input_memory_date)
    public void onDateTapped() {
        presenter.onDateTapped();
    }

    @Override
    public void setDate(String date) {
        inputMemoryDate.setText(date);
    }

    @Override
    public void setAddress(String address) {
        if(getView() != null) {
            getActivity().runOnUiThread(() -> inputMemoryLocation.setText(address));
        }
    }

    @Override
    public void updateValues(boolean newPhoto, byte[] imageBytes, @Nullable Long imageId) {
        if (presenter != null)
            presenter.updateValues(newPhoto, imageBytes, imageId);
    }

}
