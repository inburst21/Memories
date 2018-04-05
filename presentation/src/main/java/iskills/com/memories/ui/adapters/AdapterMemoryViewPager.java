package iskills.com.memories.ui.adapters;

import android.app.Fragment;
import android.app.FragmentManager;

import iskills.com.memories.ui.addMemory.ViewAddMemory;
import iskills.com.memories.ui.allMemories.ViewGetAllMemories;

/**
 * lennyhicks
 * 3/30/18
 */
public class AdapterMemoryViewPager extends android.support.v13.app.FragmentStatePagerAdapter {

    private int count = 3;

    public AdapterMemoryViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 1 : return new ViewAddMemory();
            case 2 : return new ViewGetAllMemories();
            default: return new ViewGetAllMemories();
        }
    }

    @Override
    public int getCount() {
        return count;
    }
}
