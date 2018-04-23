package iskills.com.presentation.screens.memoryactivity.bottomnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import iskills.com.presentation.R;
import iskills.com.presentation.screens.common.fragments.BaseFragment;

/**
 * lennyhicks
 * 4/14/18
 */
public class BottomNavigationFragment extends BaseFragment implements BottomNavigationView.OnNavigationItemSelectedListener, BottomNavView {

    @Inject
    BottomNavigationPresenter presenter;

    @BindView(R.id.view_bottom_navigation)
    public BottomNavigationView bottomNavigationView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_bottom_navigation, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_memories:
                presenter.onMemoryGridTapped();
                return false;
            case R.id.action_map:
                presenter.onMemoryMapTapped();
                return false;
            case R.id.action_upload:
                presenter.onAddMemoryTapped();
                return false;
        }
        return false;
    }

}
