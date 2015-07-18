package com.gantt.ganttcenter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by dzqbdf on 7/17/15.
 */
public class ImagePagerAdapter extends PagerAdapter
{
    private Context mContext;
    private ArrayList<HBGCEventObject> mHeaders;


    public ImagePagerAdapter(Context context, ArrayList<HBGCEventObject> headers)
    {
        this.mContext = context;
        this.mHeaders = headers;
    }
        @Override
        // Count the element on my array
        public int getCount() {
            return this.mHeaders.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((ImageView) object);
        }


        /**
         * Target: Displaying the data according to the position
         *
         *
         * @param container, position
         * @return imageView,  The view displaying in the page
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Context context = this.mContext;

            ImageView imageView = new ImageView(context);

            // Display the current image

            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

            HBGCEventObject currentHeader = this.mHeaders.get(position);

            imageView.setImageDrawable(currentHeader.getThumbnail());

            ((ViewPager) container).addView(imageView,0);
            return imageView;
        }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView) object);
    }
}
