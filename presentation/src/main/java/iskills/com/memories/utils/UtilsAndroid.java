package iskills.com.memories.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.inject.Inject;

/**
 * lennyhicks
 * 4/1/18
 */

public class UtilsAndroid {

    protected Context context;

    @Inject
    public UtilsAndroid(Context context) {
        this.context = context;
    }

    public Bitmap getBitmapFromByteArray(byte[] imageBytes){
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
    }

    public InputStream getInputStreamFromUri(Uri data) {
        try {
            return context.getContentResolver().openInputStream(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
