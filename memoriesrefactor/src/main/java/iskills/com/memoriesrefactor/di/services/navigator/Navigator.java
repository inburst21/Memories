package iskills.com.memoriesrefactor.di.services.navigator;

import android.content.Context;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import iskills.com.memoriesrefactor.screens.adapters.AdapterMemoryViewPager;
import iskills.com.memoriesrefactor.screens.memoryactivity.MainActivity;

/**
 * lennyhicks
 * 4/4/18
 */
public class Navigator implements PresenterNavigator {
    private Context mainActivity;

    @Inject
    Navigator(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void toMemoriesScreen() {
        ((MainActivity)mainActivity).getContainer().setCurrentItem(AdapterMemoryViewPager.pageAllMemories);
    }

    @Override
    public void toMapScreen() {
        ((MainActivity)mainActivity).getContainer().setCurrentItem(AdapterMemoryViewPager.pageMap);
    }

    @Override
    public void toUploadScreen() {
        ((MainActivity)mainActivity).getContainer().setCurrentItem(AdapterMemoryViewPager.pageAddMemory);
    }

    @Override
    public void toEditMemoryScreen(boolean newPhoto, byte[] imageBytes, @Nullable Long imageId) {
//        Intent intent = new Intent(mainActivity, ActivityEditMemory.class);
//        intent.putExtra(ViewEditMemory.MEMORY_NEW, newPhoto);
//        intent.putExtra(ViewEditMemory.MEMORY_BYTES, imageBytes);
//        intent.putExtra(ViewEditMemory.MEMORY_ID, imageId);
//        mainActivity.startActivity(intent);
    }

    @Override
    public void toEditMemoryScreen(byte[] imageBytes) {
//        Intent intent = new Intent(mainActivity, ActivityEditMemory.class);
//        intent.putExtra(ViewEditMemory.MEMORY_NEW, true);
//        intent.putExtra(ViewEditMemory.MEMORY_BYTES, imageBytes);
//        mainActivity.startActivity(intent);
    }
}
