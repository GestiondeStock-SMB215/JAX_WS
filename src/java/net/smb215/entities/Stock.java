package net.smb215.entities;
public class Stock{
    private String stock_id;
    private String stock_prod_id;
    private String stock_bra_id;
    private String stock_qty;
    private String stock_time_stamp;

    public Stock() {
    }

    public String getStock_id() {
        return stock_id;
    }

    public void setStock_id(String stock_id) {
        this.stock_id = stock_id;
    }

    public String getStock_prod_id() {
        return stock_prod_id;
    }

    public void setStock_prod_id(String stock_prod_id) {
        this.stock_prod_id = stock_prod_id;
    }

    public String getStock_bra_id() {
        return stock_bra_id;
    }

    public void setStock_bra_id(String stock_bra_id) {
        this.stock_bra_id = stock_bra_id;
    }

    public String getStock_qty() {
        return stock_qty;
    }

    public void setStock_qty(String stock_qty) {
        this.stock_qty = stock_qty;
    }

    public String getStock_time_stamp() {
        return stock_time_stamp;
    }

    public void setStock_time_stamp(String stock_time_stamp) {
        this.stock_time_stamp = stock_time_stamp;
    }
    
}