package net.smb215.entities;
public class TransDetail{
    private String trans_det_id;
    private String trans_det_trans_id;
    private String trans_det_prod_id;
    private String trans_det_qty;
    private String trans_det_time_stamp;

    public TransDetail() {
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