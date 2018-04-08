package iskills.com.memories.ui.adapters;

import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import iskills.com.memories.R;

/**
 * lennyhicks
 * 4/5/18
 */
public class ViewHolderMemory extends RecyclerView.ViewHolder implements ViewMemoryHolder {

    @BindView(R.id.item_image)
    ImageView memoryImageView;

    @BindView(R.id.item_date)
    TextView memoryDate;

    ViewHolderMemory(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setMemoryDate(String date) {
        memoryDate.setText(date);
    }

    @Override
    public void setMemoryImage(byte[] memoryImage) {
        memoryImageView.setImageBitmap(BitmapFactory.decodeByteArray(memoryImage, 0 , memoryImage.length));
    }
}
