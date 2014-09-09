package net.smb215.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.smb215.lib.CRUD;
import net.smb215.lib.Func;
import net.smb215.lib.QueryCriteria;
import net.smb215.lib.QueryOrder;

public class Customer {
    private final CRUD crud;
    private String cust_id;
    private String cust_comp;
    private String cust_name;
    private String cust_title;
    private String cust_add_1;
    private String cust_add_2;
    private String cust_city;
    private String cust_cnt_id;
    private String cust_tel_1;
    private String cust_tel_2;
    private String cust_fax;
    private String cust_email;
    private String cust_site;
    private String cust_logo;
    private String cust_time_stamp;

    public Customer() {
        crud = new CRUD("customer");
    }
    
    public ArrayList<Customer> Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields, ArrayList<QueryOrder> order) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields, order);
        ArrayList<Customer> result = new ArrayList<>();
        while (rs.next()) {
            Customer tmp = new Customer();
            tmp = (Customer) Func.castResultSetToObject(rs, tmp);
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

    public String getCust_id() {
        return cust_id;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_comp() {
        return cust_comp;
    }

    public void setCust_comp(String cust_comp) {
        this.cust_comp = cust_comp;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_title() {
        return cust_title;
    }

    public void setCust_title(String cust_title) {
        this.cust_title = cust_title;
    }

    public String getCust_add_1() {
        return cust_add_1;
    }

    public void setCust_add_1(String cust_add_1) {
        this.cust_add_1 = cust_add_1;
    }

    public String getCust_add_2() {
        return cust_add_2;
    }

    public void setCust_add_2(String cust_add_2) {
        this.cust_add_2 = cust_add_2;
    }

    public String getCust_city() {
        return cust_city;
    }

    public void setCust_city(String cust_city) {
        this.cust_city = cust_city;
    }

    public String getCust_cnt_id() {
        return cust_cnt_id;
    }

    public void setCust_cnt_id(String cust_cnt_id) {
        this.cust_cnt_id = cust_cnt_id;
    }

    public String getCust_tel_1() {
        return cust_tel_1;
    }

    public void setCust_tel_1(String cust_tel_1) {
        this.cust_tel_1 = cust_tel_1;
    }

    public String getCust_tel_2() {
        return cust_tel_2;
    }

    public void setCust_tel_2(String cust_tel_2) {
        this.cust_tel_2 = cust_tel_2;
    }

    public String getCust_fax() {
        return cust_fax;
    }

    public void setCust_fax(String cust_fax) {
        this.cust_fax = cust_fax;
    }

    public String getCust_email() {
        return cust_email;
    }

    public void setCust_email(String cust_email) {
        this.cust_email = cust_email;
    }

    public String getCust_site() {
        return cust_site;
    }

    public void setCust_site(String cust_site) {
        this.cust_site = cust_site;
    }

    public String getCust_logo() {
        return cust_logo;
    }

    public void setCust_logo(String cust_logo) {
        this.cust_logo = cust_logo;
    }

    public String getCust_time_stamp() {
        return cust_time_stamp;
    }

    public void setCust_time_stamp(String cust_time_stamp) {
        this.cust_time_stamp = cust_time_stamp;
    }
    
}