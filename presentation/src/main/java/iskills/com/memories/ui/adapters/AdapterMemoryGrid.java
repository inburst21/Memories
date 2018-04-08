package iskills.com.memories.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import iskills.com.memories.R;
import iskills.com.memories.ui.allMemories.PresenterMemoryGrid;

/**
 * lennyhicks
 * 4/5/18
 */
public class AdapterMemoryGrid extends RecyclerView.Adapter<ViewHolderMemory> {

    public PresenterMemoryGrid presenterMemoryGrid;

    public AdapterMemoryGrid(PresenterMemoryGrid presenterMemoryGrid) {
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

    public PresenterMemoryGrid getPresenterMemoryGrid() {
        return presenterMemoryGrid;
    }
}
