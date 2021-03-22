package com.snail.wechatmoments.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.snail.common.widget.NineGridLayout;
import com.snail.common.widget.RatioImageView;
import com.snail.wechatmoments.R;

import java.util.List;

/**
 * 朋友圈九宫格图片展示
 */
public class MomentNineGridLayout extends NineGridLayout {
    private Context context;

    public MomentNineGridLayout(Context context) {
        this(context, null);
    }

    public MomentNineGridLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void displayImage(int position, RatioImageView imageView, String url) {
        if (context != null) {
            Glide.with(context)
                    .load(url)
                    .placeholder(R.drawable.shape_rect_color_gray)
                    .error(R.drawable.shape_rect_color_gray)
                    .centerCrop()
                    .into(imageView);
        }
    }

    @Override
    protected void onClickImage(int position, String url, List<String> urlList, ImageView imageView) {

    }
}
