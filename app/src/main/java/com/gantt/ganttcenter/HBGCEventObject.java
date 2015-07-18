package com.gantt.ganttcenter;

/**
 * Created by dzqbdf on 7/16/15.
 */
public class HBGCEventObject extends HBGCHeaderObject
{
    private String website;

    public HBGCEventObject(String url, String eventWebsite)
    {
        super(url);

        try {
            this.setWebsite(eventWebsite);

            Thread thread = new Thread(new Runnable(){
                @Override
                public void run() {
                    HBGCEventObject.this.setThumbnail(HBGCAppManager.createDrawableFromUrl(HBGCEventObject.this.getThumbnailURL()));
                }
            });

            thread.start();
            thread.join();

        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }


    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
