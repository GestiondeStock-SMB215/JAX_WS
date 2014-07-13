package net.smb215.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.smb215.lib.CRUD;
import net.smb215.lib.Func;
import net.smb215.lib.QueryCriteria;

public class Stock{
    private final CRUD crud;
    private String stock_id;
    private String stock_prod_id;
    private String stock_bra_id;
    private String stock_qty;
    private String stock_time_stamp;

    public Stock() {
        crud = new CRUD("stock");
    }
    
    public ArrayList<Stock> Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields);
        ArrayList<Stock> result = new ArrayList<>();
        while (rs.next()) {
            Stock tmp = new Stock();
            tmp = (Stock) Func.castResultSetToObject(rs, tmp);
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