package iskills.com.memoriesrefactor.screens.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import javax.inject.Inject;

import iskills.com.memoriesrefactor.R;
import iskills.com.memoriesrefactor.screens.memoryactivity.memorygrid.MemoryGridSubPresenter;


/**
 * lennyhicks
 * 4/5/18
 */
public class AdapterMemoryGrid extends RecyclerView.Adapter<ViewHolderMemory> {

    private MemoryGridSubPresenter presenterMemoryGrid;

    @Inject
    public AdapterMemoryGrid(MemoryGridSubPresenter presenterMemoryGrid) {
        this.presenterMemoryGrid = presenterMemoryGrid;
    }

    @Override
    public ViewHolderMemory onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolderMemory(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_memory, parent, false));

    }

    @Override
    public void onBindViewHolder(ViewHolderMemory holder, int position) {
        presenterMemoryGrid.onBindViewHolderMemory(holder, position);
    }

    @Override
    public int getItemCount() {
        return presenterMemoryGrid.getMemoryCount();
    }

    public MemoryGridSubPresenter getPresenterMemoryGrid() {
        return presenterMemoryGrid;
    }
}
