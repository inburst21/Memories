package iskills.com.memoriesrefactor.screens.updatememoryactivity;

import android.os.Bundle;

import dagger.Module;
import dagger.android.support.DaggerAppCompatActivity;
import iskills.com.memoriesrefactor.R;

/**
 * lennyhicks
 * 4/15/18
 */
@Module
public class UpdateMemoryActivity extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_memory);
    }
}
