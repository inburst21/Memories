package iskills.com.presentation.di.activity.utils.camera;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;

import java.io.File;

import javax.inject.Inject;

import iskills.com.presentation.BuildConfig;
import iskills.com.presentation.di.activity.utils.fileProviders.FileUtilPresenter;


/**
 * lennyhicks
 * 4/5/18
 */
class UtilsCamera implements PresenterCamera {

    private int captureRequest = 1;
    private int loadRequest = 2;

    private final Activity activity;
    private final FileUtilPresenter utilsFile;


    private File lastPhoto;
    private Uri lastPhotoUri;
    private boolean savePhotosLocally = true;

    @Inject
    UtilsCamera(Activity activity, FileUtilPresenter fileUtilPresenter){
        this.activity = activity;
        this.utilsFile = fileUtilPresenter;
    }

    @Override
    public void openCamera(){
        lastPhoto = utilsFile.getImageFile();

        lastPhotoUri = FileProvider.getUriForFile(activity,
                BuildConfig.APPLICATION_ID + ".provider",
                lastPhoto.getAbsoluteFile());


        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
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

        return utilsFile.getBytesFromUriString(utilsFile.getPath(Uri.fromFile(lastPhoto).toString()));
    }

    @Override
    public byte[] getImageBytes(String photoUri) {
        return utilsFile.getBytesFromUriString(photoUri);
    }


    private void savePhoto(){
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        mediaScanIntent.setData(Uri.parse(utilsFile.getPath(Uri.fromFile(lastPhoto).toString())));
        activity.sendBroadcast(mediaScanIntent);
    }
}
