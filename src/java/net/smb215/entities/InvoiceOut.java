package net.smb215.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.smb215.lib.CRUD;
import net.smb215.lib.Func;
import net.smb215.lib.QueryCriteria;

public class InvoiceOut{
    private final CRUD crud;
    private String inv_out_id;
    private String inv_out_ord_out_id;
    private String inv_out_sup_id;
    private String inv_out_date;
    private String inv_out_num;
    private String inv_out_total;
    private String inv_out_tax;
    private String inv_out_disc;
    private String inv_out_total_due;
    private String inv_out_status;
    private String inv_out_att;
    private String inv_out_time_stamp;

    public InvoiceOut() {
        crud = new CRUD("invoice_out");
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
    
    public ArrayList<InvoiceOut> Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields);
        ArrayList<InvoiceOut> result = new ArrayList<>();
        while (rs.next()) {
            InvoiceOut tmp = new InvoiceOut();
            tmp = (InvoiceOut) Func.castResultSetToObject(rs, tmp);
            result.add(tmp);
        }
        return result;
    }

    public String getInv_out_id() {
        return inv_out_id;
    }

    public void setInv_out_id(String inv_out_id) {
        this.inv_out_id = inv_out_id;
    }

    public String getInv_out_ord_out_id() {
        return inv_out_ord_out_id;
    }

    public void setInv_out_ord_out_id(String inv_out_ord_out_id) {
        this.inv_out_ord_out_id = inv_out_ord_out_id;
    }

    public String getInv_out_sup_id() {
        return inv_out_sup_id;
    }

    public void setInv_out_sup_id(String inv_out_sup_id) {
        this.inv_out_sup_id = inv_out_sup_id;
    }

    public String getInv_out_date() {
        return inv_out_date;
    }

    public void setInv_out_date(String inv_out_date) {
        this.inv_out_date = inv_out_date;
    }

    public String getInv_out_num() {
        return inv_out_num;
    }

    public void setInv_out_num(String inv_out_num) {
        this.inv_out_num = inv_out_num;
    }

    public String getInv_out_total() {
        return inv_out_total;
    }

    public void setInv_out_total(String inv_out_total) {
        this.inv_out_total = inv_out_total;
    }

    public String getInv_out_tax() {
        return inv_out_tax;
    }

    public void setInv_out_tax(String inv_out_tax) {
        this.inv_out_tax = inv_out_tax;
    }

    public String getInv_out_disc() {
        return inv_out_disc;
    }

    public void setInv_out_disc(String inv_out_disc) {
        this.inv_out_disc = inv_out_disc;
    }

    public String getInv_out_total_due() {
        return inv_out_total_due;
    }

    public void setInv_out_total_due(String inv_out_total_due) {
        this.inv_out_total_due = inv_out_total_due;
    }

    public String getInv_out_status() {
        return inv_out_status;
    }

    public void setInv_out_status(String inv_out_status) {
        this.inv_out_status = inv_out_status;
    }

    public String getInv_out_att() {
        return inv_out_att;
    }

    public void setInv_out_att(String inv_out_att) {
        this.inv_out_att = inv_out_att;
    }

    public String getInv_out_time_stamp() {
        return inv_out_time_stamp;
    }

    public void setInv_out_time_stamp(String inv_out_time_stamp) {
        this.inv_out_time_stamp = inv_out_time_stamp;
    }
    
    
}