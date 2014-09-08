package net.smb215.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.smb215.lib.CRUD;
import net.smb215.lib.Func;
import net.smb215.lib.QueryCriteria;

public class OrderOut {
    private final CRUD crud;
    private String ord_out_id;
    private String ord_out_sup_id;
    private String ord_out_date;
    private String ord_out_del_date;
    private String ord_out_status;
    private String ord_out_time_stamp;

    public OrderOut() {
        crud = new CRUD("order_out");
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
    
    public ArrayList<OrderOut> Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields, ArrayList<String> order) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields, order);
        ArrayList<OrderOut> result = new ArrayList<>();
        while (rs.next()) {
            OrderOut tmp = new OrderOut();
            tmp = (OrderOut) Func.castResultSetToObject(rs, tmp);
            result.add(tmp);
        }
        return result;
    }

    public String getOrd_out_id() {
        return ord_out_id;
    }

    public void setOrd_out_id(String ord_out_id) {
        this.ord_out_id = ord_out_id;
    }

    public String getOrd_out_sup_id() {
        return ord_out_sup_id;
    }

    public void setOrd_out_sup_id(String ord_out_sup_id) {
        this.ord_out_sup_id = ord_out_sup_id;
    }

    public String getOrd_out_date() {
        return ord_out_date;
    }

    public void setOrd_out_date(String ord_out_date) {
        this.ord_out_date = ord_out_date;
    }

    public String getOrd_out_del_date() {
        return ord_out_del_date;
    }

    public void setOrd_out_del_date(String ord_out_del_date) {
        this.ord_out_del_date = ord_out_del_date;
    }

    public String getOrd_out_status() {
        return ord_out_status;
    }

    public void setOrd_out_status(String ord_out_status) {
        this.ord_out_status = ord_out_status;
    }

    public String getOrd_out_time_stamp() {
        return ord_out_time_stamp;
    }

    public void setOrd_out_time_stamp(String ord_out_time_stamp) {
        this.ord_out_time_stamp = ord_out_time_stamp;
    }
    
}