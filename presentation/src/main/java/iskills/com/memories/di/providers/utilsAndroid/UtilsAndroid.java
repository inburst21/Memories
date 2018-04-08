package iskills.com.memories.di.providers.utilsAndroid;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.inputmethod.InputMethodManager;

import java.util.Objects;

import javax.inject.Inject;

import iskills.com.memories.MainActivity;

/**
 * lennyhicks
 * 4/1/18
 */

public class UtilsAndroid {

    private MainActivity mainActivity;

    @Inject
    public UtilsAndroid(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public Bitmap getBitmapFromByteArray(byte[] imageBytes){
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
    }

    public void hideSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager)mainActivity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        Objects.requireNonNull(inputMethodManager).hideSoftInputFromWindow(Objects.requireNonNull(mainActivity.getCurrentFocus()).getWindowToken(), 0);
    }


}
