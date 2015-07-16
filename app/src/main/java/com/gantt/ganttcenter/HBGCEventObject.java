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

        this.setWebsite(eventWebsite);
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
