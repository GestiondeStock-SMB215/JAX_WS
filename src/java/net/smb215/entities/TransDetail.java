package net.smb215.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.smb215.lib.CRUD;
import net.smb215.lib.Func;
import net.smb215.lib.QueryCriteria;

public class TransDetail{
    private final CRUD crud;
    private String trans_det_id;
    private String trans_det_trans_id;
    private String trans_det_prod_id;
    private String trans_det_qty;
    private String trans_det_time_stamp;

    public TransDetail() {
        crud = new CRUD("trans_detail");
    }
    
    public ArrayList<TransDetail> Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields, ArrayList<String> order) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields, order);
        ArrayList<TransDetail> result = new ArrayList<>();
        while (rs.next()) {
            TransDetail tmp = new TransDetail();
            tmp = (TransDetail) Func.castResultSetToObject(rs, tmp);
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

    public String getTrans_det_id() {
        return trans_det_id;
    }

    public void setTrans_det_id(String trans_det_id) {
        this.trans_det_id = trans_det_id;
    }

    public String getTrans_det_trans_id() {
        return trans_det_trans_id;
    }

    public void setTrans_det_trans_id(String trans_det_trans_id) {
        this.trans_det_trans_id = trans_det_trans_id;
    }

    public String getTrans_det_prod_id() {
        return trans_det_prod_id;
    }

    public void setTrans_det_prod_id(String trans_det_prod_id) {
        this.trans_det_prod_id = trans_det_prod_id;
    }

    public String getTrans_det_qty() {
        return trans_det_qty;
    }

    public void setTrans_det_qty(String trans_det_qty) {
        this.trans_det_qty = trans_det_qty;
    }

    public String getTrans_det_time_stamp() {
        return trans_det_time_stamp;
    }

    public void setTrans_det_time_stamp(String trans_det_time_stamp) {
        this.trans_det_time_stamp = trans_det_time_stamp;
    }
    
}