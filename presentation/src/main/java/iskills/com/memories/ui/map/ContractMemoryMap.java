package iskills.com.memories.ui.map;

import iskills.com.memories.mvp.BaseView;

/**
 * lennyhicks
 * 4/8/18
 */
public interface ContractMemoryMap {
    interface View extends BaseView {

        void addMemory(Long id, String title, String comment, double lat, double lng, byte[] imageBytes);
    }

    interface Presenter {
        void loadMemories();
        void onMemorySelected(long memoryId);
    }
}
