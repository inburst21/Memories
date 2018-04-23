package iskills.com.presentation.screens.memoryactivity.bottomnavigation;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * lennyhicks
 * 4/14/18
 */

@Module
public abstract class BottomNavigationModule {

    @ContributesAndroidInjector
    abstract BottomNavigationFragment bottomNavigationView();

    @Binds
    abstract BottomNavView getView(BottomNavigationFragment bottomNavigationView);

    @Binds
    abstract BottomNavigationPresenter getPresenter(BottomNavigationPresenterImpl navigationViewPresenter);
}
