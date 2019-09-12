package lk.uordcs.SLUG.REST_Classes;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Optional;

public class EventSchedule {

    @SerializedName("EventID")
    @Expose
    private int eventID;
    @SerializedName("Event")
    @Expose
    private String event;
    @SerializedName("Dates")
    @Expose
    private String dates;
    @SerializedName("Venue")
    @Expose
    private String venue;

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }


}
