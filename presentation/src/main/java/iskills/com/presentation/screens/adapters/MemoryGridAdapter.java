package iskills.com.presentation.screens.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import javax.inject.Inject;

import iskills.com.presentation.R;
import iskills.com.presentation.screens.memoryactivity.memorygrid.MemoryGridAdapterPresenter;


/**
 * lennyhicks
 * 4/5/18
 */
public class MemoryGridAdapter extends RecyclerView.Adapter<MemoryHolderFragment> {

    private MemoryGridAdapterPresenter presenterMemoryGrid;

    @Inject
    public MemoryGridAdapter(MemoryGridAdapterPresenter presenterMemoryGrid) {
        this.presenterMemoryGrid = presenterMemoryGrid;
    }

    @Override
    public MemoryHolderFragment onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MemoryHolderFragment(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_memory, parent, false));

    }

    @Override
    public void onBindViewHolder(MemoryHolderFragment holder, int position) {
        presenterMemoryGrid.onBindViewHolderMemory(holder, position);
        holder.itemView.setOnClickListener(__ ->  presenterMemoryGrid.onMemoryTapped(position));
    }

    @Override
    public int getItemCount() {
        return presenterMemoryGrid.getMemoryCount();
    }

    public MemoryGridAdapterPresenter getPresenterMemoryGrid() {
        return presenterMemoryGrid;
    }
}
