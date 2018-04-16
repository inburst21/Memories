package iskills.com.memoriesrefactor.screens.memoryactivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;
import iskills.com.memoriesrefactor.R;
import iskills.com.memoriesrefactor.di.activity.utils.activityresult.ActivityResultListener;
import iskills.com.memoriesrefactor.screens.adapters.AdapterMemoryViewPager;

public class MainActivity extends DaggerAppCompatActivity {

    @BindView(R.id.container)
    ViewPager container;


    @Inject
    public AdapterMemoryViewPager viewPager;

    @Inject ActivityResultListener listener;

    public ViewPager getContainer() {
        return container;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        checkPermissions();
        container.setAdapter(viewPager);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        listener.onActivityResult(requestCode, resultCode, data.getData() != null ? data.getData().toString() : null);
    }

}
