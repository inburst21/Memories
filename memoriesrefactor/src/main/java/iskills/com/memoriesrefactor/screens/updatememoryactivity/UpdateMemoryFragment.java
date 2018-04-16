package iskills.com.memoriesrefactor.screens.updatememoryactivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import iskills.com.memoriesrefactor.screens.updatememoryactivity.editMemoryFragment.EditMemoryModule;
import iskills.com.memoriesrefactor.screens.updatememoryactivity.editMemoryFragment.ViewEditMemory;

/**
 * lennyhicks
 * 4/10/18
 */
@Module
public abstract class UpdateMemoryFragment {

    @ContributesAndroidInjector(modules = EditMemoryModule.class)
    abstract ViewEditMemory activityEditMemory();
}
