package net.smb215.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.smb215.lib.CRUD;
import net.smb215.lib.Func;
import net.smb215.lib.QueryCriteria;
import net.smb215.lib.QueryOrder;

public class InvoiceIn {
    private final CRUD crud;
    private String inv_in_id;
    private String inv_in_ord_in_id;
    private String inv_in_cust_id;
    private String inv_in_date;
    private String inv_in_num;
    private String inv_in_total;
    private String inv_in_tax;
    private String inv_in_disc;
    private String inv_in_total_due;
    private String inv_in_status;
    private String inv_in_att;
    private String inv_in_time_stamp;

    public InvoiceIn() {
        crud = new CRUD("invoice_in");
    }
    
    public ArrayList<InvoiceIn> Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields, ArrayList<QueryOrder> order) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields, order);
        ArrayList<InvoiceIn> result = new ArrayList<>();
        while (rs.next()) {
            InvoiceIn tmp = new InvoiceIn();
            tmp = (InvoiceIn) Func.castResultSetToObject(rs, tmp);
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

    public String getInv_in_id() {
        return inv_in_id;
    }

    public void setInv_in_id(String inv_in_id) {
        this.inv_in_id = inv_in_id;
    }

    public String getInv_in_ord_in_id() {
        return inv_in_ord_in_id;
    }

    public void setInv_in_ord_in_id(String inv_in_ord_in_id) {
        this.inv_in_ord_in_id = inv_in_ord_in_id;
    }

    public String getInv_in_cust_id() {
        return inv_in_cust_id;
    }

    public void setInv_in_cust_id(String inv_in_cust_id) {
        this.inv_in_cust_id = inv_in_cust_id;
    }

    public String getInv_in_date() {
        return inv_in_date;
    }

    public void setInv_in_date(String inv_in_date) {
        this.inv_in_date = inv_in_date;
    }

    public String getInv_in_num() {
        return inv_in_num;
    }

    public void setInv_in_num(String inv_in_num) {
        this.inv_in_num = inv_in_num;
    }

    public String getInv_in_total() {
        return inv_in_total;
    }

    public void setInv_in_total(String inv_in_total) {
        this.inv_in_total = inv_in_total;
    }

    public String getInv_in_tax() {
        return inv_in_tax;
    }

    public void setInv_in_tax(String inv_in_tax) {
        this.inv_in_tax = inv_in_tax;
    }

    public String getInv_in_disc() {
        return inv_in_disc;
    }

    public void setInv_in_disc(String inv_in_disc) {
        this.inv_in_disc = inv_in_disc;
    }

    public String getInv_in_total_due() {
        return inv_in_total_due;
    }

    public void setInv_in_total_due(String inv_in_total_due) {
        this.inv_in_total_due = inv_in_total_due;
    }

    public String getInv_in_status() {
        return inv_in_status;
    }

    public void setInv_in_status(String inv_in_status) {
        this.inv_in_status = inv_in_status;
    }

    public String getInv_in_att() {
        return inv_in_att;
    }

    public void setInv_in_att(String inv_in_att) {
        this.inv_in_att = inv_in_att;
    }

    public String getInv_in_time_stamp() {
        return inv_in_time_stamp;
    }

    public void setInv_in_time_stamp(String inv_in_time_stamp) {
        this.inv_in_time_stamp = inv_in_time_stamp;
    }
    
}