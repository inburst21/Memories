package iskills.com.memories.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

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


}
