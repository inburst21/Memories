package iskills.com.memories.di.providers.navigator;

import android.support.annotation.Nullable;

import iskills.com.memories.MainActivity;

/**
 * lennyhicks
 * 4/4/18
 */
public class Navigator {
    private MainActivity mainActivity;


    Navigator(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    public void toEditMemoriesScreen(boolean newPhoto, byte[] imageBytes, @Nullable Long imageId){
        mainActivity.toEditMemoryScreen(newPhoto, imageBytes, imageId);
    }
}
