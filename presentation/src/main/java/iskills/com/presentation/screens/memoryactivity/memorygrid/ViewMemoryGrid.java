package iskills.com.presentation.screens.memoryactivity.memorygrid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import iskills.com.domain.model.Memory;
import iskills.com.presentation.R;
import iskills.com.presentation.screens.adapters.MemoryGridAdapter;
import iskills.com.presentation.screens.common.fragments.BaseFragment;

/** lennyhicks 4/1/18 */
public class ViewMemoryGrid extends BaseFragment implements MemoryGridView {

  @Inject protected MemoryGridPresenter presenterGetAllMemories;

  @Inject protected MemoryGridAdapter memoryGridAdapter;

  @BindView(R.id.recycler_view)
  protected RecyclerView recyclerView;

  @Nullable
  @Override
  public View onCreateView(
      LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_memory_grid, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    unbinder = ButterKnife.bind(this, view);
    recyclerView.setAdapter(memoryGridAdapter);
    recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    presenterGetAllMemories.getAllMemories();
  }

  @Override
  public void updateList(List<Memory> memoryList) {
    memoryGridAdapter.getMemoryGridPresenter().updateList(memoryList);
    memoryGridAdapter.notifyDataSetChanged();
  }
}
