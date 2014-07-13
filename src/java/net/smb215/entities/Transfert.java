package net.smb215.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.smb215.lib.CRUD;
import net.smb215.lib.Func;
import net.smb215.lib.QueryCriteria;

public class Transfert {
    private final CRUD crud;
    private String trans_id;
    private String trans_src_bra_id;
    private String trans_dest_bra_id;
    private String trans_send_date;
    private String trans_del_date;
    private String trans_status;
    private String trans_time_stamp;

    public Transfert() {
        crud = new CRUD("transfert");
    }
    
    public ArrayList<Transfert> Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields);
        ArrayList<Transfert> result = new ArrayList<>();
        while (rs.next()) {
            Transfert tmp = new Transfert();
            tmp = (Transfert) Func.castResultSetToObject(rs, tmp);
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

    public String getTrans_id() {
        return trans_id;
    }

    public void setTrans_id(String trans_id) {
        this.trans_id = trans_id;
    }

    public String getTrans_src_bra_id() {
        return trans_src_bra_id;
    }

    public void setTrans_src_bra_id(String trans_src_bra_id) {
        this.trans_src_bra_id = trans_src_bra_id;
    }

    public String getTrans_dest_bra_id() {
        return trans_dest_bra_id;
    }

    public void setTrans_dest_bra_id(String trans_dest_bra_id) {
        this.trans_dest_bra_id = trans_dest_bra_id;
    }

    public String getTrans_send_date() {
        return trans_send_date;
    }

    public void setTrans_send_date(String trans_send_date) {
        this.trans_send_date = trans_send_date;
    }

    public String getTrans_del_date() {
        return trans_del_date;
    }

    public void setTrans_del_date(String trans_del_date) {
        this.trans_del_date = trans_del_date;
    }

    public String getTrans_status() {
        return trans_status;
    }

    public void setTrans_status(String trans_status) {
        this.trans_status = trans_status;
    }

    public String getTrans_time_stamp() {
        return trans_time_stamp;
    }

    public void setTrans_time_stamp(String trans_time_stamp) {
        this.trans_time_stamp = trans_time_stamp;
    }
    
}