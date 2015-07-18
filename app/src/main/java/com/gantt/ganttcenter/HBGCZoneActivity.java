package com.gantt.ganttcenter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class HBGCZoneActivity extends Activity
{
    private HBGCZoneObject currentZone;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hbgczone);

        this.currentZone = HBGCAppManager.AppManager().getZones().get(HBGCAppManager.AppManager().getCurrentlySelectedZone());

        ImageView imageView = (ImageView)this.findViewById(R.id.imageView9);
        imageView.setImageDrawable(this.currentZone.getHeaderImages().get(0));

        // sample code snippet to set the text content on the ExpandableTextView
        HBGCExpandableTextView expTv1 = (HBGCExpandableTextView) this.findViewById(R.id.expand_text_view)
                .findViewById(R.id.expand_text_view);

        // IMPORTANT - call setText on the ExpandableTextView to set the text content to display
        expTv1.setText(this.currentZone.getZoneDescription());

        ViewPager pager = (ViewPager)this.findViewById(R.id.viewpager);

        pager.setAdapter(new HBGCZoneContentPagerAdapter(this, this.currentZone.getContent()));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hbgczone, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
