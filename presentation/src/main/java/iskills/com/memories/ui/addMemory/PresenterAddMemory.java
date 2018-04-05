package iskills.com.memories.ui.addMemory;

import java.util.Calendar;

import javax.annotation.Nullable;
import javax.inject.Inject;

import io.reactivex.Scheduler;
import iskills.com.domain.usecases.UseCaseAddMemory;
import iskills.com.memories.di.providers.activityResultListener.ActivityResult;
import iskills.com.memories.di.providers.activityResultListener.UtilsActivityResultListener;
import iskills.com.memories.di.providers.camera.PresenterCamera;
import iskills.com.memories.di.providers.date.PresenterDate;
import iskills.com.memories.di.providers.fileProviders.FileUtils;
import iskills.com.memories.di.providers.location.PresenterLocation;
import iskills.com.memories.di.qualifiers.MainThread;
import iskills.com.memories.di.qualifiers.UiThread;
import iskills.com.memories.mvp.BasePresenter;

/**
 * lennyhicks
 * 3/30/18
 */
public class PresenterAddMemory extends BasePresenter<ContractAddMemory.View> implements ContractAddMemory.Presenter, PresenterDate.Listener, ActivityResult.Listener, PresenterLocation.Listener {

    @Inject PresenterDate presenterDate;
    @Inject PresenterCamera utilsCamera;
    @Inject FileUtils fileUtils;
    private PresenterLocation presenterLocation;


    private int captureRequest = 1;
    private int loadRequest = 2;

    private UseCaseAddMemory useCaseAddMemory;
    private Scheduler main;
    private Scheduler ui;

    @Inject
    PresenterAddMemory(ContractAddMemory.View view, UseCaseAddMemory useCaseAddMemory, @MainThread Scheduler main, @UiThread Scheduler ui, UtilsActivityResultListener listenerActivityResult, PresenterLocation presenterLocation) {
        super(view);
        this.useCaseAddMemory = useCaseAddMemory;
        this.main = main;
        this.ui = ui;
        listenerActivityResult.listen(this);
        this.presenterLocation = presenterLocation;
        presenterLocation.getLat();
        this.presenterLocation.listen(this);
    }

    @Override
    public void saveMemory() {
        addDisposable(useCaseAddMemory.add(memory)
                .subscribeOn(main)
                .observeOn(ui)
                .subscribe(() -> view.showSuccess("Memory Saved Successfully"),
                        throwable -> view.showError(throwable.getLocalizedMessage()))
        );
    }

    @Override
    public void onCaptureClicked() {
        utilsCamera.openCamera();
    }

    @Override
    public void onCommentChanged(CharSequence charSequence) {
        memory.comment = charSequence.toString();
    }

    @Override
    public void onTitleChanged(CharSequence charSequence) {
        memory.title = charSequence.toString();
    }

    @Override
    public void onLoadPhotoTapped() {
        utilsCamera.loadGallery();
    }

    @Override
    public void onDateTapped() {
        presenterDate.openDatePicker(this);
    }

    @Override
    public void onLocationChanged(CharSequence charSequence) {
        if(memory.address != null) {
            if (!memory.address.equals(charSequence.toString()))
                presenterLocation.searchForLocation(charSequence);
        }
    }

    @Override
    public void onDatePickerSet(Calendar dateFromDatePicker) {
        memory.memoryDate = dateFromDatePicker;
        view.setDate(presenterDate.formatDate(dateFromDatePicker));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable String data) {
        view.showSuccess(requestCode + " request");
        if (requestCode == captureRequest) {
            onPhotoTaken();
        } else if (requestCode == loadRequest) {
            onLoadPhotoResult(data);
        }
    }

    private void onPhotoTaken() {
        memory.imageBytes = utilsCamera.onPhotoTakenResult();
        view.loadImage(memory.imageBytes);
    }

    private void onLoadPhotoResult(String photoUri) {
        memory.imageBytes = fileUtils.getBytesFromUriString(photoUri);
        view.loadImage(memory.imageBytes);
    }

    @Override
    public void onLocationFound(double lat, double lng, String address) {
        memory.address = address;
        memory.lat = lat;
        memory.lng = lng;
        view.setAddress(memory.address);
    }
}
