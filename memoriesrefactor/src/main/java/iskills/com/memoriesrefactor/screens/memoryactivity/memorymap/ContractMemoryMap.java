package iskills.com.memoriesrefactor.screens.memoryactivity.memorymap;

import iskills.com.memoriesrefactor.screens.common.BaseView;

/**
 * lennyhicks
 * 4/8/18
 */
public interface ContractMemoryMap {
    interface View extends BaseView {
        void addMemory(Long id, String title, String comment, double lat, double lng);
    }

    interface Presenter {
        void loadMemories();
        void onMemorySelected(long memoryId);
    }
}
