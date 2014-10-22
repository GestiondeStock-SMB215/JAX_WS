package net.smb215.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.smb215.lib.CRUD;
import net.smb215.lib.Func;
import net.smb215.lib.QueryCriteria;
import net.smb215.lib.QueryOrder;

public class OrderIn {
    private final CRUD crud;
    private String ord_in_id;
    private String ord_in_cust_id;
    private String ord_in_bra_id;
    private String ord_in_date;
    private String ord_in_del_date;
    private String ord_in_status;
    private String ord_in_time_stamp;

    public OrderIn() {
        crud = new CRUD("order_in");
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
    
    public ArrayList<OrderIn> Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields, ArrayList<QueryOrder> order) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields, order);
        ArrayList<OrderIn> result = new ArrayList<>();
        while (rs.next()) {
            OrderIn tmp = new OrderIn();
            tmp = (OrderIn) Func.castResultSetToObject(rs, tmp);
            result.add(tmp);
        }
        return result;
    }

    public String getOrd_in_bra_id() {
        return ord_in_bra_id;
    }

    public void setOrd_in_bra_id(String ord_in_bra_id) {
        this.ord_in_bra_id = ord_in_bra_id;
    }

    public String getOrd_in_id() {
        return ord_in_id;
    }

    public void setOrd_in_id(String ord_in_id) {
        this.ord_in_id = ord_in_id;
    }

    public String getOrd_in_cust_id() {
        return ord_in_cust_id;
    }

    public void setOrd_in_cust_id(String ord_in_cust_id) {
        this.ord_in_cust_id = ord_in_cust_id;
    }

    public String getOrd_in_date() {
        return ord_in_date;
    }

    public void setOrd_in_date(String ord_in_date) {
        this.ord_in_date = ord_in_date;
    }

    public String getOrd_in_del_date() {
        return ord_in_del_date;
    }

    public void setOrd_in_del_date(String ord_in_del_date) {
        this.ord_in_del_date = ord_in_del_date;
    }

    public String getOrd_in_status() {
        return ord_in_status;
    }

    public void setOrd_in_status(String ord_in_status) {
        this.ord_in_status = ord_in_status;
    }

    public String getOrd_in_time_stamp() {
        return ord_in_time_stamp;
    }

    public void setOrd_in_time_stamp(String ord_in_time_stamp) {
        this.ord_in_time_stamp = ord_in_time_stamp;
    }
    
}