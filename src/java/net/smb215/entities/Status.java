package net.smb215.entities;
public class Status{
    private String sta_id;
    private String sta_ref;
    private String sta_desc;
    private String sta_time_stamp;

    public Status() {
    }

    public String getSta_id() {
        return sta_id;
    }

    public void setSta_id(String sta_id) {
        this.sta_id = sta_id;
    }

    public String getSta_ref() {
        return sta_ref;
    }

    public void setSta_ref(String sta_ref) {
        this.sta_ref = sta_ref;
    }

    public String getSta_desc() {
        return sta_desc;
    }

    public void setSta_desc(String sta_desc) {
        this.sta_desc = sta_desc;
    }

    public String getSta_time_stamp() {
        return sta_time_stamp;
    }

    public void setSta_time_stamp(String sta_time_stamp) {
        this.sta_time_stamp = sta_time_stamp;
    }
    
}