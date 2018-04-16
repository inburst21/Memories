package iskills.com.memoriesrefactor.screens.memoryactivity.memorypreviewdialog;

import iskills.com.memoriesrefactor.screens.common.BaseView;

/**
 * lennyhicks
 * 4/16/18
 */
public interface ContractMemoryPreviewDialog extends BaseView {
    interface View {
        void setDate(String date);
        void setAddress(String address);
        void loadImage(byte[] imageBytes);
        void setTitle(String title);
        void setComment(String comment);
        void dismiss();
    }

    interface Presenter {
        void showImage(Long id);
        void editMemory();
        void onClose();
    }
}
