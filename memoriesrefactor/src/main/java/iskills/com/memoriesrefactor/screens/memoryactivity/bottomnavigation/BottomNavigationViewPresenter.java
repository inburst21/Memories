package iskills.com.memoriesrefactor.screens.memoryactivity.bottomnavigation;

import javax.inject.Inject;

import iskills.com.memoriesrefactor.di.services.navigator.PresenterNavigator;

/**
 * lennyhicks
 * 4/14/18
 */
public class BottomNavigationViewPresenter implements BottomNavigationViewContract.Listener {

    private PresenterNavigator navigator;

    @Inject
    public BottomNavigationViewPresenter(PresenterNavigator navigator){
        this.navigator = navigator;
    }
    @Override
    public void onAddMemoryTapped() {
        navigator.toUploadScreen();
    }

    @Override
    public void onMemoryGridTapped() {
        navigator.toMemoriesScreen();

    }

    @Override
    public void onMemoryMapTapped() {
        navigator.toMapScreen();

    }
}
