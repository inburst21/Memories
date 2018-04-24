package iskills.com.presentation.di.activity.navigator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;

import javax.inject.Inject;

import iskills.com.presentation.R;
import iskills.com.presentation.screens.updatememoryactivity.CallbackDeleteDialog;
import iskills.com.presentation.screens.adapters.AdapterMemoryViewPager;
import iskills.com.presentation.screens.memoryactivity.MainActivity;
import iskills.com.presentation.screens.memoryactivity.memorypreviewdialog.MemoryPreviewDialog;
import iskills.com.presentation.screens.updatememoryactivity.UpdateMemoryActivity;
import iskills.com.presentation.screens.updatememoryactivity.editMemoryFragment.EditMemoryFragment;

/** lennyhicks 4/4/18 */
public class Navigator implements PresenterNavigator {
  private final Activity activity;
  private final FragmentManager fragmentManager;

  @Inject
  Navigator(Activity activity, FragmentManager fragmentManager) {
    this.activity = activity;
    this.fragmentManager = fragmentManager;
  }

  @Override
  public void toMemoriesScreen() { ((MainActivity) activity).getContainer().setCurrentItem(AdapterMemoryViewPager.pageAllMemories); }

  @Override
  public void toMapScreen() { ((MainActivity) activity).getContainer().setCurrentItem(AdapterMemoryViewPager.pageMap); }

  @Override
  public void toUploadScreen() { ((MainActivity) activity).getContainer().setCurrentItem(AdapterMemoryViewPager.pageAddMemory); }

  @Override
  public void toEditMemoryScreen(byte[] imageBytes) {
    Intent intent = new Intent(activity, UpdateMemoryActivity.class);
    intent.putExtra(EditMemoryFragment.MEMORY_BYTES, imageBytes);
    activity.startActivity(intent); }

  @Override
  public void toEditMemoryScreen(Long id) {
    Intent intent = new Intent(activity, UpdateMemoryActivity.class);
    intent.putExtra(EditMemoryFragment.MEMORY_ID, id);
    activity.startActivity(intent); }

  @Override
  public void openPreviewDialog(Long id) {
    Bundle bundle = new Bundle();
    bundle.putLong(EditMemoryFragment.MEMORY_ID, id);
    MemoryPreviewDialog dialog = new MemoryPreviewDialog();
    dialog.setArguments(bundle);
    dialog.show(fragmentManager, "preview"); }

  @Override
  public void showDeleteConfirmation(CallbackDeleteDialog callbackDeleteDialog) {
    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
    builder.setTitle(R.string.delete);
    builder.setMessage(R.string.delete_memory_confirmation);
    builder.setPositiveButton(
        "Delete",
        (dialog, id) -> {
          callbackDeleteDialog.onDelete();
          dialog.dismiss();
        });
    builder.setNegativeButton(
        android.R.string.cancel,
        (dialog, id) -> {
          dialog.dismiss();
        });
    AlertDialog dialog = builder.create();
    dialog.show();
  }
}
