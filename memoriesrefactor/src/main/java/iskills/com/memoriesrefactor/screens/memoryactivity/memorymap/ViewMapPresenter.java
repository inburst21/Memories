package iskills.com.memoriesrefactor.screens.memoryactivity.memorymap;

import javax.inject.Inject;

import io.reactivex.Flowable;
import iskills.com.domain.model.Memory;
import iskills.com.domain.usecases.UseCaseGetAllMemories;
import iskills.com.memoriesrefactor.di.activity.utils.schedulers.PresenterScheduler;

/**
 * lennyhicks
 * 4/8/18
 */
public class ViewMapPresenter implements ContractMemoryMap.Presenter {

    private ContractMemoryMap.View view;
    private final UseCaseGetAllMemories useCaseGetAllMemories;
    private final PresenterScheduler schedulers;

    @Inject
    ViewMapPresenter(ContractMemoryMap.View view, UseCaseGetAllMemories useCaseGetAllMemories, PresenterScheduler schedulers) {
        this.view = view;
        this.useCaseGetAllMemories = useCaseGetAllMemories;
        this.schedulers = schedulers;

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
        view.showSuccess(memoryId + " selected");
    }
}
