package iskills.com.memories.ui.editMemory;

import android.support.annotation.Nullable;

import iskills.com.memories.mvp.BaseView;

/**
 * lennyhicks
 * 4/5/18
 */
interface ContractEditMemory {
    interface View extends BaseView {

        void setDate(String date);

        void setAddress(String address);

        void loadImage(byte[] imageBytes);

        void updateValues(boolean newPhoto, byte[] imageBytes, @Nullable Long imageId);
    }

    interface Presenter {
        void saveMemory();

        void onCommentChanged(CharSequence charSequence);

        void onTitleChanged(CharSequence charSequence);

        void onDateTapped();

        void onLocationChanged(CharSequence charSequence);

        void updateValues(boolean newPhoto, byte[] imageBytes, @Nullable Long imageId);

        void showMemory();

    }
}
