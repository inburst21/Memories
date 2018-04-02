package iskills.com.memories.ui.addMemory;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import iskills.com.domain.model.Memory;
import iskills.com.memories.BuildConfig;
import iskills.com.memories.R;
import iskills.com.memories.di.providers.location.ProviderLocation;
import iskills.com.memories.mvp.ViewBase;
import iskills.com.memories.utils.UtilRealPath;
import iskills.com.memories.utils.Utils;
import iskills.com.memories.utils.UtilsAndroid;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

/**
 * lennyhicks
 * 3/30/18
 */
public class ViewAddMemory extends ViewBase implements ContractAddMemory.View {
    @Inject
    PresenterAddMemory presenterAddMemory;

    @Inject
    ProviderLocation locationProvider;

    @Inject UtilsAndroid utilsAndroid;

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

    @BindView(R.id.loaded_page)
    ConstraintLayout loaded;

    @BindView(R.id.start_page)
    ConstraintLayout startPage;

    private File currentImage;
    private Calendar currentDate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_memory, container, false);
        ButterKnife.bind(this, view);
        locationProvider.setGeocoder(getActivity());
        return view;
    }

    @OnClick(R.id.buttonCapturePhoto)
    public void onClickCapture() {
        currentImage = Utils.createImageFile();
        Uri photoURI = FileProvider.getUriForFile(getActivity(),
                BuildConfig.APPLICATION_ID + ".provider",
                currentImage.getAbsoluteFile());
        Intent camera = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        camera.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
        startActivityForResult(camera, captureRequest);
    }

    @OnClick(R.id.buttonLoadPhoto)
    public void onClickLoad() {
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, loadRequest);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == captureRequest && resultCode == RESULT_OK) {
            currentImage = new File(UtilRealPath.getPath(getActivity(), Uri.fromFile(currentImage.getAbsoluteFile())));
        } else if (requestCode == loadRequest && resultCode == RESULT_OK) {
            currentImage = new File(UtilRealPath.getPath(getActivity(), data.getData()));
        }

        if (resultCode != RESULT_CANCELED) {
            loadImage(Utils.inputStreamToByteArray(utilsAndroid.getInputStreamFromUri(Uri.fromFile(currentImage))));
            presenterAddMemory.memory
                    .setImageBytes(Utils.inputStreamToByteArray(utilsAndroid.getInputStreamFromUri(Uri.fromFile(currentImage))));
        }
    }

    private void loadImage(byte[] imageBytes) {
        imageView.setImageBitmap(utilsAndroid.getBitmapFromByteArray(imageBytes));
        startPage.setVisibility(View.INVISIBLE);
        loaded.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.button_save_memory)
    public void onSaveMemory() {
        saveMemoryToDatabase();
    }

    @OnClick(R.id.layout_memory_date)
    public void openDatePicker() {
        openDatePickerDialog();
    }

    @OnTextChanged(R.id.input_memory_location)
    public void onLocationChanged(CharSequence charSequence){
        presenterAddMemory.memory.setAddress(charSequence.toString());
    }

    @OnTextChanged(R.id.input_memory_title)
    public void onTitleChanged(CharSequence charSequence){
        presenterAddMemory.memory.setTitle(charSequence.toString());
    }

    @OnTextChanged(R.id.input_memory_comment)
    public void onCommentChanged(CharSequence charSequence){
        presenterAddMemory.memory.setComment(charSequence.toString());
    }

    @OnTextChanged(R.id.input_memory_date)
    public void onDateChanged(CharSequence charSequence){
        try {
            presenterAddMemory.memory.setDate(SimpleDateFormat.getDateInstance().parse(charSequence.toString()).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            showError("Invalid Date");
        }
    }

    private void savePhoto(Uri contentUri) {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        mediaScanIntent.setData(contentUri);
        getActivity().sendBroadcast(mediaScanIntent);
    }

    private void saveMemoryToDatabase() {

        Memory memory = new Memory();
        memory.setAddress(locationProvider.getAddress());
        memory.setLat(locationProvider.getLat());
        memory.setLng(locationProvider.getLng());

        presenterAddMemory.addMemory(memory);

    }



    private void openDatePickerDialog() {
        Calendar mCurrentDate = Calendar.getInstance();
        int mYear = mCurrentDate.get(Calendar.YEAR);
        int mMonth = mCurrentDate.get(Calendar.MONTH);
        int mDay = mCurrentDate.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog mDatePicker = new DatePickerDialog(getActivity(),
                (datePicker, year, month, day) -> {
                    currentDate = Utils.getDateFromDatePicker(datePicker);
                    inputMemoryDate.setText(SimpleDateFormat.getDateInstance().format(new Date(currentDate.getTimeInMillis())));
                    inputMemoryLocation.setText(locationProvider.getAddress());
                }, mYear, mMonth, mDay);
        mDatePicker.show();
    }
}