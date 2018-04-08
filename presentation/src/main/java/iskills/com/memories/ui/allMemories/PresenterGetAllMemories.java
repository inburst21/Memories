package iskills.com.memories.ui.allMemories;

import javax.inject.Inject;

import io.reactivex.Scheduler;
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
        addDisposable(useCaseGetAllMemories.getAllMemories()
                .subscribeOn(main)
                .observeOn(ui)
                .subscribe(list -> view.updateList(list),
                        throwable -> view.showError(throwable.getLocalizedMessage())));

    }
}


