package com.gantt.ganttcenter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by dzqbdf on 7/16/15.
 */
public class HBGCSquareImageView extends ImageView
{
    public HBGCSquareImageView(Context context) {
        super(context);
    }

    public HBGCSquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HBGCSquareImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth()); //Snap to width
    }
}
