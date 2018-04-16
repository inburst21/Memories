package iskills.com.memoriesrefactor.di.activity.utils.android;

import android.graphics.Bitmap;

import javax.inject.Inject;

/**
 * lennyhicks
 * 4/15/18
 */
public class ImplAndroid implements PresenterAndroid {

    @Inject
    public ImplAndroid() {
    }

    @Override
    public Bitmap getBitmapFromByteArray(byte[] imageBytes) {
        return null;
    }
}
