package iskills.com.presentation.di.activity.utils.camera;

/**
 * lennyhicks
 * 4/5/18
 */
public interface PresenterCamera {
    void openCamera();
    void loadGallery();
    byte[] onPhotoTakenResult();
    byte[] getImageBytes(String photoUri);
}
