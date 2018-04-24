package iskills.com.presentation.screens.memoryactivity.addmemory;

import javax.inject.Inject;

import iskills.com.presentation.constants.Constants;
import iskills.com.presentation.di.activity.navigator.PresenterNavigator;
import iskills.com.presentation.di.activity.utils.activityresult.ActivityResultListener;
import iskills.com.presentation.di.activity.utils.camera.CameraPresenter;
import iskills.com.presentation.screens.common.BasePresenter;

/** lennyhicks 3/30/18 */
public class AddMemoryPresenterImpl extends BasePresenter<AddMemoryView>
    implements AddMemoryPresenter, ActivityResultListener.Listener {

  private final CameraPresenter cameraPresenter;
  private final PresenterNavigator navigator;

  @Inject
  AddMemoryPresenterImpl(
      AddMemoryView view,
      PresenterNavigator navigator,
      CameraPresenter cameraPresenter,
      ActivityResultListener activityResultListener) {
    super(view);
    this.navigator = navigator;
    this.cameraPresenter = cameraPresenter;
    activityResultListener.listen(this);
  }

  @Override
  public void onCaptureClicked() {
    cameraPresenter.openCamera();
  }

  @Override
  public void onLoadPhotoTapped() {
    cameraPresenter.loadGallery();
  }

  private void onLoadPhotoResult(String photoUri) {
    navigator.toEditMemoryScreen(cameraPresenter.getImageBytes(photoUri));
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, String data) {
    if (requestCode == Constants.CAPTURE_REQUEST) {
      onPhotoTaken();
    } else if (requestCode == Constants.LOAD_REQUEST) {
      onLoadPhotoResult(data);
    }
  }

  private void onPhotoTaken() {
    navigator.toEditMemoryScreen(cameraPresenter.onPhotoTakenResult());
  }
}
