package iskills.com.presentation.screens.memoryactivity.memorymap;

import iskills.com.presentation.screens.common.BaseView;

/**
 * lennyhicks
 * 4/20/18
 */
interface MemoryMapView extends BaseView {
    void addMemory(Long id, String title, String comment, double lat, double lng);
}
