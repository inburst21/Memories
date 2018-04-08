package iskills.com.memories.ui.adapters;

import android.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import iskills.com.memories.MainActivity;
import iskills.com.memories.di.scopes.ScopeAndroid;

/**
 * lennyhicks
 * 4/6/18
 */

@Module
public class ModuleViewPager {

    @Provides
    @ScopeAndroid
    FragmentManager fragmentManager(MainActivity activity){
        return activity.getFragmentManager();
    }

    @Provides
    @ScopeAndroid
    AdapterMemoryViewPager getAdapter(FragmentManager fragmentManager){
        return new AdapterMemoryViewPager(fragmentManager);
    }

}
