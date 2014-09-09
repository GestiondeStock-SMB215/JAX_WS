package net.smb215.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.smb215.lib.CRUD;
import net.smb215.lib.Func;
import net.smb215.lib.QueryCriteria;
import net.smb215.lib.QueryOrder;

public class Tracking{
    private final CRUD crud;
    private String track_id;
    private String track_trans_id;
    private String track_ship_id;
    private String track_time_stamp;

    public Tracking() {
        crud = new CRUD("tracking");
    }
    
    public ArrayList<Tracking> Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields, ArrayList<QueryOrder> order) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields, order);
        ArrayList<Tracking> result = new ArrayList<>();
        while (rs.next()) {
            Tracking tmp = new Tracking();
            tmp = (Tracking) Func.castResultSetToObject(rs, tmp);
            result.add(tmp);
        }
        return result;
    }
    
    public int Create(HashMap<String, String> params) {
        return crud.Create(params);
    }
   
    public int Delete(ArrayList<QueryCriteria> criteria) {
        return crud.Delete(criteria);
    }
   
    public int Update(ArrayList<QueryCriteria> criteria, HashMap<String, String> fields) {
        return crud.Update(criteria, fields);
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