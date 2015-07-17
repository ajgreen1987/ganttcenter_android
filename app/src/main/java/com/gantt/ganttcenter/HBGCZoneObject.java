package com.gantt.ganttcenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by dzqbdf on 7/16/15.
 */
public class HBGCZoneObject {

    private String thumbnailUrl;
    private String zoneDescription;
    private ArrayList<String> headerImages;
    private ArrayList<HBGCContentObject> content;
    private String zoneTitle;

    public HBGCZoneObject(JSONObject object) {

        try {
            this.setThumbnailUrl(object.getString(Constants.THUMBNAIL_KEY));
            this.setZoneTitle(object.getString(Constants.TITLE_KEY));
            this.setZoneDescription(object.getString(Constants.DESCRIPTION_KEY));
            this.parseOutHeaders(object.getJSONArray(Constants.HEADERS_KEY));
            this.parseOutContent(object.getJSONArray(Constants.CONTENT_KEY));
        }
        catch(JSONException e)
        {

        }


    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getZoneDescription() {
        return zoneDescription;
    }

    public void setZoneDescription(String zoneDescription) {
        this.zoneDescription = zoneDescription;
    }

    public ArrayList<String> getHeaderImages() {
        return headerImages;
    }

    public void setHeaderImages(ArrayList<String> headerImages) {
        this.headerImages = headerImages;
    }

    public ArrayList<HBGCContentObject> getContent() {
        return content;
    }

    public void setContent(ArrayList<HBGCContentObject> content) {
        this.content = content;
    }

    public String getZoneTitle() {
        return zoneTitle;
    }

    public void setZoneTitle(String zoneTitle) {
        this.zoneTitle = zoneTitle;
    }

    private void parseOutHeaders(JSONArray headers)
    {
        this.setHeaderImages(new ArrayList<String>());

        for(int i = 0; i < headers.length(); i++)
        {
            try
            {
                JSONObject website = headers.getJSONObject(i);
                String url = website.getString(Constants.WEBSITE_KEY);
                this.getHeaderImages().add(url);
            }
            catch(JSONException e)
            {
            }
        }
    }

    private void parseOutContent(JSONArray content)
    {
        this.setContent(new ArrayList<HBGCContentObject>());

        for (int i=0;i<content.length();i++) {
            try {
                JSONObject json = content.getJSONObject(i);
                HBGCContentObject newContent = new HBGCContentObject(json);
                this.getContent().add(newContent);
            } catch (JSONException e) {
            }
        }
    }

}
