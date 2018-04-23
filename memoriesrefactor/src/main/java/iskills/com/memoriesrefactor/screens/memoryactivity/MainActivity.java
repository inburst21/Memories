package iskills.com.memoriesrefactor.screens.memoryactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import iskills.com.memoriesrefactor.R;
import iskills.com.memoriesrefactor.di.activity.utils.activityresult.ActivityResultListener;
import iskills.com.memoriesrefactor.screens.adapters.AdapterMemoryViewPager;
import iskills.com.memoriesrefactor.screens.common.activities.BaseActivity;

public class MainActivity extends BaseActivity {

  @BindView(R.id.container)
  ViewPager container;

  @Inject public AdapterMemoryViewPager viewPager;

  @Inject ActivityResultListener listener;

  public ViewPager getContainer() {
    return container;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    unbinder = ButterKnife.bind(this);
    checkPermissions();
    container.setAdapter(viewPager);
    container.setOffscreenPageLimit(3);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if(resultCode != Activity.RESULT_CANCELED)
    listener.onActivityResult(requestCode, resultCode, data.getData() != null ? data.getData().toString() : null);
  }
}
