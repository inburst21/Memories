package iskills.com.presentation.screens.memoryactivity.memorypreviewdialog;

/**
 * lennyhicks
 * 4/20/18
 */
public interface MemoryPreviewView {
    void setDate(String date);
    void setAddress(String address);
    void loadImage(byte[] imageBytes);
    void setTitle(String title);
    void setComment(String comment);
    void dismiss();
}
