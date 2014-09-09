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
/**
 *
 * @author henry_kozhaya
 */
@WebService(serviceName = "JAX_WS")
public class JAX_WS {
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUsers")
    public ArrayList<User> getUsers(){
            User user = new User();
            ArrayList<User> users = new ArrayList<User>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
            users = user.Read(qc,fields, order);
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
    @WebMethod(operationName = "getInvoiceIn")
    public ArrayList<InvoiceIn> getInvoiceIn(){
            InvoiceIn invoicein = new InvoiceIn();
            ArrayList<InvoiceIn> invoicesin = new ArrayList<InvoiceIn>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           invoicesin = invoicein.Read(qc,fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(invoicesin.isEmpty()){
                return null;
            }
        return invoicesin;
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getInvoiceOut")
    public ArrayList<InvoiceOut> getInvoiceOut(){
            InvoiceOut invoiceout = new InvoiceOut();
            ArrayList<InvoiceOut> invoicesout = new ArrayList<InvoiceOut>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           invoicesout = invoiceout.Read(qc,fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(invoicesout.isEmpty()){
                return null;
            }
        return invoicesout;
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getOrderIn")
    public ArrayList<OrderIn> getOrderIn(){
            OrderIn orderin = new OrderIn();
            ArrayList<OrderIn> ordersin = new ArrayList<OrderIn>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           ordersin = orderin.Read(qc,fields,order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(ordersin.isEmpty()){
                return null;
            }
        return ordersin;
    }
     /**
     * Web service operation
     */
    @WebMethod(operationName = "getOrderOut")
    public ArrayList<OrderOut> getOrderOut(){
            OrderOut orderout = new OrderOut();
            ArrayList<OrderOut> ordersout = new ArrayList<OrderOut>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           ordersout = orderout.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(ordersout.isEmpty()){
                return null;
            }
        return ordersout;
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getRoles")
    public ArrayList<Role> getRoles() {
         Role role = new Role();
            ArrayList<Role> roles = new ArrayList<Role>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
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
    @WebMethod(operationName = "getStatus")
    public ArrayList<Status> getStatus() {
            Status sta = new Status();
            ArrayList<Status> status = new ArrayList<Status>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           status = sta.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(status.isEmpty()){
                return null;
            }
        return status;
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getBranches")
    public ArrayList<Branch> getBranches() {
            Branch bra  = new Branch();
            ArrayList<Branch> branches = new ArrayList<Branch>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           branches = bra.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(branches.isEmpty()){
                return null;
            }
        return branches;
    }
     /**
     * Web service operation
     */
    @WebMethod(operationName = "getCategories")
    public ArrayList<Category> getCategories() {
            Category cat  = new Category();
            ArrayList<Category> categories = new ArrayList<Category>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           categories = cat.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(categories.isEmpty()){
                return null;
            }
        return categories;
    }
     /**
     * Web service operation
     */
    @WebMethod(operationName = "getCountries")
    public ArrayList<Country> getCountries() {
            Country cnt  = new Country();
            ArrayList<Country> countries = new ArrayList<Country>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           countries = cnt.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(countries.isEmpty()){
                return null;
            }
        return countries;
    }
     /**
     * Web service operation
     */
    @WebMethod(operationName = "getCustomers")
    public ArrayList<Customer> getCustomers() {
            Customer cust  = new Customer();
            ArrayList<Customer> customers = new ArrayList<Customer>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           customers = cust.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(customers.isEmpty()){
                return null;
            }
        return customers;
    }
     /**
     * Web service operation
     */
    @WebMethod(operationName = "getProducts")
    public ArrayList<Product> getProducts() {
            Product prod  = new Product();
            ArrayList<Product> products = new ArrayList<Product>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           products = prod.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(products.isEmpty()){
                return null;
            }
        return products;
    }
     /**
     * Web service operation
     */
    @WebMethod(operationName = "getSuppliers")
    public ArrayList<Supplier> getSuppliers() {
            Supplier sup  = new Supplier();
            ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           suppliers = sup.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(suppliers.isEmpty()){
                return null;
            }
        return suppliers;
    }
     /**
     * Web service operation
     */
    @WebMethod(operationName = "getTransfers")
    public ArrayList<Transfert> getTransfers() {
            Transfert trans  = new Transfert();
            ArrayList<Transfert> transfers = new ArrayList<Transfert>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           transfers = trans.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(transfers.isEmpty()){
                return null;
            }
        return transfers;
    }
     /**
     * Web service operation
     */
    @WebMethod(operationName = "getShippers")
    public ArrayList<Shipper> getShippers() {
            Shipper ship  = new Shipper();
            ArrayList<Shipper> shippers = new ArrayList<Shipper>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           shippers = ship.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(shippers.isEmpty()){
                return null;
            }
        return shippers;
    }
     /**
     * Web service operation
     */
    @WebMethod(operationName = "getStock")
    public ArrayList<Stock> getStock() {
            Stock stk  = new Stock();
            ArrayList<Stock> stock = new ArrayList<Stock>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            ArrayList<String> fields = new ArrayList<String>();
            ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
        try {
           stock = stk.Read(qc, fields, order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(stock.isEmpty()){
                return null;
            }
        return stock;
    }
     /**
     * Web service operation
     */
    @WebMethod(operationName = "getTracking")
    public ArrayList<Tracking> getTracking() {
            Tracking track  = new Tracking();
            ArrayList<Tracking> tracks = new ArrayList<Tracking>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
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
    @WebMethod(operationName = "addUser")
    public Integer addUser(@WebParam(name = "user_role_id") String user_role_id, @WebParam(name = "user_name") String user_name, @WebParam(name = "user_username") String user_username, @WebParam(name = "user_password") String user_password, @WebParam(name = "user_email") String user_email, @WebParam(name = "user_status") String user_status) {
        User user = new User();        
        
        HashMap<String,String> fields = new HashMap<String,String>();
        fields.put("user_role_id", user_role_id);
        fields.put("user_name",user_name);
        fields.put("user_username", user_username);
        fields.put("user_password", user_password);
        fields.put("user_email", user_email);
        fields.put("user_status", user_status);
        fields.put("user_time_stamp", Func.NOW());
        fields.put("user_last_login", "0000-00-00 00:00:00");
       
        return user.Create(fields); 
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addInvoiceIn")
    public Integer addInvoiceIn(@WebParam(name = "inv_in_id") String inv_in_id, @WebParam(name = "inv_in_ord_in_id") String inv_in_ord_in_id,
                             @WebParam(name = "inv_in_cust_id") String inv_in_cust_id, @WebParam(name = "inv_in_date") String inv_in_date,
                             @WebParam(name = "inv_in_num") String inv_in_num, @WebParam(name = "inv_in_total") String inv_in_total,
                             @WebParam(name = "inv_in_tax") String inv_in_tax, @WebParam(name = "inv_in_disc") String inv_in_disc,
                             @WebParam(name = "inv_in_total_due") String inv_in_total_due, @WebParam(name = "inv_in_status") String inv_in_status,
                             @WebParam(name = "inv_in_att") String inv_in_att) {
        InvoiceIn invoicein = new InvoiceIn();        
        
        HashMap<String,String> fields = new HashMap<String,String>();
        fields.put("inv_in_id", inv_in_id);
        fields.put("inv_in_ord_in_id",inv_in_ord_in_id);
        fields.put("inv_in_cust_id", inv_in_cust_id);
        fields.put("inv_in_date", inv_in_date);
        fields.put("inv_in_num", inv_in_num);
        fields.put("inv_in_total", inv_in_total);
        fields.put("inv_in_tax", inv_in_tax);
        fields.put("inv_in_disc", inv_in_disc);
        fields.put("inv_in_total_due", inv_in_total_due);
        fields.put("inv_in_status", inv_in_status);
        fields.put("inv_in_att", inv_in_att);
        fields.put("inv_in_time_stamp", Func.NOW());
       
        return invoicein.Create(fields); 
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addInvoiceOut")
    public Integer addInvoiceOut(@WebParam(name = "inv_out_id") String inv_out_id, @WebParam(name = "inv_out_ord_out_id") String inv_out_ord_out_id,
                             @WebParam(name = "inv_out_sup_id") String inv_out_sup_id, @WebParam(name = "inv_out_date") String inv_out_date,
                             @WebParam(name = "inv_out_num") String inv_out_num, @WebParam(name = "inv_out_total") String inv_out_total,
                             @WebParam(name = "inv_out_tax") String inv_out_tax, @WebParam(name = "inv_out_disc") String inv_out_disc,
                             @WebParam(name = "inv_out_total_due") String inv_out_total_due, @WebParam(name = "inv_out_status") String inv_out_status,
                             @WebParam(name = "inv_out_att") String inv_out_att) {
        InvoiceOut invoiceout = new InvoiceOut();        
        
        HashMap<String,String> fields = new HashMap<String,String>();
        fields.put("inv_out_id", inv_out_id);
        fields.put("inv_out_ord_out_id",inv_out_ord_out_id);
        fields.put("inv_out_sup_id", inv_out_sup_id);
        fields.put("inv_out_date", inv_out_date);
        fields.put("inv_out_num", inv_out_num);
        fields.put("inv_out_total", inv_out_total);
        fields.put("inv_out_tax", inv_out_tax);
        fields.put("inv_out_disc", inv_out_disc);
        fields.put("inv_out_total_due", inv_out_total_due);
        fields.put("inv_out_status", inv_out_status);
        fields.put("inv_out_att", inv_out_att);
        fields.put("inv_out_time_stamp", Func.NOW());
       
        return invoiceout.Create(fields); 
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addOrderIn")
    public Integer addOrderIn(@WebParam(name = "ord_in_id") String ord_in_id, @WebParam(name = "ord_in_cust_id") String ord_in_cust_id,
                             @WebParam(name = "ord_in_date") String ord_in_date, @WebParam(name = "ord_in_del_date") String ord_in_del_date,
                             @WebParam(name = "ord_in_status") String ord_in_status) {
        OrderIn orderin = new OrderIn();        
        
        HashMap<String,String> fields = new HashMap<String,String>();
        fields.put("ord_in_id", ord_in_id);
        fields.put("ord_in_cust_id",ord_in_cust_id);
        fields.put("ord_in_date", ord_in_date);
        fields.put("ord_in_del_date", ord_in_del_date);
        fields.put("ord_in_status", ord_in_status);
        fields.put("ord_in_time_stamp", Func.NOW());
       
        return orderin.Create(fields); 
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addOrderOut")
    public Integer addOrderOut(@WebParam(name = "ord_out_id") String ord_out_id, @WebParam(name = "ord_out_sup_id") String ord_out_sup_id,
                             @WebParam(name = "ord_out_date") String ord_out_date, @WebParam(name = "ord_out_del_date") String ord_out_del_date,
                             @WebParam(name = "ord_out_status") String ord_out_status) {
        OrderOut orderout = new OrderOut();        
        
        HashMap<String,String> fields = new HashMap<String,String>();
        fields.put("ord_out_id", ord_out_id);
        fields.put("ord_out_sup_id",ord_out_sup_id);
        fields.put("ord_out_date", ord_out_date);
        fields.put("ord_out_del_date", ord_out_del_date);
        fields.put("ord_out_status", ord_out_status);
        fields.put("ord_out_time_stamp", Func.NOW());
       
        return orderout.Create(fields); 
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addStatus")
    public Integer addStatus(@WebParam(name = "sta_id") String sta_id, @WebParam(name = "sta_ref") String sta_ref, @WebParam(name = "sta_desc") String sta_desc) {
        Status sta = new Status();        
        
        HashMap<String,String> fields = new HashMap<String,String>();
        fields.put("sta_id",sta_id);
        fields.put("sta_ref",sta_ref);
        fields.put("sta_desc",sta_desc);
        fields.put("sta_time_stamp", Func.NOW());
       
        return sta.Create(fields); 
    }
   /**
     * Web service operation
     */
    @WebMethod(operationName = "addRole")
    public Integer addRole(@WebParam(name = "role_id") String role_id, @WebParam(name = "role_name") String role_name, @WebParam(name = "role_desc") String role_desc) {
        Role role = new Role();        
        
        HashMap<String,String> fields = new HashMap<String,String>();
        fields.put("role_id",role_id);
        fields.put("role_name",role_name);
        fields.put("role_desc",role_desc);
        fields.put("role_time_stamp", Func.NOW());
       
        return role.Create(fields); 
    }
      /**
     * Web service operation
     */
    @WebMethod(operationName = "addTracking")
    public Integer addTracking(@WebParam(name = "track_id") String track_id, @WebParam(name = "track_trans_id") String track_trans_id, @WebParam(name = "track_ship_id") String track_ship_id) {
        Tracking track = new Tracking();        
        
        HashMap<String,String> fields = new HashMap<String,String>();
        fields.put("track_id",track_id);
        fields.put("track_trans_id",track_trans_id);
        fields.put("track_ship_id",track_ship_id);
        fields.put("track_time_stamp", Func.NOW());
       
        return track.Create(fields); 
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addBranch")
    public Integer addBranch(@WebParam(name = "bra_name") String bra_name, @WebParam(name = "bra_cnt_id") String bra_cnt_id, 
                             @WebParam(name = "bra_city") String bra_city,@WebParam(name = "bra_add_str") String bra_add_str,
                             @WebParam(name = "bra_add_1") String bra_add_1,@WebParam(name = "bra_tel_1") String bra_tel_1, 
                             @WebParam(name = "bra_tel_2") String bra_tel_2,
                             @WebParam(name = "bra_fax") String bra_fax, @WebParam(name = "bra_email") String bra_email) {
        Branch bra = new Branch();        
        
        HashMap<String,String> fields = new HashMap<String,String>();
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
     /**
     * Web service operation
     */
    @WebMethod(operationName = "addCategory")
    public Integer addCategory(@WebParam(name = "cat_id") String cat_id, @WebParam(name = "cat_name") String cat_name, 
                               @WebParam(name = "cat_desc") String cat_desc,@WebParam(name = "cat_pic") String cat_pic) {
        Category cat = new Category();        
        
        HashMap<String,String> fields = new HashMap<String,String>();
        fields.put("cat_id", cat_id);
        fields.put("cat_name",cat_name);
        fields.put("cat_desc", cat_desc);
        fields.put("cat_pic", cat_pic);
        fields.put("cat_time_stamp", Func.NOW());
        
       
        return cat.Create(fields); 
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addCountry")
    public Integer addCountry(@WebParam(name = "cnt_id") String cnt_id,  @WebParam(name = "cnt_iso") String cnt_iso,
                              @WebParam(name = "cnt_name") String cnt_name,@WebParam(name = "cnt_nicename") String cnt_nicename,
                              @WebParam(name = "cnt_iso3") String cnt_iso3,@WebParam(name = "cnt_numcode") String cnt_numcode,
                              @WebParam(name = "cnt_phonecode") String cnt_phonecode) {
        Country cnt = new Country();        
        
        HashMap<String,String> fields = new HashMap<String,String>();
        fields.put("cnt_id", cnt_id);
        fields.put("cnt_iso", cnt_iso);
        fields.put("cnt_name", cnt_name);
        fields.put("cnt_nicename",cnt_nicename);
        fields.put("cnt_iso3", cnt_iso3);
        fields.put("cnt_numcode", cnt_numcode);
        fields.put("cnt_phonecode", cnt_phonecode);
        fields.put("cnt_time_stamp", Func.NOW());
        
       
        return cnt.Create(fields); 
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addCustomer")
    public Integer addCustomer(@WebParam(name = "cust_id") String cust_id,  @WebParam(name = "cust_comp") String cust_comp,
                              @WebParam(name = "cust_name") String cust_name,@WebParam(name = "cust_title") String cust_title,
                              @WebParam(name = "cust_add_1") String cust_add_1,@WebParam(name = "cust_add_2") String cust_add_2,
                              @WebParam(name = "cust_city") String cust_city,@WebParam(name = "cust_cnt_id") String cust_cnt_id,
                              @WebParam(name = "cust_tel_1") String cust_tel_1,@WebParam(name = "cust_tel_2") String cust_tel_2,
                              @WebParam(name = "cust_fax") String cust_fax,@WebParam(name = "cust_email") String cust_email,
                              @WebParam(name = "cust_site") String cust_site,@WebParam(name = "cust_logo") String cust_logo) {
        Customer cust = new Customer();        
        
        HashMap<String,String> fields = new HashMap<String,String>();
        fields.put("cust_id", cust_id);
        fields.put("cust_comp", cust_comp);
        fields.put("cust_name", cust_name);
        fields.put("cust_title",cust_title);
        fields.put("cust_add_1", cust_add_1);
        fields.put("cust_add_2", cust_add_2);
        fields.put("cust_fax", cust_fax);
        fields.put("cust_email", cust_email);
        fields.put("cust_site", cust_site);
        fields.put("cust_logo", cust_logo);
        fields.put("cust_time_stamp", Func.NOW());
        
       
        return cust.Create(fields); 
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addProduct")
    public Integer addProduct(@WebParam(name = "prod_id") String prod_id,  @WebParam(name = "prod_cat_id") String prod_cat_id,
                              @WebParam(name = "prod_sku") String prod_sku,@WebParam(name = "prod_upc") String prod_upc,
                              @WebParam(name = "prod_name") String prod_name,@WebParam(name = "prod_desc") String prod_desc,
                              @WebParam(name = "prod_qty") String prod_qty,@WebParam(name = "prod_qty_per_unit") String prod_qty_per_unit,
                              @WebParam(name = "prod_color") String prod_color,@WebParam(name = "prod_size") String prod_size,
                              @WebParam(name = "prod_weight") String prod_weight,@WebParam(name = "prod_sup_id") String prod_sup_id,
                              @WebParam(name = "prod_status") String prod_status,@WebParam(name = "prod_pic") String prod_pic,
                              @WebParam(name = "prod_vend_id") String prod_vend_id) {
        Product prod = new Product();        
        
        HashMap<String,String> fields = new HashMap<String,String>();
        fields.put("prod_id", prod_id);
        fields.put("prod_cat_id", prod_cat_id);
        fields.put("prod_sku", prod_sku);
        fields.put("prod_upc",prod_upc);
        fields.put("prod_name", prod_name);
        fields.put("prod_desc", prod_desc);
        fields.put("prod_qty", prod_qty);
        fields.put("prod_qty_per_unit", prod_qty_per_unit);
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
       /**
     * Web service operation
     */
    @WebMethod(operationName = "addShipper")
    public Integer addShipper(@WebParam(name = "ship_id") String ship_id,  @WebParam(name = "ship_name") String ship_name,
                              @WebParam(name = "ship_type") String ship_type,@WebParam(name = "ship_add_1") String ship_add_1,
                              @WebParam(name = "ship_add_2") String ship_add_2,@WebParam(name = "ship_tel_1") String ship_tel_1,
                              @WebParam(name = "ship_tel_2") String ship_tel_2,@WebParam(name = "ship_fax") String ship_fax,
                              @WebParam(name = "ship_email") String ship_email,@WebParam(name = "ship_taxable") String ship_taxable){
        Shipper ship = new Shipper();        
        
        HashMap<String,String> fields = new HashMap<String,String>();
        fields.put("ship_id", ship_id);
        fields.put("ship_name", ship_name);
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
      /**
     * Web service operation
     */
    @WebMethod(operationName = "addSupplier")
    public Integer addSupplier(@WebParam(name = "sup_id") String sup_id,  @WebParam(name = "sup_comp") String sup_comp,
                              @WebParam(name = "sup_name") String sup_name,@WebParam(name = "sup_title") String sup_title,
                              @WebParam(name = "sup_add_1") String sup_add_1,@WebParam(name = "sup_add_2") String sup_add_2,
                              @WebParam(name = "sup_city") String sup_city,@WebParam(name = "sup_cnt_id") String sup_cnt_id,
                              @WebParam(name = "sup_tel_1") String sup_tel_1,@WebParam(name = "sup_tel_2") String sup_tel_2,
                              @WebParam(name = "sup_fax") String sup_fax, @WebParam(name = "sup_email") String sup_email,
                              @WebParam(name = "sup_site") String sup_site,@WebParam(name = "sup_logo") String sup_logo){
        Supplier sup = new Supplier();        
        
        HashMap<String,String> fields = new HashMap<String,String>();
        fields.put("sup_id", sup_id);
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
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addTransfert")
    public Integer addTransfert(@WebParam(name = "trans_id") String trans_id,
                                @WebParam(name = "trans_src_bra_id") String trans_src_bra_id,
                                @WebParam(name = "trans_dest_bra_id") String trans_dest_bra_id,
                                @WebParam(name = "trans_send_date") String trans_send_date,
                                @WebParam(name = "trans_del_date") String trans_del_date,
                                @WebParam(name = "trans_status") String trans_status){
        Transfert trans = new Transfert();        
        
        HashMap<String,String> fields = new HashMap<String,String>();
        fields.put("trans_id", trans_id);
        fields.put("trans_src_bra_id", trans_src_bra_id);
        fields.put("trans_dest_bra_id", trans_dest_bra_id);
        fields.put("trans_send_date",trans_send_date);
        fields.put("trans_del_date", trans_del_date);
        fields.put("trans_status", trans_status);
        fields.put("trans_time_stamp", Func.NOW());
        
       
        return trans.Create(fields); 
    }
     /**
     * Web service operation
     */
    @WebMethod(operationName = "addStock")
    public Integer addStock(@WebParam(name = "stock_id") String stock_id,
                                @WebParam(name = "stock_prod_id") String stock_prod_id,
                                @WebParam(name = "stock_bra_id") String stock_bra_id,
                                @WebParam(name = "stock_qty") String stock_qty){
        Stock stock = new Stock();        
        
        HashMap<String,String> fields = new HashMap<String,String>();
        fields.put("stock_id", stock_id);
        fields.put("stock_prod_id", stock_prod_id);
        fields.put("stock_bra_id", stock_bra_id);
        fields.put("stock_qty",stock_qty);
        fields.put("stock_time_stamp", Func.NOW());
        
       
        return stock.Create(fields); 
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
    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteInvoiceOut")
    public Integer deleteInvoiceOut(@WebParam(name = "inv_out_id") String inv_out_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("inv_out_id", inv_out_id, Operand.EQUALS));
        return new InvoiceOut().Delete(qc);
        
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
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteOrderOut")
    public Integer deleteOrderOut(@WebParam(name = "ord_out_id") String ord_out_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("ord_out_id", ord_out_id, Operand.EQUALS));
        return new OrderOut().Delete(qc);
        
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
    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteRole")
    public Integer deleteRole(@WebParam(name = "role_id") String role_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("role_id", role_id, Operand.EQUALS));
        return new Role().Delete(qc);
        
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteStatus")
    public Integer deleteStatus(@WebParam(name = "sta_id") String sta_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("sta_id", sta_id, Operand.EQUALS));
        return new Status().Delete(qc);
        
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
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteCategory")
    public Integer deleteCategory(@WebParam(name = "cat_id") String cat_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("cat_id", cat_id, Operand.EQUALS));
        return new Category().Delete(qc);
        
    }
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteCountry")
    public Integer deleteCountry(@WebParam(name = "cnt_id") String cnt_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("cnt_id", cnt_id, Operand.EQUALS));
        return new Country().Delete(qc);
        
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
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteProduct")
    public Integer deleteProduct(@WebParam(name = "prod_id") String prod_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("prod_id", prod_id, Operand.EQUALS));
        return new Product().Delete(qc);
        
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
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteSupplier")
    public Integer deleteSupplier(@WebParam(name = "sup_id") String sup_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("sup_id", sup_id, Operand.EQUALS));
        return new Supplier().Delete(qc);
        
    }
     /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteTransfert")
    public Integer deleteTransfert(@WebParam(name = "trans_id") String trans_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("trans_id", trans_id, Operand.EQUALS));
        return new Transfert().Delete(qc);
        
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
    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteStock")
    public Integer deleteStock(@WebParam(name = "stock_id") String stock_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("stock_id", stock_id, Operand.EQUALS));
        return new Stock().Delete(qc);
        
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
    @WebMethod(operationName = "addPage")
    public Integer addPage(@WebParam(name = "page_parent_id") String page_parent_id, 
            @WebParam(name = "page_name") String page_name, @WebParam(name = "page_url") String page_url, 
            @WebParam(name = "page_acl") String page_acl, @WebParam(name = "page_in_menu") String page_in_menu) {
        
        Page page = new Page();
        HashMap<String,String> fields = new HashMap<String,String>();
        
        fields.put("page_parent_id", page_parent_id);
        fields.put("page_name", page_name);
        fields.put("page_url", page_url);
        fields.put("page_acl", page_acl);
        fields.put("page_in_menu", page_in_menu);
        fields.put("page_time_stamp", Func.NOW());

        return page.Create(fields); 
    }

    /**
     * Web service operation
     */
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
    @WebMethod(operationName = "getPageName")
    public String getPageName(@WebParam(name = "page_id") String page_id) {
        Page page = new Page();
        ArrayList<Page> pages = new ArrayList<Page>();
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        
        qc.add(new QueryCriteria("page_id", page_id, Operand.EQUALS));
        
        ArrayList<String> fields = new ArrayList<String>();
        fields.add("page_name");
        
        ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
                
        try {
           pages = page.Read(qc,fields,order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(pages.isEmpty()){
                return null;
            }
        return pages.get(0).getPage_name();
    }    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getRoleName")
    public String getRoleName(@WebParam(name = "role_id") String role_id) {
        Role role = new Role();
        ArrayList<Role> roles = new ArrayList<Role>();
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        
        qc.add(new QueryCriteria("role_id", role_id, Operand.EQUALS));
        
        ArrayList<String> fields = new ArrayList<String>();
        fields.add("role_name");
        
        ArrayList<QueryOrder> order = new ArrayList<QueryOrder>();
                
        try {
           roles = role.Read(qc,fields,order);
        } catch (SQLException ex) {
            Logger.getLogger(JAX_WS.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(roles.isEmpty()){
                return null;
            }
        return roles.get(0).getRole_name();
    }    
}