package iskills.com.memoriesrefactor.screens.memoryactivity.memorygrid;

import java.util.List;

import iskills.com.domain.model.Memory;
import iskills.com.memoriesrefactor.screens.common.BaseView;

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
