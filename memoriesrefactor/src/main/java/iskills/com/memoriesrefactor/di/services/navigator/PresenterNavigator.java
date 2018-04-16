package iskills.com.memoriesrefactor.di.services.navigator;

import android.support.annotation.Nullable;

/**
 * lennyhicks
 * 4/12/18
 */
public interface PresenterNavigator {
    void toMemoriesScreen();

    void toMapScreen();

    void toUploadScreen();

    void toEditMemoryScreen(boolean newPhoto, byte[] imageBytes, @Nullable Long imageId);

    void toEditMemoryScreen(byte[] imageBytes);
}
