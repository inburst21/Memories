package iskills.com.memories.ui.addMemory;

import javax.annotation.Nullable;
import javax.inject.Inject;

import iskills.com.memories.di.providers.activityResultListener.ActivityResult;
import iskills.com.memories.di.providers.activityResultListener.UtilsActivityResultListener;
import iskills.com.memories.di.providers.camera.PresenterCamera;
import iskills.com.memories.di.providers.fileProviders.FileUtils;
import iskills.com.memories.di.providers.navigator.Navigator;
import iskills.com.memories.mvp.BasePresenter;

/**
 * lennyhicks
 * 3/30/18
 */
public class PresenterAddMemory extends BasePresenter<ContractAddMemory.View> implements ContractAddMemory.Presenter, ActivityResult.Listener {

    private final PresenterCamera utilsCamera;
    private final FileUtils fileUtils;
    private final Navigator navigator;
    private int captureRequest = 1;
    private int loadRequest = 2;



    @Inject
    PresenterAddMemory(ContractAddMemory.View view,
                       PresenterCamera utilsCamera,
                       FileUtils fileUtils,
                       Navigator navigator,
                       UtilsActivityResultListener utilsActivityResultListener) {
        super(view);
        this.utilsCamera = utilsCamera;
        this.fileUtils = fileUtils;
        this.navigator = navigator;
        utilsActivityResultListener.listen(this);
    }

    @Override
    public void onCaptureClicked() {
        utilsCamera.openCamera();
    }


    @Override
    public void onLoadPhotoTapped() {
        utilsCamera.loadGallery();
    }


    private void onLoadPhotoResult(String photoUri) {
        navigator.toEditMemoriesScreen(true, fileUtils.getBytesFromUriString(photoUri), null);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable String data) {
        if (requestCode == captureRequest) {
            onPhotoTaken();
        } else if (requestCode == loadRequest) {
            onLoadPhotoResult(data);
        } else {
            view.resetViews();
        }
    }

    private void onPhotoTaken() {
        navigator.toEditMemoriesScreen(true, utilsCamera.onPhotoTakenResult(), null);
    }


}
