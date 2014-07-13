package net.smb215.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.smb215.lib.CRUD;
import net.smb215.lib.Func;
import net.smb215.lib.QueryCriteria;

public class Country{
    private final CRUD crud;
    private String cnt_id;
    private String cnt_iso;
    private String cnt_name;
    private String cnt_nicename;
    private String cnt_iso3;
    private String cnt_numcode;
    private String cnt_phonecode;
    private String cnt_time_stamp;

    public Country() {
        crud = new CRUD("country");
    }
    
    public ArrayList<Country> Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields);
        ArrayList<Country> result = new ArrayList<>();
        while (rs.next()) {
            Country tmp = new Country();
            tmp = (Country) Func.castResultSetToObject(rs, tmp);
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

    public String getCnt_id() {
        return cnt_id;
    }

    public void setCnt_id(String cnt_id) {
        this.cnt_id = cnt_id;
    }

    public String getCnt_iso() {
        return cnt_iso;
    }

    public void setCnt_iso(String cnt_iso) {
        this.cnt_iso = cnt_iso;
    }

    public String getCnt_name() {
        return cnt_name;
    }

    public void setCnt_name(String cnt_name) {
        this.cnt_name = cnt_name;
    }

    public String getCnt_nicename() {
        return cnt_nicename;
    }

    public void setCnt_nicename(String cnt_nicename) {
        this.cnt_nicename = cnt_nicename;
    }

    public String getCnt_iso3() {
        return cnt_iso3;
    }

    public void setCnt_iso3(String cnt_iso3) {
        this.cnt_iso3 = cnt_iso3;
    }

    public String getCnt_numcode() {
        return cnt_numcode;
    }

    public void setCnt_numcode(String cnt_numcode) {
        this.cnt_numcode = cnt_numcode;
    }

    public String getCnt_phonecode() {
        return cnt_phonecode;
    }

    public void setCnt_phonecode(String cnt_phonecode) {
        this.cnt_phonecode = cnt_phonecode;
    }

    public String getCnt_time_stamp() {
        return cnt_time_stamp;
    }

    public void setCnt_time_stamp(String cnt_time_stamp) {
        this.cnt_time_stamp = cnt_time_stamp;
    }
    
}