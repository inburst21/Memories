package iskills.com.memoriesrefactor.screens.memoryactivity.memorymap;

import javax.inject.Inject;

import io.reactivex.Flowable;
import iskills.com.domain.model.Memory;
import iskills.com.domain.usecases.UseCaseGetAllMemories;
import iskills.com.memoriesrefactor.di.activity.utils.schedulers.PresenterScheduler;
import iskills.com.memoriesrefactor.di.services.navigator.PresenterNavigator;

/**
 * lennyhicks
 * 4/8/18
 */
public class ViewMapPresenter implements ContractMemoryMap.Presenter {

    private ContractMemoryMap.View view;
    private final UseCaseGetAllMemories useCaseGetAllMemories;
    private final PresenterScheduler schedulers;
    private PresenterNavigator presenterNavigator;

    @Inject
    ViewMapPresenter(ContractMemoryMap.View view,
                     UseCaseGetAllMemories useCaseGetAllMemories,
                     PresenterScheduler schedulers,
                     PresenterNavigator presenterNavigator) {
        this.view = view;
        this.useCaseGetAllMemories = useCaseGetAllMemories;
        this.schedulers = schedulers;
        this.presenterNavigator = presenterNavigator;
    }

    @Override
    public void loadMemories() {
        useCaseGetAllMemories.getAllMemories()
                .subscribeOn(schedulers.mainThread())
                .flatMap(list -> {
                    for (Memory memory : list) {
                        addMemory(memory);
                    }
                    return Flowable.just(list);
                })
                .subscribe();
    }

    private void addMemory(Memory memory) {
        if (memory.lng != null && memory.lat != null) {
            view.addMemory(memory.id, memory.title, memory.comment, memory.lat, memory.lng);
        } else {
            view.showError("Memory was missing required components");
        }
    }

    @Override
    public void onMemorySelected(long memoryId) {
        presenterNavigator.openPreviewDialog(memoryId);
    }
}
