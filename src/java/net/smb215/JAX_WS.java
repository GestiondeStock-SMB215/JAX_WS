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
     */
    @WebMethod(operationName = "getUserByUsername")
    public User getUserByUsername(@WebParam(name = "user_username") String user_username, @WebParam(name = "user_password") String user_password) {
        User user = new User();
        
        try {
            String query = lib.ReadSelect("SelectUserByUsernameAndPassword", user_username, user_password);
            ResultSet rs = lib.exeSelect(query);
            while (rs.next()) {
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserUsername(rs.getString("user_username"));
                //user.setUserPassword(rs.getString("user_password"));
                user.setUserEmail(rs.getString("user_email"));
                user.setUserRoleId(rs.getInt("user_role_id"));
                user.setUserStatus(rs.getInt("user_status"));
                user.setUserTimeStamp(lib.strToDate(rs.getString("user_time_stamp")));
                user.setUserLastLogin(lib.strToDate(rs.getString("user_last_login")));               
            }
        } catch (SQLException ex) {
            lib.logToFile("error - " + ex.toString());
        } finally {
            return user;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTest")
    public String getTest(@WebParam(name = "arg1") String arg1) {
        //TODO write your implementation code here:
        return arg1;
    }
}