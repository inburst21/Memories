package iskills.com.memoriesrefactor.screens.memoryactivity.addmemory;

import javax.annotation.Nullable;
import javax.inject.Inject;

import iskills.com.memoriesrefactor.di.activity.utils.activityresult.ActivityResultListener;
import iskills.com.memoriesrefactor.di.activity.utils.camera.PresenterCamera;
import iskills.com.memoriesrefactor.di.services.navigator.PresenterNavigator;

/**
 * lennyhicks
 * 3/30/18
 */
public class AddMemoryPresenter implements ContractAddMemory.Presenter, ActivityResultListener.Listener {

    private final ContractAddMemory.View view;
    private final PresenterCamera presenterCamera;
    private final PresenterNavigator navigator;
    private int captureRequest = 1;
    private int loadRequest = 2;

    @Inject
    AddMemoryPresenter(ContractAddMemory.View view,
                       PresenterNavigator navigator,
                       PresenterCamera presenterCamera,
                       ActivityResultListener activityResultListener) {
        this.view = view;
        this.navigator = navigator;
        this.presenterCamera = presenterCamera;
        activityResultListener.listen(this);
    }

    @Override
    public void onCaptureClicked() {
        presenterCamera.openCamera();
    }


    @Override
    public void onLoadPhotoTapped() {
        presenterCamera.loadGallery();
    }

    private void onLoadPhotoResult(String photoUri) {
        navigator.toEditMemoryScreen(presenterCamera.getImageBytes(photoUri));
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable String data) {

        if (requestCode == captureRequest) {
            onPhotoTaken();
        } else if (requestCode == loadRequest) {
            onLoadPhotoResult(data);
        }
    }

    private void onPhotoTaken() {
        navigator.toEditMemoryScreen(true, presenterCamera.onPhotoTakenResult(), null);
    }


}
