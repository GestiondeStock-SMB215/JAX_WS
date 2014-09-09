package net.smb215.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.smb215.lib.CRUD;
import net.smb215.lib.Func;
import net.smb215.lib.QueryCriteria;
import net.smb215.lib.QueryOrder;

public class Status{
    private final CRUD crud;
    private String sta_id;
    private String sta_ref;
    private String sta_desc;
    private String sta_time_stamp;

    public Status() {
        crud = new CRUD("status");
    }
    
    public ArrayList<Status> Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields, ArrayList<QueryOrder> order) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields, order);
        ArrayList<Status> result = new ArrayList<>();
        while (rs.next()) {
            Status tmp = new Status();
            tmp = (Status) Func.castResultSetToObject(rs, tmp);
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