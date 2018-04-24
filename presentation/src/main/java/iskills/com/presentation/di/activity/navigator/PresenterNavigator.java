package iskills.com.presentation.di.activity.navigator;

import iskills.com.presentation.di.activity.utils.activityresult.CallbackDeleteDialog;

/**
 * lennyhicks
 * 4/12/18
 */
public interface PresenterNavigator {
    void toMemoriesScreen();

    void toMapScreen();

    void toUploadScreen();

    void toEditMemoryScreen(byte[] imageBytes);

    void toEditMemoryScreen(Long id);

    void openPreviewDialog(Long id);

    void showDeleteConfirmation(CallbackDeleteDialog callbackDeleteDialog);
}
