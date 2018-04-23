package iskills.com.memoriesrefactor.screens.updatememoryactivity.editMemoryFragment;

import iskills.com.memoriesrefactor.screens.common.BaseView;

/** lennyhicks 4/19/18 */
public interface EditMemoryView extends BaseView {

  void setDate(String date);

  void setAddress(String address);

  void loadImage(byte[] imageBytes);

  void setTitle(String title);

  void setComment(String comment);

  void showDeleteOption();

  void dismiss();
}
