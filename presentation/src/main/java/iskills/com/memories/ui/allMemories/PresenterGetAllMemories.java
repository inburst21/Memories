package iskills.com.memories.ui.allMemories;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.subscribers.ResourceSubscriber;
import iskills.com.data.DatabaseImage;
import iskills.com.domain.model.Memory;
import iskills.com.domain.usecases.UseCaseGetAllMemories;
import iskills.com.memories.di.qualifiers.MainThread;
import iskills.com.memories.di.qualifiers.UiThread;
import iskills.com.memories.mvp.BasePresenter;

/**
 * lennyhicks
 * 4/1/18
 */
public class PresenterGetAllMemories extends BasePresenter<ContractGetAllMemories.View> implements ContractGetAllMemories.Presenter {
    private UseCaseGetAllMemories useCaseGetAllMemories;
    private Scheduler main;
    private Scheduler ui;


    @Inject
    PresenterGetAllMemories(ContractGetAllMemories.View view, UseCaseGetAllMemories useCaseGetAllMemories, @MainThread Scheduler main, @UiThread Scheduler ui) {
        super(view);
        this.useCaseGetAllMemories = useCaseGetAllMemories;
        this.main = main;
        this.ui = ui;
    }


    @Override
    public void getAllMemories() {

        Memory memory = Memory.newBuilder()
                .withMemoryDate(System.currentTimeMillis())
                .withImageBytes(new byte[]{0, 0, 1, 1, 2, 4}).build();

        ArrayList<Memory> memories = new ArrayList<>();

        memories.add(memory);

        view.updateList(memories);
//        addDisposable(useCaseGetAllMemories.getAllMemories()
        ConnectableFlowable<List<Memory>> memoryFlowable = useCaseGetAllMemories.getAllMemories();

        memoryFlowable
                .subscribeOn(main)
                .observeOn(ui)
                .subscribe(new ResourceSubscriber<List<Memory>>() {

                    @Override
                    public void onNext(List<Memory> value) {
                        view.updateList(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                        view.showError("eehehehehehhe");
                    }
                });

        addDisposable(memoryFlowable.connect());

//        useCaseGetAllMemories.getAllMemories()
//                .subscribeOn(main)
//                .observeOn(ui)
//                .subscribe(memories -> view.updateList(memories));
    }
}


