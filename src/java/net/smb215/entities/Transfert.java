package net.smb215.entities;
public class Transfert {
    private String trans_id;
    private String trans_src_bra_id;
    private String trans_dest_bra_id;
    private String trans_send_date;
    private String trans_del_date;
    private String trans_status;
    private String trans_time_stamp;

    public Transfert() {
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