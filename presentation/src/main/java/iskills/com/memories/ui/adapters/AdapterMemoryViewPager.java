package iskills.com.memories.ui.adapters;

import android.app.Fragment;
import android.app.FragmentManager;

import javax.inject.Inject;

import iskills.com.memories.ui.addMemory.ViewAddMemory;
import iskills.com.memories.ui.allMemories.ViewGetAllMemories;
import iskills.com.memories.ui.editMemory.ViewEditMemory;
import iskills.com.memories.ui.map.ViewMap;

/**
 * lennyhicks
 * 3/30/18
 */
public class AdapterMemoryViewPager extends android.support.v13.app.FragmentStatePagerAdapter {

    private int count = 5;

    ViewAddMemory viewAddMemory = new ViewAddMemory();
    public ViewEditMemory viewEditMemory = new ViewEditMemory();
    ViewGetAllMemories viewGetAllMemories = new ViewGetAllMemories();
    ViewMap viewMap = new ViewMap();

    @Inject
    AdapterMemoryViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return viewAddMemory;
            case 1:
                return viewMap;
            case 2:
                return viewEditMemory;
            case 3:
                return viewGetAllMemories;

            default:
                return new Fragment();
        }
    }

    @Override
    public int getCount() {
        return count;
    }
}
