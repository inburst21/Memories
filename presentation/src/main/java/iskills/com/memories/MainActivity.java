package iskills.com.memories;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v13.app.ActivityCompat;
import android.support.v4.view.ViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import iskills.com.memories.ui.adapters.AdapterMemoryViewPager;

public class MainActivity extends Activity {

    @BindView(R.id.view_pager)
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);
        pager.setAdapter(new AdapterMemoryViewPager(getFragmentManager()));
        checkPermissions();
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

}
