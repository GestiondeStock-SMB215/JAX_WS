package net.smb215.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.smb215.lib.CRUD;
import net.smb215.lib.Func;
import net.smb215.lib.QueryCriteria;

public class OrderInDetail {
    private final CRUD crud;
    private String ord_in_det_id;
    private String ord_in_det_ord_in_id;
    private String ord_in_det_prod_id;
    private String ord_in_det_qty;
    private String ord_in_det_time_stamp;

    public OrderInDetail() {
        crud = new CRUD("order_in_detail");
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
    
    public ArrayList<OrderInDetail> Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields, ArrayList<String> order) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields, order);
        ArrayList<OrderInDetail> result = new ArrayList<>();
        while (rs.next()) {
            OrderInDetail tmp = new OrderInDetail();
            tmp = (OrderInDetail) Func.castResultSetToObject(rs, tmp);
            result.add(tmp);
        }
        return result;
    }

    public String getOrd_in_det_id() {
        return ord_in_det_id;
    }

    public void setOrd_in_det_id(String ord_in_det_id) {
        this.ord_in_det_id = ord_in_det_id;
    }

    public String getOrd_in_det_ord_in_id() {
        return ord_in_det_ord_in_id;
    }

    public void setOrd_in_det_ord_in_id(String ord_in_det_ord_in_id) {
        this.ord_in_det_ord_in_id = ord_in_det_ord_in_id;
    }

    public String getOrd_in_det_prod_id() {
        return ord_in_det_prod_id;
    }

    public void setOrd_in_det_prod_id(String ord_in_det_prod_id) {
        this.ord_in_det_prod_id = ord_in_det_prod_id;
    }

    public String getOrd_in_det_qty() {
        return ord_in_det_qty;
    }

    public void setOrd_in_det_qty(String ord_in_det_qty) {
        this.ord_in_det_qty = ord_in_det_qty;
    }

    public String getOrd_in_det_time_stamp() {
        return ord_in_det_time_stamp;
    }

    public void setOrd_in_det_time_stamp(String ord_in_det_time_stamp) {
        this.ord_in_det_time_stamp = ord_in_det_time_stamp;
    }
    
}