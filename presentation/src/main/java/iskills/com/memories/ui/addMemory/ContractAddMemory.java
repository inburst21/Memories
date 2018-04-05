package iskills.com.memories.ui.addMemory;

import iskills.com.domain.model.Memory;
import iskills.com.memories.mvp.BaseView;

/**
 * lennyhicks
 * 3/30/18
 */
public interface ContractAddMemory {

    interface View extends BaseView {
        void resetViews();

        void setDate(String date);
        void setAddress(String address);
        void loadImage(byte[] imageBytes);
    }

    interface Presenter  {
        Memory memory = new Memory();
        void saveMemory();

        void onCaptureClicked();

        void onCommentChanged(CharSequence charSequence);

        void onTitleChanged(CharSequence charSequence);

        void onLoadPhotoTapped();

        void onDateTapped();

        void onLocationChanged(CharSequence charSequence);
    }

}
