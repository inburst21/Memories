package iskills.com.presentation.screens.adapters;

import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import iskills.com.presentation.R;

/**
 * lennyhicks$
 * 4/5/18
 */
public class MemoryHolderFragment extends RecyclerView.ViewHolder implements MemoryViewHolder {

    @BindView(R.id.item_image)
    ImageView memoryImageView;

    @BindView(R.id.item_date)
    TextView memoryDate;

    MemoryHolderFragment(View itemView) {
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
