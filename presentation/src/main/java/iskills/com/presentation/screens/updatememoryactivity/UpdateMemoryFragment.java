package iskills.com.presentation.screens.updatememoryactivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import iskills.com.presentation.screens.updatememoryactivity.editMemoryFragment.EditMemoryModule;
import iskills.com.presentation.screens.updatememoryactivity.editMemoryFragment.EditMemoryFragment;

/**
 * lennyhicks
 * 4/10/18
 */
@Module
public abstract class UpdateMemoryFragment {

    @ContributesAndroidInjector(modules = EditMemoryModule.class)
    abstract EditMemoryFragment activityEditMemory();

}
