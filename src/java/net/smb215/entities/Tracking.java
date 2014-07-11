package net.smb215.entities;
public class Tracking{
    private String track_id;
    private String track_trans_id;
    private String track_ship_id;
    private String track_time_stamp;

    public Tracking() {
    }

    public String getTrack_id() {
        return track_id;
    }

    public void setTrack_id(String track_id) {
        this.track_id = track_id;
    }

    public String getTrack_trans_id() {
        return track_trans_id;
    }

    public void setTrack_trans_id(String track_trans_id) {
        this.track_trans_id = track_trans_id;
    }

    public String getTrack_ship_id() {
        return track_ship_id;
    }

    public void setTrack_ship_id(String track_ship_id) {
        this.track_ship_id = track_ship_id;
    }

    public String getTrack_time_stamp() {
        return track_time_stamp;
    }

    public void setTrack_time_stamp(String track_time_stamp) {
        this.track_time_stamp = track_time_stamp;
    }
    
}