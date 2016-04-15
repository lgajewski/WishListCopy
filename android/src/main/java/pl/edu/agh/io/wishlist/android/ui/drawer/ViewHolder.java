package pl.edu.agh.io.wishlist.android.ui.drawer;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import pl.edu.agh.io.wishlist.android.R;

@SuppressWarnings("WeakerAccess")
public class ViewHolder {

    @Bind(R.id.icon)
    ImageView icon;

    @Bind(R.id.title)
    TextView title;

    ViewHolder(View view) {
        ButterKnife.bind(this, view);
    }

    public void setTitle(CharSequence title) {
        this.title.setText(title);
    }

    public void setIcon(Drawable drawable) {
        this.icon.setImageDrawable(drawable);
    }

}

