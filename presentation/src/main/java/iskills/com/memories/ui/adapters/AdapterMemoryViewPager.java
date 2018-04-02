package iskills.com.memories.ui.adapters;

import android.app.Fragment;
import android.app.FragmentManager;

import iskills.com.memories.ui.addMemory.ViewAddMemory;

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

        return new ViewAddMemory();
    }

    @Override
    public int getCount() {
        return count;
    }
}
