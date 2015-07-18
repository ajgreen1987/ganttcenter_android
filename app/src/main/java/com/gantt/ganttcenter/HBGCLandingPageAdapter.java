package com.gantt.ganttcenter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dzqbdf on 7/16/15.
 */
public class HBGCLandingPageAdapter  extends BaseAdapter
{
    private final List<Item> mItems = new ArrayList<Item>();
    private final LayoutInflater mInflater;
    private Context mContext;

    public HBGCLandingPageAdapter(Context context, ArrayList<HBGCZoneObject> urls)
    {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);

        for (int i = 0; i < urls.size(); i++)
        {
            HBGCZoneObject currentZone = urls.get(i);
            Drawable thumbnail = currentZone.getThumbnail();
            mItems.add(new Item(currentZone.getZoneTitle(), currentZone.getThumbnail(),i));
        }
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Item getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i){return mItems.get(i).drawID;}

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        ImageView picture;
        TextView name;

        if (v == null)
        {
            v = mInflater.inflate(R.layout.grid_item, viewGroup, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
            v.setTag(R.id.text, v.findViewById(R.id.text));
        }

        picture = (ImageView) v.getTag(R.id.picture);
        name = (TextView) v.getTag(R.id.text);

        Item item = getItem(i);

        picture.setImageDrawable(item.drawable);
        picture.setId(i);
        name.setText(item.name);

        picture.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                HBGCAppManager.AppManager().setCurrentlySelectedZone(v.getId());
                // Launch the appropriate Zone (Regular or Social(
                HBGCZoneObject zone = HBGCAppManager.AppManager().getZones().get(v.getId());

                if (zone.getClass().equals(HBGCSocialZoneObject.class))
                {
                    // Launch social activity
                    Intent i = new Intent(mContext, HBGCSocialActivity.class);
                    mContext.startActivity(i);
                }
                else
                {
                    // Launch regular activity
                    Intent i = new Intent(mContext, HBGCZoneActivity.class);
                    mContext.startActivity(i);
                }
            }
        });

        return v;
    }

    private static class Item {
        public final String name;
        public final Drawable drawable;
        public final int drawID;

        Item(String name, Drawable draw, int drawID) {
            this.name = name;
            this.drawable = draw;
            this.drawID = drawID;
        }
    }
}

