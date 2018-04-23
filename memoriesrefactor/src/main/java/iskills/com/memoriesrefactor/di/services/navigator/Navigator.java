package iskills.com.memoriesrefactor.di.services.navigator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;

import javax.inject.Inject;

import iskills.com.memoriesrefactor.screens.adapters.AdapterMemoryViewPager;
import iskills.com.memoriesrefactor.screens.memoryactivity.MainActivity;
import iskills.com.memoriesrefactor.screens.memoryactivity.memorypreviewdialog.MemoryPreviewDialog;
import iskills.com.memoriesrefactor.screens.updatememoryactivity.UpdateMemoryActivity;
import iskills.com.memoriesrefactor.screens.updatememoryactivity.editMemoryFragment.EditMemoryFragment;

/** lennyhicks 4/4/18 */
public class Navigator implements PresenterNavigator {
  private Context activity;
  private FragmentManager fragmentManager;

  @Inject
  Navigator(Activity activity, FragmentManager fragmentManager) {
    this.activity = activity;
    this.fragmentManager = fragmentManager;
  }

  @Override
  public void toMemoriesScreen() {
    ((MainActivity) activity).getContainer().setCurrentItem(AdapterMemoryViewPager.pageAllMemories);
  }

  @Override
  public void toMapScreen() {
    ((MainActivity) activity).getContainer().setCurrentItem(AdapterMemoryViewPager.pageMap);
  }

  @Override
  public void toUploadScreen() {
    ((MainActivity) activity).getContainer().setCurrentItem(AdapterMemoryViewPager.pageAddMemory);
  }

  @Override
  public void toEditMemoryScreen(boolean newPhoto, byte[] imageBytes, @Nullable Long imageId) {
    Intent intent = new Intent(activity, UpdateMemoryActivity.class);
    intent.putExtra(EditMemoryFragment.MEMORY_NEW, newPhoto);
    intent.putExtra(EditMemoryFragment.MEMORY_BYTES, imageBytes);
    intent.putExtra(EditMemoryFragment.MEMORY_ID, imageId);
    activity.startActivity(intent);
  }

  @Override
  public void toEditMemoryScreen(byte[] imageBytes) {
    Intent intent = new Intent(activity, UpdateMemoryActivity.class);
    intent.putExtra(EditMemoryFragment.MEMORY_NEW, true);
    intent.putExtra(EditMemoryFragment.MEMORY_BYTES, imageBytes);
    activity.startActivity(intent);
  }

  @Override
  public void toEditMemoryScreen(Long id) {
    Intent intent = new Intent(activity, UpdateMemoryActivity.class);
    intent.putExtra(EditMemoryFragment.MEMORY_ID, id);
    activity.startActivity(intent);
  }

  @Override
  public void openPreviewDialog(Long id) {
    Bundle bundle = new Bundle();
    bundle.putLong(EditMemoryFragment.MEMORY_ID, id);
    MemoryPreviewDialog dialog = new MemoryPreviewDialog();
    dialog.setArguments(bundle);
    dialog.show(fragmentManager, "test");
  }

  @Override
  public void showDeleteConfirmation(CallbackDeleteDialog callbackDeleteDialog) {
    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
    builder.setTitle("Delete");
    builder.setMessage("Are you sure you want to delete this memory?");
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
