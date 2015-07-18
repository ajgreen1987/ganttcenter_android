package com.gantt.ganttcenter;

import android.graphics.drawable.Drawable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dzqbdf on 7/16/15.
 */
public class HBGCContentObject {



    private String thumbnailURL;
    private Drawable thumbnail;
    private String titleText;
    private String contentURL;

    public HBGCContentObject(JSONObject json)
    {
        try
        {
            this.setThumbnailURL(json.getString(Constants.THUMBNAIL_KEY));
            this.setTitleText(json.getString(Constants.TITLE_KEY));
            this.setContentURL(json.getString(Constants.URL_KEY));

            try {

                Thread thread = new Thread(new Runnable(){
                    @Override
                    public void run() {
                        HBGCContentObject.this.setThumbnail(HBGCAppManager.createDrawableFromUrl(HBGCContentObject.this.getThumbnailURL()));
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
        catch(JSONException e)
        {

        }
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public Drawable getThumbnail()
    {
        return thumbnail;
    }

    public void setThumbnail(Drawable thumbnail)
    {
        this.thumbnail = thumbnail;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public String getContentURL() {
        return contentURL;
    }

    public void setContentURL(String contentURL) {
        this.contentURL = contentURL;
    }
}
