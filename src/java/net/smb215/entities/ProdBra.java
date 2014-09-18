package net.smb215.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.smb215.lib.CRUD;
import net.smb215.lib.Func;
import net.smb215.lib.QueryCriteria;
import net.smb215.lib.QueryOrder;

public class ProdBra {
    private final CRUD crud;
    private String pb_id;
    private String pb_prod_id;
    private String pb_bra_id;
    private String pb_qty;
    private String pb_time_stamp;

    public ProdBra() {
        crud = new CRUD("prod_bra");
    }
    
    public ArrayList<ProdBra> Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields, ArrayList<QueryOrder> order) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields, order);
        ArrayList<ProdBra> result = new ArrayList<>();
        while (rs.next()) {
            ProdBra tmp = new ProdBra();
            tmp = (ProdBra) Func.castResultSetToObject(rs, tmp);
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

    public String getPb_id() {
        return pb_id;
    }

    public void setPb_id(String pb_id) {
        this.pb_id = pb_id;
    }

    public String getPb_prod_id() {
        return pb_prod_id;
    }

    public void setPb_prod_id(String pb_prod_id) {
        this.pb_prod_id = pb_prod_id;
    }

    public String getPb_bra_id() {
        return pb_bra_id;
    }

    public void setPb_bra_id(String pb_bra_id) {
        this.pb_bra_id = pb_bra_id;
    }

    public String getPb_qty() {
        return pb_qty;
    }

    public void setPb_qty(String pb_qty) {
        this.pb_qty = pb_qty;
    }

    public String getPb_time_stamp() {
        return pb_time_stamp;
    }

    public void setPb_time_stamp(String pb_time_stamp) {
        this.pb_time_stamp = pb_time_stamp;
    }
    
}
