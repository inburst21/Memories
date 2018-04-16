package iskills.com.memoriesrefactor.screens.memoryactivity.memorygrid;

import javax.inject.Inject;

import iskills.com.domain.usecases.UseCaseGetAllMemories;
import iskills.com.memoriesrefactor.di.activity.utils.schedulers.PresenterScheduler;
import iskills.com.memoriesrefactor.screens.common.BasePresenter;

/**
 * lennyhicks
 * 4/1/18
 */
public class MemoryGridMainPresenter extends BasePresenter<ContractGetAllMemories.View> implements ContractGetAllMemories.Presenter {
    private UseCaseGetAllMemories useCaseGetAllMemories;
    private final PresenterScheduler schedulers;


    @Inject
    MemoryGridMainPresenter(ContractGetAllMemories.View view, UseCaseGetAllMemories useCaseGetAllMemories, PresenterScheduler schedulers) {
        super(view);
        this.useCaseGetAllMemories = useCaseGetAllMemories;
        this.schedulers = schedulers;
    }


    @Override
    public void getAllMemories() {
        addDisposable(useCaseGetAllMemories.getAllMemories()
                .subscribeOn(schedulers.mainThread())
                .observeOn(schedulers.uiThread())
                .subscribe(list -> view.updateList(list),
                        throwable -> view.showError(throwable.getLocalizedMessage())));

    }
}


