package iskills.com.presentation.screens.updatememoryactivity.editMemoryFragment;

import android.support.annotation.Nullable;

/** lennyhicks 4/5/18 */
interface EditMemoryPresenter {

    void saveMemory();

    void onCommentChanged(CharSequence charSequence);

    void onTitleChanged(CharSequence charSequence);

    void onDateTapped();

    void onLocationChanged(CharSequence charSequence);

    void updateValues(byte[] imageBytes, @Nullable Long imageId);

    void onDeleteTapped();

}
