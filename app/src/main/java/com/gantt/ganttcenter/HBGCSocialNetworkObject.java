package com.gantt.ganttcenter;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dzqbdf on 7/16/15.
 */
public class HBGCSocialNetworkObject {

    private enum Network
    {
        Facebook,
        Twitter,
        Email,
        Youtube
    }

    private Network typeOfNetwork;
    private String networkTitle;
    private String thumbnail;
    private String networkURL;

    public HBGCSocialNetworkObject(JSONObject social)
    {

        try {
            this.setNetworkTitle(social.getString(Constants.TITLE_KEY));
            this.setThumbnail(social.getString(Constants.THUMBNAIL_KEY));
            this.setNetworkURL(social.getString(Constants.URL_KEY));
        }
        catch(JSONException e) {

        }
    }

    public Network getTypeOfNetwork() {
        return typeOfNetwork;
    }

    public void setTypeOfNetwork(Network typeOfNetwork) {
        this.typeOfNetwork = typeOfNetwork;
    }

    public String getNetworkTitle() {
        return networkTitle;
    }

    public void setNetworkTitle(String networkTitle) {
        this.networkTitle = networkTitle;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getNetworkURL() {
        return networkURL;
    }

    public void setNetworkURL(String networkURL) {
        this.networkURL = networkURL;
    }
}
