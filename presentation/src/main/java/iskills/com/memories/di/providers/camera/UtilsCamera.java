package iskills.com.memories.di.providers.camera;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;

import java.io.File;

import javax.inject.Inject;

import iskills.com.memories.BuildConfig;
import iskills.com.memories.MainActivity;
import iskills.com.memories.di.providers.fileProviders.FileUtils;

/**
 * lennyhicks
 * 4/5/18
 */
class UtilsCamera implements PresenterCamera {

    private int captureRequest = 1;
    private int loadRequest = 2;

    private final MainActivity activity;
    private final FileUtils fileUtils;


    private File lastPhoto;
    private Uri lastPhotoUri;
    private boolean savePhotosLocally = true;

    @Inject
    UtilsCamera(MainActivity activity, FileUtils fileUtils){
        this.activity = activity;
        this.fileUtils = fileUtils;
    }

    @Override
    public void openCamera(){
        lastPhoto = fileUtils.getImageFile();

        lastPhotoUri = FileProvider.getUriForFile(activity,
                BuildConfig.APPLICATION_ID + ".provider",
                lastPhoto.getAbsoluteFile());


        Intent camera = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        camera.putExtra(MediaStore.EXTRA_OUTPUT, lastPhotoUri);
        activity.startActivityForResult(camera, captureRequest);
    }

    @Override
    public void loadGallery(){
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(i, loadRequest);
    }

    @Override
    public byte[] onPhotoTakenResult() {
        if(savePhotosLocally) {
            savePhoto();
        }

        return fileUtils.getBytesFromUriString(fileUtils.getPath(Uri.fromFile(lastPhoto).toString()));
    }


    private void savePhoto(){
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        mediaScanIntent.setData(Uri.parse(fileUtils.getPath(Uri.fromFile(lastPhoto).toString())));
        activity.sendBroadcast(mediaScanIntent);
    }
}
