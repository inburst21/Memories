package iskills.com.memories.ui.allMemories;

import javax.inject.Inject;

import iskills.com.domain.usecases.UseCaseGetAllMemories;
import iskills.com.memories.di.providers.schedulers.ISchedulers;
import iskills.com.memories.mvp.BasePresenter;

/**
 * lennyhicks
 * 4/1/18
 */
public class PresenterGetAllMemories extends BasePresenter<ContractGetAllMemories.View> implements ContractGetAllMemories.Presenter {
    private UseCaseGetAllMemories useCaseGetAllMemories;
    private final ISchedulers schedulers;


    @Inject
    PresenterGetAllMemories(ContractGetAllMemories.View view, UseCaseGetAllMemories useCaseGetAllMemories, ISchedulers schedulers) {
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


