package iskills.com.memories.di.providers.camera;

/**
 * lennyhicks
 * 4/5/18
 */
public interface PresenterCamera {
    void openCamera();
    void loadGallery();
    byte[] onPhotoTakenResult();
}
