package iskills.com.memories.ui.addMemory;

import iskills.com.memories.mvp.BaseView;

/**
 * lennyhicks
 * 3/30/18
 */
interface ContractAddMemory {

    interface View extends BaseView {
        void resetViews();
    }

    interface Presenter {
        void onCaptureClicked();

        void onLoadPhotoTapped();
    }
}
