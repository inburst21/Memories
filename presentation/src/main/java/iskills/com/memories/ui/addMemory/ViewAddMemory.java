package iskills.com.memories.ui.addMemory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import iskills.com.memories.R;
import iskills.com.memories.mvp.ViewBase;
import iskills.com.memories.utils.UtilsAndroid;

/**
 * lennyhicks
 * 3/30/18
 */
public class ViewAddMemory extends ViewBase implements ContractAddMemory.View {

    @Inject
    ContractAddMemory.Presenter presenterAddMemory;

    @Inject
    UtilsAndroid utilsAndroid;

    @BindView(R.id.image_view)
    ImageView imageView;

    @BindView(R.id.input_memory_location)
    TextInputEditText inputMemoryLocation;

    @BindView(R.id.input_memory_date)
    TextInputEditText inputMemoryDate;

    @BindView(R.id.loaded_page)
    ConstraintLayout loaded;

    @BindView(R.id.start_page)
    ConstraintLayout startPage;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_memory, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.buttonCapturePhoto)
    public void onClickCapture() {
        presenterAddMemory.onCaptureClicked();
    }

    @OnClick(R.id.buttonLoadPhoto)
    public void onClickLoad() {
        presenterAddMemory.onLoadPhotoTapped();
    }

    @Override
    public void loadImage(byte[] imageBytes) {
        imageView.setImageBitmap(utilsAndroid.getBitmapFromByteArray(imageBytes));
        startPage.setVisibility(View.INVISIBLE);
        loaded.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.button_save_memory)
    public void onSaveMemory() {
        presenterAddMemory.saveMemory();
    }

    @OnTextChanged(R.id.input_memory_title)
    public void onTitleChanged(CharSequence charSequence) {
        presenterAddMemory.onTitleChanged(charSequence);
    }

    @OnTextChanged(R.id.input_memory_comment)
    public void onCommentChanged(CharSequence charSequence) {
        presenterAddMemory.onCommentChanged(charSequence);
    }

    @OnTextChanged(R.id.input_memory_location)
    public void onLocationChanged(CharSequence charSequence){ presenterAddMemory.onLocationChanged(charSequence); }

    @OnClick(R.id.input_memory_date)
    public void onDateTapped() {
        presenterAddMemory.onDateTapped();
    }

    @Override
    public void resetViews() {

    }

    @Override
    public void setDate(String date) {
        inputMemoryDate.setText(date);
    }

    @Override
    public void setAddress(String address) {
        inputMemoryLocation.setText(address);
    }

}