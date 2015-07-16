package com.gantt.ganttcenter;

/**
 * Created by dzqbdf on 7/16/15.
 */
public class HBGCHeaderObject {

    private String thumbnailURL;

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
}
