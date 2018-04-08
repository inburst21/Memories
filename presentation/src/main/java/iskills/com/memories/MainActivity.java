package iskills.com.memories;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v13.app.ActivityCompat;
import android.support.v4.view.ViewPager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.DaggerActivity;
import iskills.com.memories.di.providers.activityResultListener.UtilsActivityResultListener;
import iskills.com.memories.ui.adapters.AdapterMemoryViewPager;

public class MainActivity extends DaggerActivity {

    @Inject
    AdapterMemoryViewPager adapterMemoryViewPager;

    @BindView(R.id.view_pager)
    ViewPager pager;

    @Inject
    UtilsActivityResultListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        checkPermissions();
        pager.setAdapter(adapterMemoryViewPager);
        pager.setOffscreenPageLimit(1);

    }

    private void checkPermissions() {
        ActivityCompat.requestPermissions(this, getRequestedPermissions(this), 1);
    }

    private String[] getRequestedPermissions(Context context) {
        try {
            return context
                    .getPackageManager()
                    .getPackageInfo(context.getPackageName(), PackageManager.GET_PERMISSIONS)
                    .requestedPermissions;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("This should have never happened.", e); // I'd return null and Log.wtf(...) in production
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        listener.onActivityResult(requestCode, resultCode, (data != null) ? (data.getData().toString()) : null);
    }

    public void toEditMemoryScreen(boolean newPhoto, byte[] imageBytes, @Nullable  Long imageId) {
        pager.setCurrentItem(2);
        try {
            Thread.sleep(500);

            adapterMemoryViewPager.viewEditMemory.updateValues(newPhoto, imageBytes, imageId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
