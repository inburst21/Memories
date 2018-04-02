package iskills.com.memories.ui.allMemories;

import java.util.List;

import iskills.com.domain.model.Memory;
import iskills.com.memories.mvp.BaseView;

/**
 * lennyhicks
 * 4/1/18
 */
public interface ContractGetAllMemories {
    interface View extends BaseView {
        void showMemories(List<Memory> memories);
    }

    interface Presenter {
        void getAllMemories();
    }
}
