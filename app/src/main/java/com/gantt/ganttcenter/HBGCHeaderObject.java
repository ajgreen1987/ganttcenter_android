package com.gantt.ganttcenter;

import android.graphics.drawable.Drawable;

/**
 * Created by dzqbdf on 7/16/15.
 */
public class HBGCHeaderObject {

    private String thumbnailURL;
    private Drawable thumbnail;

    public HBGCHeaderObject (String url)
    {
        this.setThumbnailURL(url);
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
}
