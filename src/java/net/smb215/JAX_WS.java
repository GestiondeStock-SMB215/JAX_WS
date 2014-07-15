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
            
            ArrayList<String> fields = new ArrayList<>();
            
            users = user.Read(qc, fields);
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
        try {
           users = user.Read(qc,fields);
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
    @WebMethod(operationName = "getRoles")
    public ArrayList<Role> getRoles() {
         Role role = new Role();
            ArrayList<Role> roles = new ArrayList<Role>();
            ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
            ArrayList<String> fields = new ArrayList<String>();
        try {
           roles = role.Read(qc,fields);
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
    @WebMethod(operationName = "addUser")
    public Integer addUser(@WebParam(name = "user_role_id") String user_role_id, @WebParam(name = "user_name") String user_name, @WebParam(name = "user_username") String user_username, @WebParam(name = "user_password") String user_password, @WebParam(name = "user_email") String user_email, @WebParam(name = "user_status") String user_status) {
        User user = new User();        
        
        HashMap<String,String> fields = new HashMap<String,String>();
        fields.put("user_role_id", user_role_id);
        fields.put("user_name",user_username);
        fields.put("user_username", user_name);
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
    @WebMethod(operationName = "deleteUser")
    public Integer deleteUser(@WebParam(name = "user_id") String user_id) {
        
        ArrayList<QueryCriteria> qc = new ArrayList<QueryCriteria>();
        qc.add(new QueryCriteria("user_id", user_id, Operand.EQUALS));
        return new User().Delete(qc);
        
    }
  
}
    
