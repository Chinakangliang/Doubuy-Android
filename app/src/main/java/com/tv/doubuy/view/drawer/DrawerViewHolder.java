package com.tv.doubuy.view.drawer;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tv.doubuy.R;

/**
 * Created by apple on 2017/6/19.
 */

public class DrawerViewHolder extends RecyclerView.ViewHolder {

    public TextView content;
    public TextView delete;
    public LinearLayout layout;
    public TextView tvSize;


    public DrawerViewHolder(View itemView) {
        super(itemView);
        content = (TextView) itemView.findViewById(R.id.item_content);
        delete = (TextView) itemView.findViewById(R.id.item_delete);
        layout = (LinearLayout) itemView.findViewById(R.id.item_layout);

        tvSize = (TextView) itemView.findViewById(R.id.tv_item_size);

    }
}
