package iskills.com.memoriesrefactor.screens.memoryactivity.bottomnavigation;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * lennyhicks
 * 4/14/18
 */

@Module
public abstract class BottomNavigationViewModule {

    @ContributesAndroidInjector
    abstract BottomNavigationViewImpl bottomNavigationView();

    @Binds
    abstract BottomNavigationViewContract.View getView(BottomNavigationViewImpl presesenterViewBottomNavigation);

    @Binds
    abstract BottomNavigationViewContract.Listener getPresenter(BottomNavigationViewPresenter navigationViewPresenter);
}
