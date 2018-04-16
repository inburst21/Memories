package iskills.com.memoriesrefactor.screens.memoryactivity.bottomnavigation;

import iskills.com.memoriesrefactor.screens.common.BaseView;

/**
 * lennyhicks
 * 4/14/18
 */
public interface BottomNavigationViewContract extends BaseView {
    interface Listener {
        void onAddMemoryTapped();
        void onMemoryGridTapped();
        void onMemoryMapTapped();
    }

    interface View {
        // No methods
    }
}
