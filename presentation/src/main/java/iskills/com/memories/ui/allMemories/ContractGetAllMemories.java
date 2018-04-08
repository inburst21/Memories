package iskills.com.memories.ui.allMemories;

import java.util.List;

import iskills.com.domain.model.Memory;
import iskills.com.memories.mvp.BaseView;

/**
 * lennyhicks
 * 4/1/18
 */
interface ContractGetAllMemories {
    interface View extends BaseView {
        void updateList(List<Memory> memories);
    }

    interface Presenter {
        void getAllMemories();
    }
}
