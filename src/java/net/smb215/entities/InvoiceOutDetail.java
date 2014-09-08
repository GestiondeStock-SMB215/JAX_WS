package net.smb215.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.smb215.lib.CRUD;
import net.smb215.lib.Func;
import net.smb215.lib.QueryCriteria;

public class InvoiceOutDetail{
    private final CRUD crud;
    private String inv_out_det_id;
    private String inv_out_det_inv_id;
    private String inv_out_det_prod_id;
    private String inv_out_det_qty;
    private String inv_out_det_up;
    private String inv_out_det_total;
    private String inv_out_det_disc;
    private String inv_out_det_tota_due;
    private String inv_out_det_time_stamp;

    public InvoiceOutDetail() {
        crud = new CRUD("invoice_out_detail");
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
    
    public ArrayList<InvoiceOutDetail> Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields, ArrayList<String> order) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields, order);
        ArrayList<InvoiceOutDetail> result = new ArrayList<>();
        while (rs.next()) {
            InvoiceOutDetail tmp = new InvoiceOutDetail();
            tmp = (InvoiceOutDetail) Func.castResultSetToObject(rs, tmp);
            result.add(tmp);
        }
        return result;
    }

    public String getInv_out_det_id() {
        return inv_out_det_id;
    }

    public void setInv_out_det_id(String inv_out_det_id) {
        this.inv_out_det_id = inv_out_det_id;
    }

    public String getInv_out_det_inv_id() {
        return inv_out_det_inv_id;
    }

    public void setInv_out_det_inv_id(String inv_out_det_inv_id) {
        this.inv_out_det_inv_id = inv_out_det_inv_id;
    }

    public String getInv_out_det_prod_id() {
        return inv_out_det_prod_id;
    }

    public void setInv_out_det_prod_id(String inv_out_det_prod_id) {
        this.inv_out_det_prod_id = inv_out_det_prod_id;
    }

    public String getInv_out_det_qty() {
        return inv_out_det_qty;
    }

    public void setInv_out_det_qty(String inv_out_det_qty) {
        this.inv_out_det_qty = inv_out_det_qty;
    }

    public String getInv_out_det_up() {
        return inv_out_det_up;
    }

    public void setInv_out_det_up(String inv_out_det_up) {
        this.inv_out_det_up = inv_out_det_up;
    }

    public String getInv_out_det_total() {
        return inv_out_det_total;
    }

    public void setInv_out_det_total(String inv_out_det_total) {
        this.inv_out_det_total = inv_out_det_total;
    }

    public String getInv_out_det_disc() {
        return inv_out_det_disc;
    }

    public void setInv_out_det_disc(String inv_out_det_disc) {
        this.inv_out_det_disc = inv_out_det_disc;
    }

    public String getInv_out_det_tota_due() {
        return inv_out_det_tota_due;
    }

    public void setInv_out_det_tota_due(String inv_out_det_tota_due) {
        this.inv_out_det_tota_due = inv_out_det_tota_due;
    }

    public String getInv_out_det_time_stamp() {
        return inv_out_det_time_stamp;
    }

    public void setInv_out_det_time_stamp(String inv_out_det_time_stamp) {
        this.inv_out_det_time_stamp = inv_out_det_time_stamp;
    }
    
}