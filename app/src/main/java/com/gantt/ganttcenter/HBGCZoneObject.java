package com.gantt.ganttcenter;

import android.graphics.drawable.Drawable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by dzqbdf on 7/16/15.
 */
public class HBGCZoneObject {

    private String thumbnailUrl;
    private Drawable thumbnail;
    private String zoneDescription;
    private ArrayList<Drawable> headerImages;
    private ArrayList<HBGCContentObject> content;
    private String zoneTitle;

    public HBGCZoneObject(JSONObject object) {

        try {
            this.setThumbnailUrl(object.getString(Constants.THUMBNAIL_KEY));
            this.setZoneTitle(object.getString(Constants.TITLE_KEY));
            this.setZoneDescription(object.getString(Constants.DESCRIPTION_KEY));
            this.parseOutHeaders(object.getJSONArray(Constants.HEADERS_KEY));
            this.parseOutContent(object.getJSONArray(Constants.CONTENT_KEY));

            Thread thread = new Thread(new Runnable(){
                @Override
                public void run() {
                    HBGCZoneObject.this.setThumbnail(HBGCAppManager.createDrawableFromUrl(HBGCZoneObject.this.getThumbnailUrl()));
                }
            });

            thread.start();
            thread.join();

        }
        catch(JSONException e)
        {

        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }


    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Drawable getThumbnail()
    {
        return thumbnail;
    }

    public void setThumbnail(Drawable thumbnail)
    {
        this.thumbnail = thumbnail;
    }

    public String getZoneDescription() {
        return zoneDescription;
    }

    public void setZoneDescription(String zoneDescription) {
        this.zoneDescription = zoneDescription;
    }

    public ArrayList<Drawable> getHeaderImages() {
        return headerImages;
    }

    public void setHeaderImages(ArrayList<Drawable> headerImages) {
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
        this.setHeaderImages(new ArrayList<Drawable>());

        for(int i = 0; i < headers.length(); i++)
        {
            try
            {
                JSONObject website = headers.getJSONObject(i);
                final String url = website.getString(Constants.WEBSITE_KEY);
                Thread thread = new Thread(new Runnable(){
                    @Override
                    public void run() {
                        HBGCZoneObject.this.getHeaderImages().add(HBGCAppManager.createDrawableFromUrl(url));
                    }
                });
                thread.start();
                thread.join();
            }
            catch(JSONException e)
            {
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
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
