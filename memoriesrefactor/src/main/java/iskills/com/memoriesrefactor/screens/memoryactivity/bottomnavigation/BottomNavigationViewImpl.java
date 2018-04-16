package iskills.com.memoriesrefactor.screens.memoryactivity.bottomnavigation;

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
import iskills.com.memoriesrefactor.R;
import iskills.com.memoriesrefactor.screens.common.fragments.BaseFragment;

/**
 * lennyhicks
 * 4/14/18
 */
public class BottomNavigationViewImpl extends BaseFragment implements BottomNavigationView.OnNavigationItemSelectedListener, BottomNavigationViewContract.View {

    @Inject
    BottomNavigationViewContract.Listener listener;

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
                listener.onMemoryGridTapped();
                return false;
            case R.id.action_map:
                listener.onMemoryMapTapped();
                return false;
            case R.id.action_upload:
                listener.onAddMemoryTapped();
                return false;
        }
        return false;
    }
}
