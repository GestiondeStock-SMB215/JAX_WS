package net.smb215.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.smb215.lib.CRUD;
import net.smb215.lib.Func;
import net.smb215.lib.QueryCriteria;
import net.smb215.lib.QueryOrder;

public class OrderOutDetail {
    private final CRUD crud;
    private String ord_out_det_id;
    private String ord_out_det_ord_out_id;
    private String ord_out_det_prod_id;
    private String ord_out_det_qty;
    private String ord_out_det_time_stamp;

    public OrderOutDetail() {
        crud = new CRUD("order_out_detail");
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
    
    public ArrayList<OrderOutDetail> Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields, ArrayList<QueryOrder> order) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields, order);
        ArrayList<OrderOutDetail> result = new ArrayList<>();
        while (rs.next()) {
            OrderOutDetail tmp = new OrderOutDetail();
            tmp = (OrderOutDetail) Func.castResultSetToObject(rs, tmp);
            result.add(tmp);
        }
        return result;
    }

    public String getOrd_out_det_id() {
        return ord_out_det_id;
    }

    public void setOrd_out_det_id(String ord_out_det_id) {
        this.ord_out_det_id = ord_out_det_id;
    }

    public String getOrd_out_det_ord_out_id() {
        return ord_out_det_ord_out_id;
    }

    public void setOrd_out_det_ord_out_id(String ord_out_det_ord_out_id) {
        this.ord_out_det_ord_out_id = ord_out_det_ord_out_id;
    }

    public String getOrd_out_det_prod_id() {
        return ord_out_det_prod_id;
    }

    public void setOrd_out_det_prod_id(String ord_out_det_prod_id) {
        this.ord_out_det_prod_id = ord_out_det_prod_id;
    }

    public String getOrd_out_det_qty() {
        return ord_out_det_qty;
    }

    public void setOrd_out_det_qty(String ord_out_det_qty) {
        this.ord_out_det_qty = ord_out_det_qty;
    }

    public String getOrd_out_det_time_stamp() {
        return ord_out_det_time_stamp;
    }

    public void setOrd_out_det_time_stamp(String ord_out_det_time_stamp) {
        this.ord_out_det_time_stamp = ord_out_det_time_stamp;
    }
    
    
}