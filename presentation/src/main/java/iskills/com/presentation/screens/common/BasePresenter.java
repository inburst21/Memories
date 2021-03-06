package iskills.com.presentation.screens.common;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * lennyhicks
 * 3/30/18
 */
public class BasePresenter<V extends BaseView> implements IPresenter {

    protected V view;
    private CompositeDisposable disposables = new CompositeDisposable();

    protected BasePresenter(V view){
        this.view = view;
    }

    protected void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

    @Override
    public void onStop() {
        this.view = null;
    }

    @Override
    public void onDestroy() {
        disposables.clear();
    }
}
