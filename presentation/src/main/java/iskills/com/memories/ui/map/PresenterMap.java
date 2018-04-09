package iskills.com.memories.ui.map;

import android.util.Log;

import javax.inject.Inject;

import iskills.com.domain.model.Memory;
import iskills.com.domain.usecases.UseCaseGetAllMemories;
import iskills.com.memories.di.providers.schedulers.ISchedulers;
import iskills.com.memories.mvp.BasePresenter;

/**
 * lennyhicks
 * 4/8/18
 */
public class PresenterMap extends BasePresenter<ContractMemoryMap.View> implements ContractMemoryMap.Presenter {

    private final UseCaseGetAllMemories useCaseGetAllMemories;
    private final ISchedulers schedulers;

    @Inject
    PresenterMap(ContractMemoryMap.View view, UseCaseGetAllMemories useCaseGetAllMemories, ISchedulers schedulers){
        super(view);
        this.useCaseGetAllMemories = useCaseGetAllMemories;
        this.schedulers = schedulers;

    }

    @Override
    public void loadMemories(){
        addDisposable(useCaseGetAllMemories.getAllMemories()
                .subscribeOn(schedulers.mainThread())
                .observeOn(schedulers.uiThread())
                .subscribe(list -> {
                    for (Memory memory : list){
                        addMemory(memory);
                    }
                },
                        throwable -> view.showError(throwable.getLocalizedMessage())));    }

    private void addMemory(Memory memory) {
        if(memory.lng != null && memory.lat != null) {
            view.addMemory(memory.id, memory.title, memory.comment, memory.lat, memory.lng, memory.imageBytes);
        } else {
            Log.d(memory.title, " missing lat or lng " + memory.lat + " - " + memory.lng);
        }
    }

    @Override
    public void onMemorySelected(long memoryId) {

    }
}
