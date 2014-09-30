/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.smb215;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import net.smb215.entities.*;
import net.smb215.lib.*;
import net.smb215.lib.QueryCriteria.*;
import net.smb215.lib.QueryCriteria.Operand;
import net.smb215.lib.QueryOrder.Order;

@WebService(serviceName = "JAX_WS")
public class JAX_WS {
    

    //BRANCH//
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "aeBranch")
    public Integer aeBranch(
            @WebParam(name = "bra_id") String bra_id, 
            @WebParam(name = "bra_name") String bra_name, 
            @WebParam(name = "bra_cnt_id") String bra_cnt_id, 
            @WebParam(name = "bra_city") String bra_city,
            @WebParam(name = "bra_add_str") String bra_add_str,
            @WebParam(name = "bra_add_1") String bra_add_1,
            @WebParam(name = "bra_tel_1") String bra_tel_1, 
            @WebParam(name = "bra_tel_2") String bra_tel_2,
            @WebParam(name = "bra_fax") String bra_fax, 
            @WebParam(name = "bra_email") String bra_email
    ){
        Branch bra = new Branch();
        HashMap<String,String> fields = new HashMap<String,String>();       
        if(bra_id.equals("-1")){
            fields.put("bra_name",bra_name);
            fields.put("bra_cnt_id",bra_cnt_id);
            fields.put("bra_city", bra_city);
            fields.put("bra_add_str", bra_add_str);
            fields.put("bra_add_1", bra_add_1);
            fields.put("bra_tel_1", bra_tel_1);
            fields.put("bra_tel_2", bra_tel_2);
            fields.put("bra_fax", bra_fax);
            fields.put("bra_email", bra_email);
            fields.put("bra_time_stamp", Func.NOW());
            return bra.Create(fields);
        }
        else{
            fields.put("bra_name",bra_name);
            fields.put("bra_cnt_id",bra_cnt_id);
            fields.put("bra_city", bra_city);
            fields.put("bra_add_str", bra_add_str);
            fields.put("bra_add_1", bra_add_1);
            fields.put("bra_tel_1", bra_tel_1);
            fields.put("bra_tel_2", bra_tel_2);
            fields.put("bra_fax", bra_fax);
            fields.put("bra_email", bra_email);
            
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("bra_id", bra_id, Operand.EQUALS));
            return bra.Update(qc, fields);
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReadBranch")
    public ArrayList<Branch> ReadBranch(@WebParam(name = "bra_id") String bra_id) {
            Branch bra  = new Branch();
            ArrayList<Branch> bras = new ArrayList<Branch>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            if(!bra_id.equals("-1")){
                qc.add(new QueryCriteria("bra_id", bra_id, Operand.EQUALS));
            }
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           bras = bra.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(bras.isEmpty()){
                return null;
            }
        return bras;
    }
    
    /**
    * Web service operation
    */
    @WebMethod(operationName = "deleteBranch")
    public Integer deleteBranch(@WebParam(name = "bra_id") String bra_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("bra_id", bra_id, Operand.EQUALS));
        return new Branch().Delete(qc);
    }
    
    
    //CATEGORY//
    
 
    /**
     * Web service operation
     */
    @WebMethod(operationName = "aeCategory")
    public Integer aeCategory(
            @WebParam(name = "cat_id") String cat_id, 
            @WebParam(name = "cat_name") String cat_name, 
            @WebParam(name = "cat_desc") String cat_desc
    ){
        Category cat = new Category();
        HashMap<String,String> fields = new HashMap<String,String>();
        
        if(cat_id.equals("-1")){
            fields.put("cat_name",cat_name);
            fields.put("cat_desc", cat_desc);
            fields.put("cat_time_stamp", Func.NOW());
            return cat.Create(fields);
        }
        else{
            fields.put("cat_name",cat_name);
            fields.put("cat_desc", cat_desc);
            
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("cat_id", cat_id, Operand.EQUALS));
            return cat.Update(qc, fields);
        }
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReadCategory")
    public ArrayList<Category> ReadCategory(@WebParam(name = "cat_id") String cat_id) {
            Category cat  = new Category();
            ArrayList<Category> cats = new ArrayList<Category>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            if(!cat_id.equals("-1")){
                qc.add(new QueryCriteria("cat_id", cat_id, Operand.EQUALS));
            }
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           cats = cat.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(cats.isEmpty()){
                return null;
            }
        return cats;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteCategory")
    public Integer deleteCategory(@WebParam(name = "cat_id") String cat_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("cat_id", cat_id, Operand.EQUALS));
        return new Category().Delete(qc);
        
    }
    
    
    //COUNTRY//
     
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReadCountry")
    public ArrayList<Country> ReadCountry(@WebParam(name = "cnt_id") String cnt_id) {
            Country cnt  = new Country();
            ArrayList<Country> cnts = new ArrayList<Country>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            if(!cnt_id.equals("-1")){
                qc.add(new QueryCriteria("cnt_id", cnt_id, Operand.EQUALS));
            }
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           cnts = cnt.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(cnts.isEmpty()){
                return null;
            }
        return cnts;
    }
    
    
    //CUSTOMER//
   
 
    /**
     * Web service operation
     */
    @WebMethod(operationName = "aeCustomer")
    public Integer aeCustomer(
            @WebParam(name = "cust_id") String cust_id,  
            @WebParam(name = "cust_comp") String cust_comp,
            @WebParam(name = "cust_name") String cust_name,
            @WebParam(name = "cust_title") String cust_title,
            @WebParam(name = "cust_add_1") String cust_add_1,
            @WebParam(name = "cust_add_2") String cust_add_2,
            @WebParam(name = "cust_city") String cust_city,
            @WebParam(name = "cust_cnt_id") String cust_cnt_id,
            @WebParam(name = "cust_tel_1") String cust_tel_1,
            @WebParam(name = "cust_tel_2") String cust_tel_2,
            @WebParam(name = "cust_fax") String cust_fax,
            @WebParam(name = "cust_email") String cust_email,
            @WebParam(name = "cust_site") String cust_site,
            @WebParam(name = "cust_logo") String cust_logo
    ){
        Customer cust = new Customer();
        HashMap<String,String> fields = new HashMap<String,String>();
        
        if(cust_id.equals("-1")){
            fields.put("cust_comp", cust_comp);
            fields.put("cust_name", cust_name);
            fields.put("cust_title",cust_title);
            fields.put("cust_add_1", cust_add_1);
            fields.put("cust_add_2", cust_add_2);
            fields.put("cust_fax", cust_fax);
            fields.put("cust_city", cust_city);
            fields.put("cust_cnt_id", cust_cnt_id);
            fields.put("cust_tel_1", cust_tel_1);
            fields.put("cust_tel_2", cust_tel_2);
            fields.put("cust_fax", cust_fax);
            fields.put("cust_email", cust_email);
            fields.put("cust_site", cust_site);
            fields.put("cust_logo", cust_logo);
            fields.put("cust_time_stamp", Func.NOW());
            return cust.Create(fields);
        }
        else{
            fields.put("cust_comp", cust_comp);
            fields.put("cust_name", cust_name);
            fields.put("cust_title",cust_title);
            fields.put("cust_add_1", cust_add_1);
            fields.put("cust_add_2", cust_add_2);
            fields.put("cust_fax", cust_fax);
            fields.put("cust_city", cust_city);
            fields.put("cust_cnt_id", cust_cnt_id);
            fields.put("cust_tel_1", cust_tel_1);
            fields.put("cust_tel_2", cust_tel_2);
            fields.put("cust_fax", cust_fax);
            fields.put("cust_email", cust_email);
            fields.put("cust_site", cust_site);
            fields.put("cust_logo", cust_logo);
            
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("cust_id", cust_id, Operand.EQUALS));
            return cust.Update(qc, fields);
        }
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReadCustomer")
    public ArrayList<Customer> ReadCustomer(@WebParam(name = "cust_id") String cust_id) {
            Customer cust  = new Customer();
            ArrayList<Customer> custs = new ArrayList<Customer>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            if(!cust_id.equals("-1")){
                qc.add(new QueryCriteria("cust_id", cust_id, Operand.EQUALS));
            }
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           custs = cust.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(custs.isEmpty()){
                return null;
            }
        return custs;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteCustomer")
    public Integer deleteCustomer(@WebParam(name = "cust_id") String cust_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("cust_id", cust_id, Operand.EQUALS));
        return new Customer().Delete(qc);
        
    }
    
    
    //PAGE//
    
    
    
    /**
    * Web service operation
    */
    @WebMethod(operationName = "aePage")
    public Integer aePage(
            @WebParam(name = "page_id") String page_id, 
            @WebParam(name = "page_parent_id") String page_parent_id, 
            @WebParam(name = "page_name") String page_name,
            @WebParam(name = "page_url") String page_url, 
            @WebParam(name = "page_acl") String page_acl,
            @WebParam(name = "page_in_menu") String page_in_menu,
            @WebParam(name = "page_order") String page_order
    ){
        Page cat = new Page();
        HashMap<String,String> fields = new HashMap<String,String>();
        
        if(page_id.equals("-1")){
            fields.put("page_parent_id", page_parent_id);
            fields.put("page_name", page_name);
            fields.put("page_url", page_url);
            fields.put("page_acl", page_acl);
            fields.put("page_in_menu", page_in_menu);
            fields.put("page_order", page_order);
            fields.put("page_time_stamp", Func.NOW());
            return cat.Create(fields);
        }
        else{
            fields.put("page_parent_id", page_parent_id);
            fields.put("page_name", page_name);
            fields.put("page_url", page_url);
            fields.put("page_acl", page_acl);
            fields.put("page_in_menu", page_in_menu);
            fields.put("page_order", page_order);
            
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("page_id", page_id, Operand.EQUALS));
            return cat.Update(qc, fields);
        }
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReadPage")
    public ArrayList<Page> ReadPage(@WebParam(name = "page_id") String page_id) {
            Page page  = new Page();
            ArrayList<Page> pages = new ArrayList<Page>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            if(!page_id.equals("-1")){
                qc.add(new QueryCriteria("page_id", page_id, Operand.EQUALS));
            }
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           pages = page.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(pages.isEmpty()){
                return null;
            }
        return pages;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deletePage")
    public Integer deletePage(@WebParam(name = "page_id") String page_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("page_id", page_id, Operand.EQUALS));
        return new Page().Delete(qc);
    }
    
    
    //PRODUCT//
        
 
    /**
     * Web service operation
     */
    @WebMethod(operationName = "aeProduct")
    public Integer aeProduct(
            @WebParam(name = "prod_id") String prod_id,  
            @WebParam(name = "prod_cat_id") String prod_cat_id,
            @WebParam(name = "prod_sku") String prod_sku,
            @WebParam(name = "prod_upc") String prod_upc,
            @WebParam(name = "prod_name") String prod_name,
            @WebParam(name = "prod_desc") String prod_desc,
            @WebParam(name = "prod_qty") String prod_qty,
            @WebParam(name = "prod_color") String prod_color,
            @WebParam(name = "prod_size") String prod_size,
            @WebParam(name = "prod_weight") String prod_weight,
            @WebParam(name = "prod_sup_id") String prod_sup_id,
            @WebParam(name = "prod_status") String prod_status,
            @WebParam(name = "prod_pic") String prod_pic,
            @WebParam(name = "prod_vend_id") String prod_vend_id
    ){
        Product prod = new Product();
        HashMap<String,String> fields = new HashMap<String,String>();
        
        if(prod_id.equals("-1")){
            fields.put("prod_cat_id", prod_cat_id);
            fields.put("prod_sku", prod_sku);
            fields.put("prod_upc",prod_upc);
            fields.put("prod_name", prod_name);
            fields.put("prod_desc", prod_desc);
            fields.put("prod_qty", prod_qty);
            fields.put("prod_color", prod_color);
            fields.put("prod_size", prod_size);
            fields.put("prod_weight", prod_weight);
            fields.put("prod_sup_id", prod_sup_id);
            fields.put("prod_status", prod_status);
            fields.put("prod_pic", prod_pic);
            fields.put("prod_vend_id", prod_vend_id);
            fields.put("prod_time_stamp", Func.NOW());
            return prod.Create(fields);
        }
        else{
            fields.put("prod_id", prod_id);
            fields.put("prod_cat_id", prod_cat_id);
            fields.put("prod_sku", prod_sku);
            fields.put("prod_upc",prod_upc);
            fields.put("prod_name", prod_name);
            fields.put("prod_desc", prod_desc);
            fields.put("prod_qty", prod_qty);
            fields.put("prod_color", prod_color);
            fields.put("prod_size", prod_size);
            fields.put("prod_weight", prod_weight);
            fields.put("prod_sup_id", prod_sup_id);
            fields.put("prod_status", prod_status);
            fields.put("prod_pic", prod_pic);
            fields.put("prod_vend_id", prod_vend_id);
            fields.put("prod_time_stamp", Func.NOW());
            
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("prod_id", prod_id, Operand.EQUALS));
            return prod.Update(qc, fields);
        }
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReadProduct")
    public ArrayList<Product> ReadProduct(@WebParam(name = "prod_id") String prod_id) {
            Product prod  = new Product();
            ArrayList<Product> prods = new ArrayList<Product>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            if(!prod_id.equals("-1")){
                qc.add(new QueryCriteria("prod_id", prod_id, Operand.EQUALS));
            }
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           prods = prod.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(prods.isEmpty()){
                return null;
            }
        return prods;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteProduct")
    public Integer deleteProduct(@WebParam(name = "prod_id") String prod_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("prod_id", prod_id, Operand.EQUALS));
        return new Product().Delete(qc);
        
    }
    
    
    //ROLE//
    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "aeRole")
    public Integer aeRole(
            @WebParam(name = "role_id") String role_id, 
            @WebParam(name = "role_name") String role_name, 
            @WebParam(name = "role_desc") String role_desc
    ){
        Role role = new Role();
        HashMap<String,String> fields = new HashMap<String,String>();       
        if(role_id.equals("-1")){
            fields.put("role_name",role_name);
            fields.put("role_desc",role_desc);
            fields.put("role_time_stamp", Func.NOW());
            return role.Create(fields);             
        }
        else{
            fields.put("role_name",role_name);
            fields.put("role_desc",role_desc);     
            
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("role_id", role_id, Operand.EQUALS));
            return role.Update(qc, fields);
        }
    }    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReadRole")
    public ArrayList<Role> ReadRole(@WebParam(name = "role_id") String role_id) {
            Role role  = new Role();
            ArrayList<Role> roles = new ArrayList<Role>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            if(!role_id.equals("-1")){
                qc.add(new QueryCriteria("role_id", role_id, Operand.EQUALS));
            }
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           roles = role.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(roles.isEmpty()){
                return null;
            }
        return roles;
    }    

    
    /**
    * Web service operation
    */
    @WebMethod(operationName = "deleteRole")
    public Integer deleteRole(@WebParam(name = "role_id") String role_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("role_id", role_id, Operand.EQUALS));
        return new Role().Delete(qc);
        
    }
    

    //SHIPPER//
    
    
/**
     * Web service operation
     */
    @WebMethod(operationName = "aeShipper")
    public Integer aeShipper(
            @WebParam(name = "ship_id") String ship_id,
            @WebParam(name = "ship_name") String ship_name,
            @WebParam(name = "ship_type") String ship_type,
            @WebParam(name = "ship_add_1") String ship_add_1,
            @WebParam(name = "ship_add_2") String ship_add_2,
            @WebParam(name = "ship_tel_1") String ship_tel_1,
            @WebParam(name = "ship_tel_2") String ship_tel_2,
            @WebParam(name = "ship_fax") String ship_fax,
            @WebParam(name = "ship_email") String ship_email,
            @WebParam(name = "ship_taxable") String ship_taxable
    ){
        Shipper ship = new Shipper();
        HashMap<String,String> fields = new HashMap<String,String>();
        
        if(ship_id.equals("-1")){
            fields.put("ship_name", ship_name);
            fields.put("ship_type", ship_type);
            fields.put("ship_add_1", ship_add_1);
            fields.put("ship_add_2",ship_add_2);
            fields.put("ship_tel_1", ship_tel_1);
            fields.put("ship_tel_2", ship_tel_2);
            fields.put("ship_fax", ship_fax);
            fields.put("ship_email", ship_email);
            fields.put("ship_taxable", ship_taxable);
            fields.put("ship_time_stamp", Func.NOW());
            return ship.Create(fields);
        }
        else{
            fields.put("ship_name", ship_name);
            fields.put("ship_type", ship_type);
            fields.put("ship_add_1", ship_add_1);
            fields.put("ship_add_2",ship_add_2);
            fields.put("ship_tel_1", ship_tel_1);
            fields.put("ship_tel_2", ship_tel_2);
            fields.put("ship_fax", ship_fax);
            fields.put("ship_email", ship_email);
            fields.put("ship_taxable", ship_taxable);
            
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("ship_id", ship_id, Operand.EQUALS));
            return ship.Update(qc, fields);
        }
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReadShipper")
    public ArrayList<Shipper> ReadShipper(@WebParam(name = "ship_id") String ship_id) {
            Shipper ship  = new Shipper();
            ArrayList<Shipper> ships = new ArrayList<Shipper>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            if(!ship_id.equals("-1")){
                qc.add(new QueryCriteria("ship_id", ship_id, Operand.EQUALS));
            }
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           ships = ship.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(ships.isEmpty()){
                return null;
            }
        return ships;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteShipper")
    public Integer deleteShipper(@WebParam(name = "ship_id") String ship_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("ship_id", ship_id, Operand.EQUALS));
        return new Shipper().Delete(qc);
        
    }
    
    
    //STOCK//
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "aeStock")
    public Integer aeStock(
            @WebParam(name = "stock_id") String stock_id,
            @WebParam(name = "stock_prod_id") String stock_prod_id,
            @WebParam(name = "stock_bra_id") String stock_bra_id,
            @WebParam(name = "stock_qty") String stock_qty
    ){
        Stock stock = new Stock();
        HashMap<String,String> fields = new HashMap<String,String>();
        
        if(stock_id.equals("-1")){
            fields.put("stock_prod_id", stock_prod_id);
            fields.put("stock_bra_id", stock_bra_id);
            fields.put("stock_qty",stock_qty);
            fields.put("stock_time_stamp", Func.NOW());
            return stock.Create(fields);
        }
        else{
            fields.put("stock_prod_id", stock_prod_id);
            fields.put("stock_bra_id", stock_bra_id);
            fields.put("stock_qty",stock_qty);
            
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("stock_id", stock_id, Operand.EQUALS));
            return stock.Update(qc, fields);
        }
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReadStock")
    public ArrayList<Stock> ReadStock(@WebParam(name = "stock_id") String stock_id) {
            Stock stock  = new Stock();
            ArrayList<Stock> stocks = new ArrayList<Stock>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            if(!stock_id.equals("-1")){
                qc.add(new QueryCriteria("stock_id", stock_id, Operand.EQUALS));
            }
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           stocks = stock.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(stocks.isEmpty()){
                return null;
            }
        return stocks;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteStock")
    public Integer deleteStock(@WebParam(name = "stock_id") String stock_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("stock_id", stock_id, Operand.EQUALS));
        return new Stock().Delete(qc);
        
    }
    
    
    //SUPPLIER//
/**
     * Web service operation
     */
    @WebMethod(operationName = "aeSupplier")
    public Integer aeSupplier(
            @WebParam(name = "sup_id") String sup_id,  
            @WebParam(name = "sup_comp") String sup_comp,
            @WebParam(name = "sup_name") String sup_name,
            @WebParam(name = "sup_title") String sup_title,
            @WebParam(name = "sup_add_1") String sup_add_1,
            @WebParam(name = "sup_add_2") String sup_add_2,
            @WebParam(name = "sup_city") String sup_city,
            @WebParam(name = "sup_cnt_id") String sup_cnt_id,
            @WebParam(name = "sup_tel_1") String sup_tel_1,
            @WebParam(name = "sup_tel_2") String sup_tel_2,
            @WebParam(name = "sup_fax") String sup_fax, 
            @WebParam(name = "sup_email") String sup_email,
            @WebParam(name = "sup_site") String sup_site,
            @WebParam(name = "sup_logo") String sup_logo
    ){
        Supplier sup = new Supplier();
        HashMap<String,String> fields = new HashMap<String,String>();
        
        if(sup_id.equals("-1")){
            fields.put("sup_comp", sup_comp);
            fields.put("sup_name", sup_name);
            fields.put("sup_title",sup_title);
            fields.put("sup_add_1", sup_add_1);
            fields.put("sup_add_2", sup_add_2);
            fields.put("sup_city", sup_city);
            fields.put("sup_cnt_id", sup_cnt_id);
            fields.put("sup_tel_1", sup_tel_1);
            fields.put("sup_tel_2", sup_tel_2);
            fields.put("sup_fax", sup_fax);
            fields.put("sup_email", sup_email);
            fields.put("sup_site", sup_site);
            fields.put("sup_logo", sup_logo);
            fields.put("sup_time_stamp", Func.NOW());
            return sup.Create(fields);
        }
        else{
            fields.put("sup_comp", sup_comp);
            fields.put("sup_name", sup_name);
            fields.put("sup_title",sup_title);
            fields.put("sup_add_1", sup_add_1);
            fields.put("sup_add_2", sup_add_2);
            fields.put("sup_city", sup_city);
            fields.put("sup_cnt_id", sup_cnt_id);
            fields.put("sup_tel_1", sup_tel_1);
            fields.put("sup_tel_2", sup_tel_2);
            fields.put("sup_fax", sup_fax);
            fields.put("sup_email", sup_email);
            fields.put("sup_site", sup_site);
            fields.put("sup_logo", sup_logo);
            
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("sup_id", sup_id, Operand.EQUALS));
            return sup.Update(qc, fields);
        }
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReadSupplier")
    public ArrayList<Supplier> ReadSupplier(@WebParam(name = "sup_id") String sup_id) {
            Supplier sup  = new Supplier();
            ArrayList<Supplier> sups = new ArrayList<Supplier>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            if(!sup_id.equals("-1")){
                qc.add(new QueryCriteria("sup_id", sup_id, Operand.EQUALS));
            }
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           sups = sup.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(sups.isEmpty()){
                return null;
            }
        return sups;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteSupplier")
    public Integer deleteSupplier(@WebParam(name = "sup_id") String sup_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("sup_id", sup_id, Operand.EQUALS));
        return new Supplier().Delete(qc);
        
    }
    
    
    //TRACKING//
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "aeTracking")
    public Integer aeTracking(
            @WebParam(name = "track_id") String track_id, 
            @WebParam(name = "track_trans_id") String track_trans_id, 
            @WebParam(name = "track_ship_id") String track_ship_id
    ){
        Tracking track = new Tracking();
        HashMap<String,String> fields = new HashMap<String,String>();
        
        if(track_id.equals("-1")){
            fields.put("track_trans_id",track_trans_id);
            fields.put("track_ship_id",track_ship_id);
            fields.put("track_time_stamp", Func.NOW());
            return track.Create(fields);
        }
        else{
            fields.put("track_trans_id",track_trans_id);
            fields.put("track_ship_id",track_ship_id);
            
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("track_id", track_id, Operand.EQUALS));
            return track.Update(qc, fields);
        }
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReadTracking")
    public ArrayList<Tracking> ReadTracking(@WebParam(name = "track_id") String track_id) {
            Tracking track  = new Tracking();
            ArrayList<Tracking> tracks = new ArrayList<Tracking>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            if(!track_id.equals("-1")){
                qc.add(new QueryCriteria("track_id", track_id, Operand.EQUALS));
            }
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           tracks = track.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(tracks.isEmpty()){
                return null;
            }
        return tracks;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteTracking")
    public Integer deleteTracking(@WebParam(name = "track_id") String track_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("track_id", track_id, Operand.EQUALS));
        return new Tracking().Delete(qc);
        
    }

    
    //TRANSFERT//
    
    
/**
     * Web service operation
     */
    @WebMethod(operationName = "aeTransfert")
    public Integer aeTransfert(
            @WebParam(name = "trans_id") String trans_id,
            @WebParam(name = "trans_src_bra_id") String trans_src_bra_id,
            @WebParam(name = "trans_dest_bra_id") String trans_dest_bra_id,
            @WebParam(name = "trans_send_date") String trans_send_date,
            @WebParam(name = "trans_del_date") String trans_del_date,
            @WebParam(name = "trans_status") String trans_status
    ){
        Transfert trans = new Transfert();
        HashMap<String,String> fields = new HashMap<String,String>();
        
        if(trans_id.equals("-1")){
            fields.put("trans_src_bra_id", trans_src_bra_id);
            fields.put("trans_dest_bra_id", trans_dest_bra_id);
            fields.put("trans_send_date",trans_send_date);
            fields.put("trans_del_date", trans_del_date);
            fields.put("trans_status", trans_status);
            fields.put("trans_time_stamp", Func.NOW());
            return trans.Create(fields);
        }
        else{
            fields.put("trans_src_bra_id", trans_src_bra_id);
            fields.put("trans_dest_bra_id", trans_dest_bra_id);
            fields.put("trans_send_date",trans_send_date);
            fields.put("trans_del_date", trans_del_date);
            fields.put("trans_status", trans_status);
            
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("trans_id", trans_id, Operand.EQUALS));
            return trans.Update(qc, fields);
        }
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReadTransfert")
    public ArrayList<Transfert> ReadTransfert(@WebParam(name = "trans_id") String trans_id) {
            Transfert trans  = new Transfert();
            ArrayList<Transfert> transs = new ArrayList<Transfert>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            if(!trans_id.equals("-1")){
                qc.add(new QueryCriteria("trans_id", trans_id, Operand.EQUALS));
            }
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           transs = trans.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(transs.isEmpty()){
                return null;
            }
        return transs;
    }
    
     /**
     * Web service operation
     */
//    @WebMethod(operationName = "deleteTransfert")
//    public Integer deleteTransfert(@WebParam(name = "trans_id") String trans_id) {
//        
//        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
//        qc.add(new QueryCriteria("trans_id", trans_id, Operand.EQUALS));
//        return new Transfert().Delete(qc);
//        
//    }
    
    
    //USER//
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "aeUser")
    public Integer aeUser(
            @WebParam(name = "user_id") String user_id, 
            @WebParam(name = "user_role_id") String user_role_id, 
            @WebParam(name = "user_name") String user_name, 
            @WebParam(name = "user_username") String user_username, 
            @WebParam(name = "user_password") String user_password, 
            @WebParam(name = "user_email") String user_email, 
            @WebParam(name = "user_status") String user_status
    ){
        User user = new User();
        HashMap<String,String> fields = new HashMap<String,String>();
        
        if(user_id.equals("-1")){
            fields.put("user_role_id", user_role_id);
            fields.put("user_name",user_name);
            fields.put("user_username", user_username);
            fields.put("user_password", user_password);
            fields.put("user_email", user_email);
            fields.put("user_last_login",  Func.NOW());
            fields.put("user_status", user_status);
            fields.put("user_time_stamp", Func.NOW());
            return user.Create(fields);
        }
        else{
            fields.put("user_role_id", user_role_id);
            fields.put("user_name",user_name);
            fields.put("user_username", user_username);
            if(!user_password.equals("6bb61e3b7bce0931da574d19d1d82c88")){
                fields.put("user_password", user_password);
            }
            fields.put("user_email", user_email);
            fields.put("user_status", user_status);
            
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("user_id", user_id, Operand.EQUALS));
            return user.Update(qc, fields);
        }
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReadUser")
    public ArrayList<User> ReadUser(@WebParam(name = "user_id") String user_id) {
            User user  = new User();
            ArrayList<User> users = new ArrayList<User>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            if(!user_id.equals("-1")){
                qc.add(new QueryCriteria("user_id", user_id, Operand.EQUALS));
            }
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           users = user.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(users.isEmpty()){
                return null;
            }
        return users;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteUser")
    public Integer deleteUser(@WebParam(name = "user_id") String user_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("user_id", user_id, Operand.EQUALS));
        return new User().Delete(qc);
        
    }
    
    
    //TRANSFERT DETAIL//
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "aeTransDetail")
    public Integer aeTransDetail(
            @WebParam(name = "trans_det_id") String trans_det_id,  
            @WebParam(name = "trans_det_trans_id") String trans_det_trans_id,
            @WebParam(name = "trans_det_prod_id") String trans_det_prod_id,
            @WebParam(name = "trans_det_qty") String trans_det_qty
    ){
        TransDetail trans_det = new TransDetail();
        HashMap<String,String> fields = new HashMap<String,String>();
        
        if(trans_det_id.equals("-1")){
            HashMap<String,String> brasIds = new HashMap<>();
            brasIds = Func.getBrasIds(trans_det_trans_id);
            
            String trans_src_bra_id = brasIds.get("trans_src_bra_id");
            String trans_dest_bra_id = brasIds.get("trans_dest_bra_id");
            
            int srcProdBraQty = Func.updateProdBraQty(trans_det_prod_id, trans_src_bra_id, trans_det_qty, "sub");
            int destProdBraQty = Func.updateProdBraQty(trans_det_prod_id, trans_dest_bra_id, trans_det_qty, "add");
            
            fields.put("trans_det_trans_id", trans_det_trans_id);
            fields.put("trans_det_prod_id",trans_det_prod_id);
            fields.put("trans_det_qty", trans_det_qty);
            fields.put("trans_det_time_stamp", Func.NOW());
            return trans_det.Create(fields);
        }
        else{
            // TransferDetail is denied
            return null; 
            
//            fields.put("trans_det_trans_id", trans_det_trans_id);
//            fields.put("trans_det_prod_id",trans_det_prod_id);
//            fields.put("trans_det_qty", trans_det_qty);
//            
//            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
//            qc.add(new QueryCriteria("trans_det_id", trans_det_id, Operand.EQUALS));
//            return trans_det.Update(qc, fields);
        }
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReadTransDetail")
    public ArrayList<TransDetail> ReadTransDetail(@WebParam(name = "trans_det_id") String trans_det_id) {
            TransDetail trans_det  = new TransDetail();
            ArrayList<TransDetail> trans_dets = new ArrayList<TransDetail>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            if(!trans_det_id.equals("-1")){
                qc.add(new QueryCriteria("trans_det_id", trans_det_id, Operand.EQUALS));
            }
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           trans_dets = trans_det.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(trans_dets.isEmpty()){
                return null;
            }
        return trans_dets;
    }
    
     /**
     * Web service operation
     */
//    @WebMethod(operationName = "deleteTransDetail")
//    public Integer deleteTransDetail(@WebParam(name = "trans_det_id") String trans_det_id) {
//        
//        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
//        qc.add(new QueryCriteria("trans_det_id", trans_det_id, Operand.EQUALS));
//        return new TransDetail().Delete(qc);
//        
//    }
    
    /**
    * Web service operation
     * @param user_username
     * @param user_password
     * @return 
     * @throws java.sql.SQLException
    */
    @WebMethod(operationName = "getUserByUsername")
    public User getUserByUsername(@WebParam(name = "user_username") String user_username, @WebParam(name = "user_password") String user_password){
        try {
            User user = new User();
            ArrayList<User> users = new ArrayList<>();
            
            ArrayList<QueryCriteria> qc = new ArrayList<>();
            qc.add(new QueryCriteria("user_username", user_username, Operand.EQUALS));
            qc.add(new QueryCriteria("user_password", user_password, Operand.EQUALS));
            
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
            users = user.Read(qc, fields, order);
            if(users.isEmpty()){
                user.setUser_id("0");
                return user;
            }
        return users.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    //INVOICE IN//
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "aeInvoiceIn")
    public Integer aeInvoiceIn(
            @WebParam(name = "inv_in_id") String inv_in_id,  
            @WebParam(name = "inv_in_ord_in_id") String inv_in_ord_in_id,
            @WebParam(name = "inv_in_cust_id") String inv_in_cust_id,
            @WebParam(name = "inv_in_date") String inv_in_date,
            @WebParam(name = "inv_in_num") String inv_in_num,
            @WebParam(name = "inv_in_total") String inv_in_total,
            @WebParam(name = "inv_in_tax") String inv_in_tax,
            @WebParam(name = "inv_in_disc") String inv_in_disc,
            @WebParam(name = "inv_in_total_due") String inv_in_total_due,
            @WebParam(name = "inv_in_status") String inv_in_status,
            @WebParam(name = "inv_in_att") String inv_in_att
    ){
        InvoiceIn inv_in = new InvoiceIn();
        HashMap<String,String> fields = new HashMap<String,String>();
        
        if(inv_in_id.equals("-1")){
            fields.put("inv_in_ord_in_id", inv_in_ord_in_id);
            fields.put("inv_in_cust_id", inv_in_cust_id);
            fields.put("inv_in_date",inv_in_date);
            fields.put("inv_in_num", inv_in_num);
            fields.put("inv_in_total", inv_in_total);
            fields.put("inv_in_tax", inv_in_tax);
            fields.put("inv_in_disc", inv_in_disc);
            fields.put("inv_in_total_due", inv_in_total_due);
            fields.put("inv_in_status", inv_in_status);
            fields.put("inv_in_att", inv_in_att);
            fields.put("inv_in_time_stamp", Func.NOW());
            return inv_in.Create(fields);
        }
        else{
            fields.put("inv_in_ord_in_id", inv_in_ord_in_id);
            fields.put("inv_in_cust_id", inv_in_cust_id);
            fields.put("inv_in_date",inv_in_date);
            fields.put("inv_in_num", inv_in_num);
            fields.put("inv_in_total", inv_in_total);
            fields.put("inv_in_tax", inv_in_tax);
            fields.put("inv_in_disc", inv_in_disc);
            fields.put("inv_in_total_due", inv_in_total_due);
            fields.put("inv_in_status", inv_in_status);
            fields.put("inv_in_att", inv_in_att);
            
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("inv_in_id", inv_in_id, Operand.EQUALS));
            return inv_in.Update(qc, fields);
        }
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReadInvoiceIn")
    public ArrayList<InvoiceIn> ReadInvoiceIn(@WebParam(name = "inv_in_id") String inv_in_id) {
            InvoiceIn inv_in  = new InvoiceIn();
            ArrayList<InvoiceIn> inv_ins = new ArrayList<InvoiceIn>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            if(!inv_in_id.equals("-1")){
                qc.add(new QueryCriteria("inv_in_id", inv_in_id, Operand.EQUALS));
            }
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           inv_ins = inv_in.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(inv_ins.isEmpty()){
                return null;
            }
        return inv_ins;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteInvoiceIn")
    public Integer deleteInvoiceIn(@WebParam(name = "inv_in_id") String inv_in_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("inv_in_id", inv_in_id, Operand.EQUALS));
        return new InvoiceIn().Delete(qc);
        
    }
    
    
    //INVOICE OUT//
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "aeInvoiceOut")
    public Integer aeInvoiceOut(
            @WebParam(name = "inv_out_id") String inv_out_id,  
            @WebParam(name = "inv_out_ord_out_id") String inv_out_ord_out_id,
            @WebParam(name = "inv_out_sup_id") String inv_out_sup_id,
            @WebParam(name = "inv_out_date") String inv_out_date,
            @WebParam(name = "inv_out_num") String inv_out_num,
            @WebParam(name = "inv_out_total") String inv_out_total,
            @WebParam(name = "inv_out_tax") String inv_out_tax,
            @WebParam(name = "inv_out_disc") String inv_out_disc,
            @WebParam(name = "inv_out_total_due") String inv_out_total_due,
            @WebParam(name = "inv_out_status") String inv_out_status,
            @WebParam(name = "inv_out_att") String inv_out_att
    ){
        InvoiceOut inv_out = new InvoiceOut();
        HashMap<String,String> fields = new HashMap<String,String>();
        
        if(inv_out_id.equals("-1")){
            fields.put("inv_out_ord_out_id", inv_out_ord_out_id);
            fields.put("inv_out_sup_id", inv_out_sup_id);
            fields.put("inv_out_date",inv_out_date);
            fields.put("inv_out_num", inv_out_num);
            fields.put("inv_out_total", inv_out_total);
            fields.put("inv_out_tax", inv_out_tax);
            fields.put("inv_out_disc", inv_out_disc);
            fields.put("inv_out_total_due", inv_out_total_due);
            fields.put("inv_out_status", inv_out_status);
            fields.put("inv_out_att", inv_out_att);
            fields.put("inv_out_time_stamp", Func.NOW());
            return inv_out.Create(fields);
        }
        else{
            fields.put("inv_out_ord_out_id", inv_out_ord_out_id);
            fields.put("inv_out_sup_id", inv_out_sup_id);
            fields.put("inv_out_date",inv_out_date);
            fields.put("inv_out_num", inv_out_num);
            fields.put("inv_out_total", inv_out_total);
            fields.put("inv_out_tax", inv_out_tax);
            fields.put("inv_out_disc", inv_out_disc);
            fields.put("inv_out_total_due", inv_out_total_due);
            fields.put("inv_out_status", inv_out_status);
            fields.put("inv_out_att", inv_out_att);
                        
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("inv_out_id", inv_out_id, Operand.EQUALS));
            return inv_out.Update(qc, fields);
        }
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReadInvoiceOut")
    public ArrayList<InvoiceOut> ReadInvoiceOut(@WebParam(name = "inv_out_id") String inv_out_id) {
            InvoiceOut inv_out  = new InvoiceOut();
            ArrayList<InvoiceOut> inv_outs = new ArrayList<InvoiceOut>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            if(!inv_out_id.equals("-1")){
                qc.add(new QueryCriteria("inv_out_id", inv_out_id, Operand.EQUALS));
            }
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           inv_outs = inv_out.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(inv_outs.isEmpty()){
                return null;
            }
        return inv_outs;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteInvoiceOut")
    public Integer deleteInvoiceOut(@WebParam(name = "inv_out_id") String inv_out_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("inv_out_id", inv_out_id, Operand.EQUALS));
        return new InvoiceOut().Delete(qc);
        
    }

    
    //ORDER IN//
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "aeOrderIn")
    public Integer aeOrderIn(
            @WebParam(name = "ord_in_id") String ord_in_id,  
            @WebParam(name = "ord_in_cust_id") String ord_in_cust_id,
            @WebParam(name = "ord_in_date") String ord_in_date,
            @WebParam(name = "ord_in_del_date") String ord_in_del_date,
            @WebParam(name = "ord_in_status") String ord_in_status
    ){
        OrderIn ord_in = new OrderIn();
        HashMap<String,String> fields = new HashMap<String,String>();
        
        if(ord_in_id.equals("-1")){
            fields.put("ord_in_cust_id", ord_in_cust_id);
            fields.put("ord_in_date",ord_in_date);
            fields.put("ord_in_del_date", ord_in_del_date);
            fields.put("ord_in_status", ord_in_status);
            fields.put("ord_in_time_stamp", Func.NOW());
            return ord_in.Create(fields);
        }
        else{
            fields.put("ord_in_cust_id", ord_in_cust_id);
            fields.put("ord_in_date",ord_in_date);
            fields.put("ord_in_del_date", ord_in_del_date);
            fields.put("ord_in_status", ord_in_status);
            
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("ord_in_id", ord_in_id, Operand.EQUALS));
            return ord_in.Update(qc, fields);
        }
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReadOrderIn")
    public ArrayList<OrderIn> ReadOrderIn(@WebParam(name = "ord_in_id") String ord_in_id) {
            OrderIn ord_in  = new OrderIn();
            ArrayList<OrderIn> ord_ins = new ArrayList<OrderIn>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            if(!ord_in_id.equals("-1")){
                qc.add(new QueryCriteria("ord_in_id", ord_in_id, Operand.EQUALS));
            }
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           ord_ins = ord_in.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(ord_ins.isEmpty()){
                return null;
            }
        return ord_ins;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteOrderIn")
    public Integer deleteOrderIn(@WebParam(name = "ord_in_id") String ord_in_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("ord_in_id", ord_in_id, Operand.EQUALS));
        return new OrderIn().Delete(qc);
        
    }
    
    
    //ORDER OUT//
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "aeOrderOut")
    public Integer aeOrderOut(
            @WebParam(name = "ord_out_id") String ord_out_id,  
            @WebParam(name = "ord_out_sup_id") String ord_out_sup_id,
            @WebParam(name = "ord_out_date") String ord_out_date,
            @WebParam(name = "ord_out_del_date") String ord_out_del_date,
            @WebParam(name = "ord_out_status") String ord_out_status
    ){
        OrderOut ord_out = new OrderOut();
        HashMap<String,String> fields = new HashMap<String,String>();
        
        if(ord_out_id.equals("-1")){
            fields.put("ord_out_sup_id", ord_out_sup_id);
            fields.put("ord_out_sup_id", ord_out_sup_id);
            fields.put("ord_out_date",ord_out_date);
            fields.put("ord_out_del_date", ord_out_del_date);
            fields.put("ord_out_status", ord_out_status);
            fields.put("ord_out_time_stamp", Func.NOW());
            return ord_out.Create(fields);
        }
        else{
            fields.put("ord_out_sup_id", ord_out_sup_id);
            fields.put("ord_out_sup_id", ord_out_sup_id);
            fields.put("ord_out_date",ord_out_date);
            fields.put("ord_out_del_date", ord_out_del_date);
            fields.put("ord_out_status", ord_out_status);
            
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("ord_out_id", ord_out_id, Operand.EQUALS));
            return ord_out.Update(qc, fields);
        }
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReadOrderOut")
    public ArrayList<OrderOut> ReadOrderOut(@WebParam(name = "ord_out_id") String ord_out_id) {
            OrderOut ord_out  = new OrderOut();
            ArrayList<OrderOut> ord_outs = new ArrayList<OrderOut>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            if(!ord_out_id.equals("-1")){
                qc.add(new QueryCriteria("ord_out_id", ord_out_id, Operand.EQUALS));
            }
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           ord_outs = ord_out.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(ord_outs.isEmpty()){
                return null;
            }
        return ord_outs;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteOrderOut")
    public Integer deleteOrderOut(@WebParam(name = "ord_out_id") String ord_out_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("ord_out_id", ord_out_id, Operand.EQUALS));
        return new OrderOut().Delete(qc);
        
    }
    
    
    //INVOICE IN DETAIL//
    
    
/**
     * Web service operation
     */
    @WebMethod(operationName = "aeInvoiceInDetail")
    public Integer aeInvoiceInDetail(
            @WebParam(name = "inv_in_det_id") String inv_in_det_id,  
            @WebParam(name = "inv_in_det_inv_id") String inv_in_det_inv_id,
            @WebParam(name = "inv_in_det_prod_id") String inv_in_det_prod_id,
            @WebParam(name = "inv_in_det_qty") String inv_in_det_qty,
            @WebParam(name = "inv_in_det_up") String inv_in_det_up,
            @WebParam(name = "inv_in_det_total") String inv_in_det_total,
            @WebParam(name = "inv_in_det_disc") String inv_in_det_disc,
            @WebParam(name = "inv_in_det_total_due") String inv_in_det_total_due
    ){
        InvoiceInDetail inv_in_det = new InvoiceInDetail();
        HashMap<String,String> fields = new HashMap<String,String>();
        
        if(inv_in_det_id.equals("-1")){
            fields.put("inv_in_det_inv_id", inv_in_det_inv_id);
            fields.put("inv_in_det_prod_id", inv_in_det_prod_id);
            fields.put("inv_in_det_qty",inv_in_det_qty);
            fields.put("inv_in_det_up", inv_in_det_up);
            fields.put("inv_in_det_total", inv_in_det_total);
            fields.put("inv_in_det_disc", inv_in_det_disc);
            fields.put("inv_in_det_total_due", inv_in_det_total_due);
            fields.put("inv_in_det_time_stamp", Func.NOW());
            return inv_in_det.Create(fields);
        }
        else{
            fields.put("inv_in_det_inv_id", inv_in_det_inv_id);
            fields.put("inv_in_det_prod_id", inv_in_det_prod_id);
            fields.put("inv_in_det_qty",inv_in_det_qty);
            fields.put("inv_in_det_up", inv_in_det_up);
            fields.put("inv_in_det_total", inv_in_det_total);
            fields.put("inv_in_det_disc", inv_in_det_disc);
            fields.put("inv_in_det_total_due", inv_in_det_total_due);
            
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("inv_in_det_id", inv_in_det_id, Operand.EQUALS));
            return inv_in_det.Update(qc, fields);
        }
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReadInvoiceInDetail")
    public ArrayList<InvoiceInDetail> ReadInvoiceInDetail(@WebParam(name = "inv_in_det_id") String inv_in_det_id) {
            InvoiceInDetail inv_in_det  = new InvoiceInDetail();
            ArrayList<InvoiceInDetail> inv_in_dets = new ArrayList<InvoiceInDetail>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            if(!inv_in_det_id.equals("-1")){
                qc.add(new QueryCriteria("inv_in_det_id", inv_in_det_id, Operand.EQUALS));
            }
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           inv_in_dets = inv_in_det.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(inv_in_dets.isEmpty()){
                return null;
            }
        return inv_in_dets;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteInvoiceInDetail")
    public Integer deleteInvoiceInDetail(@WebParam(name = "inv_in_det_id") String inv_in_det_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("inv_in_det_id", inv_in_det_id, Operand.EQUALS));
        return new InvoiceInDetail().Delete(qc);
        
    }    
    
    
    //INVOICE OUT DETAIL//
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "aeInvoiceOutDetail")
    public Integer aeInvoiceOutDetail(
            @WebParam(name = "inv_out_det_id") String inv_out_det_id,  
            @WebParam(name = "inv_out_det_inv_id") String inv_out_det_inv_id,
            @WebParam(name = "inv_out_det_prod_id") String inv_out_det_prod_id,
            @WebParam(name = "inv_out_det_qty") String inv_out_det_qty,
            @WebParam(name = "inv_out_det_up") String inv_out_det_up,
            @WebParam(name = "inv_out_det_total") String inv_out_det_total,
            @WebParam(name = "inv_out_det_disc") String inv_out_det_disc,
            @WebParam(name = "inv_out_det_total_due") String inv_out_det_total_due
    ){
        InvoiceOutDetail inv_out_det = new InvoiceOutDetail();
        HashMap<String,String> fields = new HashMap<String,String>();
        
        if(inv_out_det_id.equals("-1")){
            fields.put("inv_out_det_inv_id", inv_out_det_inv_id);
            fields.put("inv_out_det_prod_id", inv_out_det_prod_id);
            fields.put("inv_out_det_qty",inv_out_det_qty);
            fields.put("inv_out_det_up", inv_out_det_up);
            fields.put("inv_out_det_total", inv_out_det_total);
            fields.put("inv_out_det_disc", inv_out_det_disc);
            fields.put("inv_out_det_total_due", inv_out_det_total_due);
            fields.put("inv_out_det_time_stamp", Func.NOW());
            return inv_out_det.Create(fields);
        }
        else{
            fields.put("inv_out_det_inv_id", inv_out_det_inv_id);
            fields.put("inv_out_det_prod_id", inv_out_det_prod_id);
            fields.put("inv_out_det_qty",inv_out_det_qty);
            fields.put("inv_out_det_up", inv_out_det_up);
            fields.put("inv_out_det_total", inv_out_det_total);
            fields.put("inv_out_det_disc", inv_out_det_disc);
            fields.put("inv_out_det_total_due", inv_out_det_total_due);
            
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("inv_out_det_id", inv_out_det_id, Operand.EQUALS));
            return inv_out_det.Update(qc, fields);
        }
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReadInvoiceOutDetail")
    public ArrayList<InvoiceOutDetail> ReadInvoiceOutDetail(@WebParam(name = "inv_out_det_id") String inv_out_det_id) {
            InvoiceOutDetail inv_out_det  = new InvoiceOutDetail();
            ArrayList<InvoiceOutDetail> inv_out_dets = new ArrayList<InvoiceOutDetail>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            if(!inv_out_det_id.equals("-1")){
                qc.add(new QueryCriteria("inv_out_det_id", inv_out_det_id, Operand.EQUALS));
            }
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           inv_out_dets = inv_out_det.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(inv_out_dets.isEmpty()){
                return null;
            }
        return inv_out_dets;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteInvoiceOutDetail")
    public Integer deleteInvoiceOutDetail(@WebParam(name = "inv_out_det_id") String inv_out_det_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("inv_out_det_id", inv_out_det_id, Operand.EQUALS));
        return new InvoiceOutDetail().Delete(qc);
        
    }    
        
    
    //ORDER IN DETAIL//
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "aeOrderInDetail")
    public Integer aeOrderInDetail(
            @WebParam(name = "ord_in_det_id") String ord_in_det_id,  
            @WebParam(name = "ord_in_det_ord_in_id") String ord_in_det_ord_in_id,
            @WebParam(name = "ord_in_det_prod_id") String ord_in_det_prod_id,
            @WebParam(name = "ord_in_det_qty") String ord_in_det_qty
    ){
        OrderInDetail ord_in_det = new OrderInDetail();
        HashMap<String,String> fields = new HashMap<String,String>();
        
        if(ord_in_det_id.equals("-1")){
            fields.put("ord_in_det_ord_in_id", ord_in_det_ord_in_id);
            fields.put("ord_in_det_ord_in_id", ord_in_det_ord_in_id);
            fields.put("ord_in_det_prod_id",ord_in_det_prod_id);
            fields.put("ord_in_det_qty", ord_in_det_qty);
            fields.put("ord_in_det_time_stamp", Func.NOW());
            return ord_in_det.Create(fields);
        }
        else{
            fields.put("ord_in_det_ord_in_id", ord_in_det_ord_in_id);
            fields.put("ord_in_det_ord_in_id", ord_in_det_ord_in_id);
            fields.put("ord_in_det_prod_id",ord_in_det_prod_id);
            fields.put("ord_in_det_qty", ord_in_det_qty);
            
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("ord_in_det_id", ord_in_det_id, Operand.EQUALS));
            return ord_in_det.Update(qc, fields);
        }
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReadOrderInDetail")
    public ArrayList<OrderInDetail> ReadOrderInDetail(@WebParam(name = "ord_in_det_id") String ord_in_det_id) {
            OrderInDetail ord_in_det  = new OrderInDetail();
            ArrayList<OrderInDetail> ord_in_dets = new ArrayList<OrderInDetail>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            if(!ord_in_det_id.equals("-1")){
                qc.add(new QueryCriteria("ord_in_det_id", ord_in_det_id, Operand.EQUALS));
            }
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           ord_in_dets = ord_in_det.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(ord_in_dets.isEmpty()){
                return null;
            }
        return ord_in_dets;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteOrderInDetail")
    public Integer deleteOrderInDetail(@WebParam(name = "ord_in_det_id") String ord_in_det_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("ord_in_det_id", ord_in_det_id, Operand.EQUALS));
        return new OrderInDetail().Delete(qc);
        
    }       
    
    
    
    //ORDER OUT DETAIL//
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "aeOrderOutDetail")
    public Integer aeOrderOutDetail(
            @WebParam(name = "ord_out_det_id") String ord_out_det_id,  
            @WebParam(name = "ord_out_det_ord_out_id") String ord_out_det_ord_out_id,
            @WebParam(name = "ord_out_det_prod_id") String ord_out_det_prod_id,
            @WebParam(name = "ord_out_det_qty") String ord_out_det_qty
    ){
        OrderOutDetail ord_out_det = new OrderOutDetail();
        HashMap<String,String> fields = new HashMap<String,String>();
        
        if(ord_out_det_id.equals("-1")){
            fields.put("ord_out_det_ord_out_id", ord_out_det_ord_out_id);
            fields.put("ord_out_det_ord_out_id", ord_out_det_ord_out_id);
            fields.put("ord_out_det_prod_id",ord_out_det_prod_id);
            fields.put("ord_out_det_qty", ord_out_det_qty);
            fields.put("ord_out_det_time_stamp", Func.NOW());
            return ord_out_det.Create(fields);
        }
        else{
            fields.put("ord_out_det_ord_out_id", ord_out_det_ord_out_id);
            fields.put("ord_out_det_ord_out_id", ord_out_det_ord_out_id);
            fields.put("ord_out_det_prod_id",ord_out_det_prod_id);
            fields.put("ord_out_det_qty", ord_out_det_qty);
            
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("ord_out_det_id", ord_out_det_id, Operand.EQUALS));
            return ord_out_det.Update(qc, fields);
        }
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReadOrderOutDetail")
    public ArrayList<OrderOutDetail> ReadOrderOutDetail(@WebParam(name = "ord_out_det_id") String ord_out_det_id) {
            OrderOutDetail ord_out_det  = new OrderOutDetail();
            ArrayList<OrderOutDetail> ord_out_dets = new ArrayList<OrderOutDetail>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            if(!ord_out_det_id.equals("-1")){
                qc.add(new QueryCriteria("ord_out_det_id", ord_out_det_id, Operand.EQUALS));
            }
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           ord_out_dets = ord_out_det.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(ord_out_dets.isEmpty()){
                return null;
            }
        return ord_out_dets;
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteOrderOutDetail")
    public Integer deleteOrderOutDetail(@WebParam(name = "ord_out_det_id") String ord_out_det_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("ord_out_det_id", ord_out_det_id, Operand.EQUALS));
        return new OrderOutDetail().Delete(qc);
        
    }    
    
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkUserNameValidity")
    public Boolean checkUserNameValidity(@WebParam(name = "user_username") String user_username) {
        try {
            User user = new User();
            ArrayList<User> users = new ArrayList<User>();
            
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("user_username", user_username, Operand.EQUALS));
            
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
            users = user.Read(qc, fields, order);
            
            return (users.size() == 0);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkUserEmailValidity")
    public Boolean checkUserEmailValidity(@WebParam(name = "user_email") String user_email) {
        try {
            User user = new User();
            ArrayList<User> users = new ArrayList<User>();
            
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("user_email", user_email, Operand.EQUALS));
            
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
            users = user.Read(qc, fields, order);
            
            return (users.size() == 0);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

        /**
     * Web service operation
     */
    @WebMethod(operationName = "updateUserLastLogin")
    public Integer updateUserLastLogin(@WebParam(name = "user_id") String user_id) {
        User user = new User();
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("user_id", user_id, Operand.EQUALS));
        
        HashMap<String,String> fields = new HashMap<String,String>();
        fields.put("user_last_login", Func.NOW());
        
        return user.Update(qc,fields);
    }


    @WebMethod(operationName = "getCountryNiceName")
    public String getCountryNiceName(@WebParam(name = "cnt_id") String cnt_id) {
        Country country = new Country();
        ArrayList<Country> countries = new ArrayList<Country>();
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        
        qc.add(new QueryCriteria("cnt_id", cnt_id, Operand.EQUALS));
        
        ArrayList<String> fields = new ArrayList<String>();
        fields.add("cnt_nicename");
        
        ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
                
        try {
           countries = country.Read(qc,fields,order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(countries.isEmpty()){
                return null;
            }
        return countries.get(0).getCnt_nicename();
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPages")
    public ArrayList<Page> getPages(@WebParam(name = "user_role_id") String user_role_id) {
        Page page  = new Page();
        ArrayList<Page> pages = new ArrayList<Page>();
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        
        qc.add(new QueryCriteria("page_acl", user_role_id, Operand.LARGERTHANOREQUAL));
        
        ArrayList<String> fields = new ArrayList<String>();
        ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        order.add(new QueryOrder("page_parent_id", Order.A));
        order.add(new QueryOrder("page_order", Order.A));
        
        try {
           pages = page.Read(qc,fields,order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(pages.isEmpty()){
                return null;
            }
        return pages;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "trasProd")
    public String trasProd(@WebParam(name = "trans_det_trans_id") String trans_det_trans_id) {
        HashMap<String,String> f = new HashMap<>();
        f = Func.getBrasIds(trans_det_trans_id);
        
        String txt = "Source Bra: "+f.get("trans_src_bra_id")+" Dest: "+f.get("trans_dest_bra_id");
        return txt;
    }
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCustIdByName")
    public ArrayList<Customer> getCustIdByName(@WebParam(name = "cust_name") String cust_name) {
        Customer cust  = new Customer();
        ArrayList<Customer> custs = new ArrayList<Customer>();
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("cust_name", cust_name, Operand.LIKE));
        ArrayList<String> fields = new ArrayList<String>();
        ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           custs = cust.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(custs.isEmpty()){
            cust.setCust_name("No result found");
            cust.setCust_id("-1");
            custs.add(cust);
        }
        return custs;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getSupIdByName")
    public ArrayList<Supplier> getSupIdByName(@WebParam(name = "sup_name") String sup_name) {
        Supplier sup  = new Supplier();
        ArrayList<Supplier> sups = new ArrayList<Supplier>();
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("sup_name", sup_name, Operand.LIKE));
        ArrayList<String> fields = new ArrayList<String>();
        ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           sups = sup.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(sups.isEmpty()){
            sup.setSup_name("No result found");
            sup.setSup_id("-1");
            sups.add(sup);
        }
        return sups;
    }    
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getNextId")
    public String getNextId(@WebParam(name = "tableName") String tableName, @WebParam(name = "idName") String idName) {
        return "6";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getOrderOutDetailByOrdOutId")
    public ArrayList<OrderOutDetail> getOrderOutDetailByOrdOutId(@WebParam(name = "ord_out_det_ord_out_id") String ord_out_det_ord_out_id) {
            OrderOutDetail ord_out_det  = new OrderOutDetail();
            ArrayList<OrderOutDetail> ord_out_dets = new ArrayList<OrderOutDetail>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("ord_out_det_ord_out_id", ord_out_det_ord_out_id, Operand.EQUALS));
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           ord_out_dets = ord_out_det.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(ord_out_dets.isEmpty()){
            ord_out_det.setOrd_out_det_id("-1");
            ord_out_dets.add(ord_out_det);
        }
        return ord_out_dets;
    }    

 /**
     * Web service operation
     */
    @WebMethod(operationName = "getOrderInDetailByOrdInId")
    public ArrayList<OrderInDetail> getOrderInDetailByOrdInId(@WebParam(name = "ord_in_det_ord_in_id") String ord_in_det_ord_in_id) {
            OrderInDetail ord_in_det  = new OrderInDetail();
            ArrayList<OrderInDetail> ord_in_dets = new ArrayList<OrderInDetail>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            qc.add(new QueryCriteria("ord_in_det_ord_in_id", ord_in_det_ord_in_id, Operand.EQUALS));
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           ord_in_dets = ord_in_det.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(ord_in_dets.isEmpty()){
            ord_in_det.setOrd_in_det_id("-1");
            ord_in_dets.add(ord_in_det);
        }
        return ord_in_dets;
    }  
}
