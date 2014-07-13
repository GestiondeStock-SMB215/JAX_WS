package net.smb215.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.smb215.lib.CRUD;
import net.smb215.lib.Func;
import net.smb215.lib.QueryCriteria;

public class Branch {
    private final CRUD crud;
    private String bra_id;
    private String bra_name;
    private String bra_cnt_id;
    private String bra_city;
    private String bra_add_srt;
    private String bra_add_1;
    private String bra_tel_1;
    private String bra_tel_2;
    private String bra_fax;
    private String bra_email;
    private String bra_time_stamp;

    public Branch() {
        crud = new CRUD("branch");
    }
    
    public ArrayList<Branch> Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields);
        ArrayList<Branch> result = new ArrayList<>();
        while (rs.next()) {
            Branch tmp = new Branch();
            tmp = (Branch) Func.castResultSetToObject(rs, tmp);
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

    public String getBra_id() {
        return bra_id;
    }

    public void setBra_id(String bra_id) {
        this.bra_id = bra_id;
    }

    public String getBra_name() {
        return bra_name;
    }

    public void setBra_name(String bra_name) {
        this.bra_name = bra_name;
    }

    public String getBra_cnt_id() {
        return bra_cnt_id;
    }

    public void setBra_cnt_id(String bra_cnt_id) {
        this.bra_cnt_id = bra_cnt_id;
    }

    public String getBra_city() {
        return bra_city;
    }

    public void setBra_city(String bra_city) {
        this.bra_city = bra_city;
    }

    public String getBra_add_srt() {
        return bra_add_srt;
    }

    public void setBra_add_srt(String bra_add_srt) {
        this.bra_add_srt = bra_add_srt;
    }

    public String getBra_add_1() {
        return bra_add_1;
    }

    public void setBra_add_1(String bra_add_1) {
        this.bra_add_1 = bra_add_1;
    }

    public String getBra_tel_1() {
        return bra_tel_1;
    }

    public void setBra_tel_1(String bra_tel_1) {
        this.bra_tel_1 = bra_tel_1;
    }

    public String getBra_tel_2() {
        return bra_tel_2;
    }

    public void setBra_tel_2(String bra_tel_2) {
        this.bra_tel_2 = bra_tel_2;
    }

    public String getBra_fax() {
        return bra_fax;
    }

    public void setBra_fax(String bra_fax) {
        this.bra_fax = bra_fax;
    }

    public String getBra_email() {
        return bra_email;
    }

    public void setBra_email(String bra_email) {
        this.bra_email = bra_email;
    }

    public String getBra_time_stamp() {
        return bra_time_stamp;
    }

    public void setBra_time_stamp(String bra_time_stamp) {
        this.bra_time_stamp = bra_time_stamp;
    }
    
}