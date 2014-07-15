/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.smb215;

import java.sql.*;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import net.smb215.entities.*;
import net.smb215.lib.lib;
/**
 *
 * @author henry_kozhaya
 */
@WebService(serviceName = "JAX_WS")
public class JAX_WS {

    /**
     * Web service operation
     * FOR LOGIN USE
     */
    @WebMethod(operationName = "getUserByUsername")
    public User getUserByUsername(@WebParam(name = "user_username") String user_username, @WebParam(name = "user_password") String user_password) {
        User user = new User();     
        try {
            String query = lib.ReadSelect("SelectUserByUsernameAndPassword", user_username, user_password);
            ResultSet rs = lib.exeSelect(query);
            while (rs.next()) {
                user.setUser_id(rs.getString("user_id"));
                user.setUser_name(rs.getString("user_name"));
                user.setUser_username(rs.getString("user_username"));
                user.setUser_email(rs.getString("user_email"));
                user.setUser_role_id(rs.getString("user_role_id"));
                user.setUser_status(rs.getString("user_status"));
                user.setUser_time_stamp(rs.getString("user_time_stamp"));
                user.setUser_last_login(rs.getString("user_last_login"));               
            }
        } catch (SQLException ex) {
            lib.logToFile("error - " + ex.toString());
        } finally {
            return user;
        }
    }

    /**
     * Web service operation
     * TO CHECK USERNAME VALIDITY WHEN REGESTERING
     */
    @WebMethod(operationName = "checkUsernameValidity")
    public Boolean checkUserUsernameValidity(@WebParam(name = "user_username") String user_username) {
        boolean valid = false;
        try {
            String query = lib.ReadSelect("SelectCountUsernameByUsername", user_username);
            ResultSet rs = lib.exeSelect(query);
            while (rs.next()) {
                if(rs.getInt("UsernameNum") == 0){
                    valid = true;
                }
            }
        } catch (SQLException ex) {
            lib.logToFile("error - " + ex.toString());
        } finally {
            return valid;
        }
    }
    
    
    /**
     * Web service operation
     * UPDATE LAST LOGIN AFTER SUCCESSFUL LOGIN
     */
    @WebMethod(operationName = "UpdateUserLastLogin")
    public Integer UpdateUserLastLogin(@WebParam(name = "user_id") String user_id) {
        int result = 0;
        String query = lib.ReadSelect("UpdateUserLastLogin", user_id);
        lib.logToFile(query);
        return lib.exeSQLCmd(query);
    }
    
    /**
     * Web service operation
     * TO CHECK EMAIL VALIDITY WHEN REGESTERING
     */
    @WebMethod(operationName = "checkEmailValidity")
    public Boolean checkUserEmailValidity(@WebParam(name = "user_email") String user_email) {
        boolean valid = false;
        try {
            String query = lib.ReadSelect("SelectCountEmailByEmail", user_email);
            ResultSet rs = lib.exeSelect(query);
            while (rs.next()) {
                if(rs.getInt("EmailNum") == 0){
                    valid = true;
                }
            }
        } catch (SQLException ex) {
            lib.logToFile("error - " + ex.toString());
        } finally {
            return valid;
        }
    }        

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deactivateUser")
    public Integer deactivateUser(@WebParam(name = "user_id") String user_id) {
        int result = 0;
        String query = lib.ReadSelect("UpdateUserStatusSet2", user_id);
        return lib.exeSQLCmd(query);
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "activateUser")
    public Integer activateUser(@WebParam(name = "user_id") String user_id) {
        int result = 0;
        String query = lib.ReadSelect("UpdateUserStatusSet1", user_id);
        return lib.exeSQLCmd(query);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "changeUserPassword")
    public Integer changeUserPassword(@WebParam(name = "user_id") String user_id, @WebParam(name = "user_password_old") String user_password_old, @WebParam(name = "user_password_new") String user_password_new) {
        int result = 0;
        String query = lib.ReadSelect("UpdateUserPassword", user_id, user_password_old, user_password_new);
        return lib.exeSQLCmd(query);
    }

    /**
     * Web service operation
     * TO CREATE A NEW USER
     */
    @WebMethod(operationName = "addUser")
    public Integer addUser(@WebParam(name = "user_role_id") String user_role_id, 
            @WebParam(name = "user_name") String user_name, @WebParam(name = "user_username") String user_username, 
            @WebParam(name = "user_password") String user_password, @WebParam(name = "user_email") String user_email, 
            @WebParam(name = "user_status") String user_status) {
        int result = 0;
        String query = lib.ReadSelect("InsertUser", user_role_id, user_name, user_username, user_password, user_email, 
                user_status);
        return lib.exeSQLCmd(query);
    }
}