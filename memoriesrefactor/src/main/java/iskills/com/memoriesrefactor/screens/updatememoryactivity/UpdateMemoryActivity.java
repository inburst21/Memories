package iskills.com.memoriesrefactor.screens.updatememoryactivity;

import android.os.Bundle;

import dagger.Module;
import dagger.android.support.DaggerAppCompatActivity;
import iskills.com.memoriesrefactor.R;
import iskills.com.memoriesrefactor.screens.updatememoryactivity.editMemoryFragment.EditMemoryFragment;

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


        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container,
                        EditMemoryFragment.newInstance(
                                getIntent().getByteArrayExtra(EditMemoryFragment.MEMORY_BYTES),
                                getIntent().getLongExtra(EditMemoryFragment.MEMORY_ID, 0L),
                                getIntent().getBooleanExtra(EditMemoryFragment.MEMORY_NEW, false)))
                .commit();
    }
}
