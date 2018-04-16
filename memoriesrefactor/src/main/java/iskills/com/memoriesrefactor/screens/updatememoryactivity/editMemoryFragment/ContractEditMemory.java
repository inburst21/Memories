package iskills.com.memoriesrefactor.screens.updatememoryactivity.editMemoryFragment;

import android.support.annotation.Nullable;

import iskills.com.memoriesrefactor.screens.common.BaseView;

/**
 * lennyhicks
 * 4/5/18
 */
interface ContractEditMemory {
    interface View extends BaseView {

        void setDate(String date);

        void setAddress(String address);

        void loadImage(byte[] imageBytes);

    }

    interface Presenter {
        void saveMemory();

        void onCommentChanged(CharSequence charSequence);

        void onTitleChanged(CharSequence charSequence);

        void onDateTapped();

        void onLocationChanged(CharSequence charSequence);

        void updateValues(boolean newPhoto, byte[] imageBytes, @Nullable Long imageId);

    }
}
