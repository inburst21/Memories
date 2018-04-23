package iskills.com.memoriesrefactor.screens.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import javax.inject.Inject;

import iskills.com.memoriesrefactor.screens.memoryactivity.addmemory.AddMemoryFragment;
import iskills.com.memoriesrefactor.screens.memoryactivity.memorygrid.ViewMemoryGrid;
import iskills.com.memoriesrefactor.screens.memoryactivity.memorymap.MemoryMapFragment;

/** lennyhicks 3/30/18 */
public class AdapterMemoryViewPager extends FragmentStatePagerAdapter {

  private final AddMemoryFragment addMemoryView = new AddMemoryFragment();
  public static final int pageAddMemory = 0;

  private final ViewMemoryGrid viewGetAllMemories = new ViewMemoryGrid();
  public static final int pageAllMemories = 1;

  private final MemoryMapFragment viewMap = new MemoryMapFragment();
  public static final int pageMap = 2;

  @Inject
  public AdapterMemoryViewPager(FragmentManager fm) {
    super(fm);
  }

  @Override
  public Fragment getItem(int position) {

    switch (position) {
      case pageAddMemory:
        return addMemoryView;
      case pageAllMemories:
        return viewGetAllMemories;
      case pageMap:
        return viewMap;

      default:
        return new Fragment();
    }
  }

  @Override
  public int getCount() {
    int count = 3;
    return count;
  }
}
