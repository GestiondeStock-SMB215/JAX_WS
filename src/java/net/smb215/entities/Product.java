package net.smb215.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.smb215.lib.CRUD;
import net.smb215.lib.Func;
import net.smb215.lib.QueryCriteria;

public class Product {
    private final CRUD crud;
    private String prod_id;
    private String prod_cat_id;
    private String prod_sku;
    private String prod_upc;
    private String prod_name;
    private String prod_desc;
    private String prod_qty;
    private String prod_qty_per_unit;
    private String prod_color;
    private String prod_size;
    private String prod_weight;
    private String prod_sup_id;
    private String prod_status;
    private String prod_pic;
    private String prod_vend_id;
    private String prod_time_stamp;

    public Product() {
        crud = new CRUD("product");
    }
    
    public ArrayList<Product> Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields, ArrayList<String> order) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields, order);
        ArrayList<Product> result = new ArrayList<>();
        while (rs.next()) {
            Product tmp = new Product();
            tmp = (Product) Func.castResultSetToObject(rs, tmp);
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

    public String getProd_id() {
        return prod_id;
    }

    public void setProd_id(String prod_id) {
        this.prod_id = prod_id;
    }

    public String getProd_cat_id() {
        return prod_cat_id;
    }

    public void setProd_cat_id(String prod_cat_id) {
        this.prod_cat_id = prod_cat_id;
    }

    public String getProd_sku() {
        return prod_sku;
    }

    public void setProd_sku(String prod_sku) {
        this.prod_sku = prod_sku;
    }

    public String getProd_upc() {
        return prod_upc;
    }

    public void setProd_upc(String prod_upc) {
        this.prod_upc = prod_upc;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProd_desc() {
        return prod_desc;
    }

    public void setProd_desc(String prod_desc) {
        this.prod_desc = prod_desc;
    }

    public String getProd_qty() {
        return prod_qty;
    }

    public void setProd_qty(String prod_qty) {
        this.prod_qty = prod_qty;
    }

    public String getProd_qty_per_unit() {
        return prod_qty_per_unit;
    }

    public void setProd_qty_per_unit(String prod_qty_per_unit) {
        this.prod_qty_per_unit = prod_qty_per_unit;
    }

    public String getProd_color() {
        return prod_color;
    }

    public void setProd_color(String prod_color) {
        this.prod_color = prod_color;
    }

    public String getProd_size() {
        return prod_size;
    }

    public void setProd_size(String prod_size) {
        this.prod_size = prod_size;
    }

    public String getProd_weight() {
        return prod_weight;
    }

    public void setProd_weight(String prod_weight) {
        this.prod_weight = prod_weight;
    }

    public String getProd_sup_id() {
        return prod_sup_id;
    }

    public void setProd_sup_id(String prod_sup_id) {
        this.prod_sup_id = prod_sup_id;
    }

    public String getProd_status() {
        return prod_status;
    }

    public void setProd_status(String prod_status) {
        this.prod_status = prod_status;
    }

    public String getProd_pic() {
        return prod_pic;
    }

    public void setProd_pic(String prod_pic) {
        this.prod_pic = prod_pic;
    }

    public String getProd_vend_id() {
        return prod_vend_id;
    }

    public void setProd_vend_id(String prod_vend_id) {
        this.prod_vend_id = prod_vend_id;
    }

    public String getProd_time_stamp() {
        return prod_time_stamp;
    }

    public void setProd_time_stamp(String prod_time_stamp) {
        this.prod_time_stamp = prod_time_stamp;
    }
    
}