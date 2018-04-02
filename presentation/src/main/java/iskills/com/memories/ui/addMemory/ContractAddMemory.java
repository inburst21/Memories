package iskills.com.memories.ui.addMemory;

import iskills.com.domain.model.Memory;
import iskills.com.memories.mvp.BaseView;

/**
 * lennyhicks
 * 3/30/18
 */
public interface ContractAddMemory {
    interface View extends BaseView {

    }

    interface Presenter {
        void addMemory(Memory memory);
    }
}
