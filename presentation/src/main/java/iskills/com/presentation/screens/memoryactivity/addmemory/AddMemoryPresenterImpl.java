package iskills.com.presentation.screens.memoryactivity.addmemory;

import javax.annotation.Nullable;
import javax.inject.Inject;

import iskills.com.presentation.di.activity.utils.activityresult.ActivityResultListener;
import iskills.com.presentation.di.activity.utils.camera.PresenterCamera;
import iskills.com.presentation.di.services.navigator.PresenterNavigator;
import iskills.com.presentation.screens.common.BasePresenter;

/** lennyhicks 3/30/18 */
public class AddMemoryPresenterImpl extends BasePresenter<AddMemoryView>
    implements AddMemoryPresenter, ActivityResultListener.Listener {

  private final PresenterCamera presenterCamera;
  private final PresenterNavigator navigator;
  private int captureRequest = 1;
  private int loadRequest = 2;

  @Inject
  AddMemoryPresenterImpl(
      AddMemoryView view,
      PresenterNavigator navigator,
      PresenterCamera presenterCamera,
      ActivityResultListener activityResultListener) {
    super(view);
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
