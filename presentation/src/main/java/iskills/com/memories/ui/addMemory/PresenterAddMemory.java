package iskills.com.memories.ui.addMemory;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import iskills.com.domain.model.Memory;
import iskills.com.domain.usecases.UseCaseAddMemory;
import iskills.com.memories.mvp.BasePresenter;

/**
 * lennyhicks
 * 3/30/18
 */
public class PresenterAddMemory extends BasePresenter<ContractAddMemory.View> implements ContractAddMemory.Presenter {
    private UseCaseAddMemory useCaseAddMemory;
    private Scheduler main;
    private Scheduler ui;
    public Memory memory = new Memory();

    @Inject
    PresenterAddMemory(ContractAddMemory.View view, UseCaseAddMemory useCaseAddMemory, Scheduler main, Scheduler ui) {
        super(view);
        this.useCaseAddMemory = useCaseAddMemory;
        this.main = main;
        this.ui = ui;
    }

    @Override
    public void addMemory(Memory memory) {
        addDisposable(useCaseAddMemory.add(memory)
                .subscribeOn(main)
                .observeOn(ui)
                .subscribe(() -> view.showSuccess("Memory Added Successfully"),
                        throwable -> view.showError(throwable.getLocalizedMessage()))
        );
    }
}
