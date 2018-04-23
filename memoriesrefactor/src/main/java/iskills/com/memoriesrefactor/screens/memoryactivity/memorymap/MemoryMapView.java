package iskills.com.memoriesrefactor.screens.memoryactivity.memorymap;

import iskills.com.memoriesrefactor.screens.common.BaseView;

/**
 * lennyhicks
 * 4/20/18
 */
interface MemoryMapView extends BaseView {
    void addMemory(Long id, String title, String comment, double lat, double lng);
}
