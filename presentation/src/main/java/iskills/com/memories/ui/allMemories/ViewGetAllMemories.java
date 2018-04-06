package iskills.com.memories.ui.allMemories;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import iskills.com.memories.R;
import iskills.com.memories.di.qualifiers.QualAdapterMemoryGrid;
import iskills.com.memories.mvp.ViewBase;
import iskills.com.memories.ui.adapters.AdapterMemoryGrid;

/**
 * lennyhicks
 * 4/1/18
 */
public class ViewGetAllMemories extends ViewBase implements ContractGetAllMemories.View {

    @Inject ContractGetAllMemories.Presenter presenterGetAllMemories;
    @Inject @QualAdapterMemoryGrid AdapterMemoryGrid adapterMemoryGrid;

    @BindView(R.id.recycler_view)
    public RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_memory_grid, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(adapterMemoryGrid);
        presenterGetAllMemories.getAllMemories();
    }

    @Override
    public void updateList() {
        adapterMemoryGrid.notifyDataSetChanged();
    }
}
