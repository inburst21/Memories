package iskills.com.presentation.screens.updatememoryactivity.editMemoryFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import iskills.com.presentation.R;
import iskills.com.presentation.di.activity.utils.android.PresenterAndroid;
import iskills.com.presentation.screens.common.fragments.BaseFragment;

/** lennyhicks 4/5/18 */
public class EditMemoryFragment extends BaseFragment implements EditMemoryView {

  @Inject public EditMemoryPresenter presenter;

  @Inject public PresenterAndroid utilsAndroid;

  @BindView(R.id.image_view)
  ImageView imageView;

  @BindView(R.id.input_memory_title)
  TextInputEditText inputMemoryTitle;

  @BindView(R.id.input_memory_comment)
  TextInputEditText inputMemoryComment;

  @BindView(R.id.input_memory_location)
  TextInputEditText inputMemoryLocation;

  @BindView(R.id.input_memory_date)
  TextInputEditText inputMemoryDate;

  @BindView(R.id.button_delete_memory)
  ImageButton deleteButton;

  public static String MEMORY_BYTES = "memory_bytes";
  public static String MEMORY_ID = "memory_id";

  @Nullable
  @Override
  public View onCreateView(
      LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_edit_memory, container, false);
  }

  public static EditMemoryFragment newInstance(byte[] byteArrayExtra, long longExtra) {
    Bundle bundle = new Bundle();
    bundle.putByteArray(MEMORY_BYTES, byteArrayExtra);
    bundle.putLong(MEMORY_ID, longExtra);

    EditMemoryFragment viewEditMemory = new EditMemoryFragment();
    viewEditMemory.setArguments(bundle);
    return viewEditMemory;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    unbinder = ButterKnife.bind(this, view);
  }

  @OnTextChanged(R.id.input_memory_title)
  public void onTitleChanged(CharSequence charSequence) {
    presenter.onTitleChanged(charSequence);
  }

  @OnTextChanged(R.id.input_memory_comment)
  public void onCommentChanged(CharSequence charSequence) {
    presenter.onCommentChanged(charSequence);
  }

  @OnTextChanged(R.id.input_memory_location)
  public void onLocationChanged(CharSequence charSequence) {
    presenter.onLocationChanged(charSequence);
  }

  @OnClick(R.id.button_delete_memory)
  public void onDeleteTapped() {
    presenter.onDeleteTapped();
  }

  @OnClick(R.id.button_save_memory)
  public void onSaveMemory() {
    presenter.saveMemory();
  }

  @OnClick(R.id.input_memory_date)
  public void onDateTapped() {
    presenter.onDateTapped();
  }

  @Override
  public void setDate(String date) {
    inputMemoryDate.setText(date);
  }

  @Override
  public void setAddress(String address) {
    requireActivity().runOnUiThread(() -> inputMemoryLocation.setText(address));
  }

  @Override
  public void loadImage(byte[] imageBytes) {
    imageView.setImageBitmap(utilsAndroid.getBitmapFromByteArray(imageBytes));
  }

  @Override
  public void setTitle(String title) {
    inputMemoryTitle.setText(title);
  }

  @Override
  public void setComment(String comment) {
    inputMemoryComment.setText(comment);
  }

  @Override
  public void dismiss() {
    requireActivity().finish();
  }

  @Override
  public void showDeleteOption() {
    deleteButton.setVisibility(View.VISIBLE);
  }

  @Override
  public void onResume() {
    super.onResume();

    if (getArguments() != null) {
      byte[] memoryBytes = getArguments().getByteArray(MEMORY_BYTES);
      Long memoryID = getArguments().getLong(MEMORY_ID);
      presenter.updateValues(memoryBytes, memoryID);
    }
  }
}
