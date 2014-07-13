package net.smb215.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.smb215.lib.CRUD;
import net.smb215.lib.Func;
import net.smb215.lib.QueryCriteria;

public class Supplier{
    private final CRUD crud;
    private String sup_id;
    private String sup_comp;
    private String sup_name;
    private String sup_title;
    private String sup_add_1;
    private String sup_add_2;
    private String sup_city;
    private String sup_cnt_id;
    private String sup_tel_1;
    private String sup_tel_2;
    private String sup_fax;
    private String sup_email;
    private String sup_site;
    private String sup_logo;
    private String sup_time_stamp;

    public Supplier() {
        crud = new CRUD("supplier");
    }
    
    public ArrayList<Supplier> Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields);
        ArrayList<Supplier> result = new ArrayList<>();
        while (rs.next()) {
            Supplier tmp = new Supplier();
            tmp = (Supplier) Func.castResultSetToObject(rs, tmp);
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

    public String getSup_id() {
        return sup_id;
    }

    public void setSup_id(String sup_id) {
        this.sup_id = sup_id;
    }

    public String getSup_comp() {
        return sup_comp;
    }

    public void setSup_comp(String sup_comp) {
        this.sup_comp = sup_comp;
    }

    public String getSup_name() {
        return sup_name;
    }

    public void setSup_name(String sup_name) {
        this.sup_name = sup_name;
    }

    public String getSup_title() {
        return sup_title;
    }

    public void setSup_title(String sup_title) {
        this.sup_title = sup_title;
    }

    public String getSup_add_1() {
        return sup_add_1;
    }

    public void setSup_add_1(String sup_add_1) {
        this.sup_add_1 = sup_add_1;
    }

    public String getSup_add_2() {
        return sup_add_2;
    }

    public void setSup_add_2(String sup_add_2) {
        this.sup_add_2 = sup_add_2;
    }

    public String getSup_city() {
        return sup_city;
    }

    public void setSup_city(String sup_city) {
        this.sup_city = sup_city;
    }

    public String getSup_cnt_id() {
        return sup_cnt_id;
    }

    public void setSup_cnt_id(String sup_cnt_id) {
        this.sup_cnt_id = sup_cnt_id;
    }

    public String getSup_tel_1() {
        return sup_tel_1;
    }

    public void setSup_tel_1(String sup_tel_1) {
        this.sup_tel_1 = sup_tel_1;
    }

    public String getSup_tel_2() {
        return sup_tel_2;
    }

    public void setSup_tel_2(String sup_tel_2) {
        this.sup_tel_2 = sup_tel_2;
    }

    public String getSup_fax() {
        return sup_fax;
    }

    public void setSup_fax(String sup_fax) {
        this.sup_fax = sup_fax;
    }

    public String getSup_email() {
        return sup_email;
    }

    public void setSup_email(String sup_email) {
        this.sup_email = sup_email;
    }

    public String getSup_site() {
        return sup_site;
    }

    public void setSup_site(String sup_site) {
        this.sup_site = sup_site;
    }

    public String getSup_logo() {
        return sup_logo;
    }

    public void setSup_logo(String sup_logo) {
        this.sup_logo = sup_logo;
    }

    public String getSup_time_stamp() {
        return sup_time_stamp;
    }

    public void setSup_time_stamp(String sup_time_stamp) {
        this.sup_time_stamp = sup_time_stamp;
    }
    
}