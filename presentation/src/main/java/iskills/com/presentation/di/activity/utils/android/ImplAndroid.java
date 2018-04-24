package iskills.com.presentation.di.activity.utils.android;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

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
        final Bitmap[] bitmap = new Bitmap[1];
        new Thread(() -> bitmap[0] = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length)).run();
        return bitmap[0];
    }
}
