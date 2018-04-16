package iskills.com.memoriesrefactor.screens.memoryactivity.addmemory;

import iskills.com.memoriesrefactor.screens.common.BaseView;

/**
 * lennyhicks
 * 3/30/18
 */
interface ContractAddMemory {

    interface View extends BaseView {

    }

    interface Presenter {
        void onCaptureClicked();

        void onLoadPhotoTapped();
    }
}
