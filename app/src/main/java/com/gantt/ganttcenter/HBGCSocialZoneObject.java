package com.gantt.ganttcenter;

import java.util.ArrayList;
import com.gantt.ganttcenter.HBGCSocialNetworkObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dzqbdf on 7/16/15.
 */
public class HBGCSocialZoneObject extends HBGCZoneObject {

    private ArrayList<HBGCSocialNetworkObject> socialNetworks;
    private String messageToPost;

    public HBGCSocialZoneObject (JSONObject object)
    {
        super(object);

        try {
            JSONObject social = object.getJSONObject(Constants.SOCIAL_KEY);
            this.parseNetworks(social.getJSONArray(Constants.NETWORKS_KEY));
            this.setMessageToPost(social.getString(Constants.POST_KEY));
        }
        catch(JSONException e)
        {

        }
    }

    private void parseNetworks(JSONArray networks)
    {
        this.setSocialNetworks(new ArrayList<HBGCSocialNetworkObject>());

        for(int i = 0; i < networks.length(); i++)
        {
            try
            {
                JSONObject network = networks.getJSONObject(i);
                HBGCSocialNetworkObject socialObject = new HBGCSocialNetworkObject(network);
                this.getSocialNetworks().add(socialObject);
            }
            catch(JSONException e)
            {
            }
        }
    }

    public ArrayList<HBGCSocialNetworkObject> getSocialNetworks() {
        return socialNetworks;
    }

    public void setSocialNetworks(ArrayList<HBGCSocialNetworkObject> socialNetworks) {
        this.socialNetworks = socialNetworks;
    }

    public String getMessageToPost() {
        return messageToPost;
    }

    public void setMessageToPost(String messageToPost) {
        this.messageToPost = messageToPost;
    }
}
