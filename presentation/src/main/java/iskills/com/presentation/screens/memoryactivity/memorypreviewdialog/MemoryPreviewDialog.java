package iskills.com.presentation.screens.memoryactivity.memorypreviewdialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import dagger.android.support.DaggerAppCompatDialogFragment;
import iskills.com.presentation.R;
import iskills.com.presentation.di.activity.utils.android.PresenterAndroid;
import iskills.com.presentation.screens.updatememoryactivity.editMemoryFragment.EditMemoryFragment;

/** lennyhicks 4/16/18 */
public class MemoryPreviewDialog extends DaggerAppCompatDialogFragment implements MemoryPreviewView {

  @BindView(R.id.image_view)
  ImageView imageView;

  @BindView(R.id.text_memory_title)
  TextView memoryTitle;

  @BindView(R.id.text_memory_comment)
  TextView memoryComment;

  @BindView(R.id.text_memory_location)
  TextView memoryLocation;

  @BindView(R.id.text_memory_date)
  TextView memoryDate;

  @Inject PresenterAndroid presenterAndroid;

  @Inject MemoryPreviewPresenter presenter;
  private Unbinder unbinder;

  @Nullable
  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_preview_memory, container);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    unbinder = ButterKnife.bind(this, view);
    if (getArguments() != null) {
      presenter.showImage(getArguments().getLong(EditMemoryFragment.MEMORY_ID));
    }
  }

  @Override
  public void setDate(String date) {
    memoryDate.setText(date);
  }

  @Override
  public void setAddress(String address) {
    memoryLocation.setText(address);
  }

  @Override
  public void loadImage(byte[] imageBytes) {
    imageView.setImageBitmap(presenterAndroid.getBitmapFromByteArray(imageBytes));
  }

  @Override
  public void setTitle(String title) {
    memoryTitle.setText(title);
  }

  @Override
  public void setComment(String comment) {
    memoryComment.setText(comment);
  }

  @OnClick(R.id.button_close_memory)
  public void onClickClose() {
    presenter.onClose();
    unbinder.unbind();
  }

  @OnClick(R.id.button_edit_memory)
  public void onClickEdit() {
    presenter.editMemory();
  }
}
