package com.gantt.ganttcenter;

import android.app.AppOpsManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by dzqbdf on 7/16/15.
 */
public class HBGCAppManager
{
    /*
    @property (nonatomic, strong) NSDictionary *currentJSON;
@property (nonatomic, strong) NSArray *currentEvents;
@property (nonatomic, strong) NSArray *currentZones;
@property (nonatomic, strong) NSMutableArray *zones;
@property (nonatomic, strong) NSMutableArray *events;
     */

    private JSONObject currentJSON;
    private JSONArray currentEvents;
    private JSONArray currentZones;
    private ArrayList<HBGCEventObject> events;
    private ArrayList<HBGCZoneObject> zones;

    private static HBGCAppManager _instance;

    public static HBGCAppManager AppManager ()
    {
        if (_instance==null)
        {
            _instance = new HBGCAppManager();
        }

        return _instance;
    }

    public void didParseResponse(JSONObject json)
    {
        this.setCurrentJSON(json);

        try
        {
            this.setCurrentEvents(json.getJSONArray(Constants.UPCOMING_EVENTS_KEY));
            this.setCurrentZones(json.getJSONArray(Constants.ZONES_KEY));
        }
        catch(JSONException e) {

        }

        /*
            self.currentJSON = aResponse;
    self.currentEvents = [aResponse objectForKey:UPCOMING_EVENTS_KEY];
    self.currentZones = [aResponse objectForKey:ZONES_KEY];

    [self buildOutUpcomingEventsViewController];
    [self parseOutZones];

    // All instances of TestClass will be notified
    [[NSNotificationCenter defaultCenter] postNotificationName:NOTIFICATION_PARSED_JSON
                                                        object:self];
         */
    }

    private void buildOutUpcomingEvents()
    {
        for(int i = 0; i < this.getCurrentEvents().length(); i++)
        {
            try
            {
                JSONObject network = this.getCurrentEvents().getJSONObject(i);


                String thumbnail = network.getString(Constants.THUMBNAIL_KEY);
                String website = network.getString(Constants.WEBSITE_KEY);

                HBGCEventObject newEvent = new HBGCEventObject(thumbnail, website);

                this.getEvents().add(newEvent);
            }
            catch(JSONException e)
            {
            }
        }
    }

    private void parseOutZones()
    {
        if (this.getCurrentZones().length()>0)
        {
            for(int i = 0; i < this.getCurrentZones().length(); i++)
            {
                try
                {
                    JSONObject zone = this.getCurrentZones().getJSONObject(i);

                    if (zone.has(Constants.SOCIAL_KEY))
                    {
                        HBGCSocialZoneObject social = new HBGCSocialZoneObject(zone);
                        this.getZones().add(social);
                    }
                    else
                    {
                        HBGCZoneObject newZone = new HBGCZoneObject(zone);
                        this.getZones().add(newZone);
                    }
                }
                catch(JSONException e)
                {
                }
            }
        }

        /*

        Not sure what this was doing on the iOS side, but leaving it here just in case!

        int counter = 1;

        for (int i=0; i<intermediateThumbnail.count; i++)
        {
            if (i%2==0)
            {
                NSMutableArray *toAddTo = [[NSMutableArray alloc] initWithObjects:nil];

                [toAddTo addObject:[intermediateThumbnail objectAtIndex:i]];

                [self.zones addObject:toAddTo];
            }
            else
            {
                NSInteger lastIndex = i-counter;
                [[self.zones objectAtIndex:lastIndex] addObject:[intermediateThumbnail objectAtIndex:i]];
                counter++;
            }
        }
    }

         */
    }



    public JSONObject getCurrentJSON() {
        return currentJSON;
    }

    public void setCurrentJSON(JSONObject currentJSON) {
        this.currentJSON = currentJSON;
    }

    public JSONArray getCurrentEvents() {
        return currentEvents;
    }

    public void setCurrentEvents(JSONArray currentEvents) {
        this.currentEvents = currentEvents;
    }

    public JSONArray getCurrentZones() {
        return currentZones;
    }

    public void setCurrentZones(JSONArray currentZones) {
        this.currentZones = currentZones;
    }

    public ArrayList<HBGCEventObject> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<HBGCEventObject> events) {
        this.events = events;
    }

    public ArrayList<HBGCZoneObject> getZones() {
        return zones;
    }

    public void setZones(ArrayList<HBGCZoneObject> zones) {
        this.zones = zones;
    }
}
