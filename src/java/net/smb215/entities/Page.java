package net.smb215.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.smb215.lib.CRUD;
import net.smb215.lib.Func;
import net.smb215.lib.QueryCriteria;

public class Page {
    private final CRUD crud;
    private String page_id;
    private String page_parent_id;
    private String page_name;
    private String page_url;
    private String page_acl;
    private String page_in_menu;
    private String page_order;
    private String page_time_stamp;

    public Page() {
        crud = new CRUD("page");
    }
    
    public ArrayList<Page> Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields);
        ArrayList<Page> result = new ArrayList<>();
        while (rs.next()) {
            Page tmp = new Page();
            tmp = (Page) Func.castResultSetToObject(rs, tmp);
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

    public String getPage_id() {
        return page_id;
    }

    public void setPage_id(String page_id) {
        this.page_id = page_id;
    }

    public String getPage_parent_id() {
        return page_parent_id;
    }

    public void setPage_parent_id(String page_parent_id) {
        this.page_parent_id = page_parent_id;
    }

    public String getPage_name() {
        return page_name;
    }

    public void setPage_name(String page_name) {
        this.page_name = page_name;
    }

    public String getPage_url() {
        return page_url;
    }

    public void setPage_url(String page_url) {
        this.page_url = page_url;
    }

    public String getPage_acl() {
        return page_acl;
    }

    public void setPage_acl(String page_acl) {
        this.page_acl = page_acl;
    }

    public String getPage_in_menu() {
        return page_in_menu;
    }

    public void setPage_in_menu(String page_in_menu) {
        this.page_in_menu = page_in_menu;
    }

    public String getPage_time_stamp() {
        return page_time_stamp;
    }

    public void setPage_time_stamp(String page_time_stamp) {
        this.page_time_stamp = page_time_stamp;
    }

    public String getPage_order() {
        return page_order;
    }

    public void setPage_order(String page_order) {
        this.page_order = page_order;
    }
    
}