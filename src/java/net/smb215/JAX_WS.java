/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.smb215;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import net.smb215.entities.*;
import net.smb215.lib.lib;
import java.util.Date;
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
        User u = new User();
        try {
            String query = "SELECT * FROM `user` WHERE `user_username` = '"+user_username+"' AND `user_password` = '"+user_password+"'";
            ResultSet rs = lib.exeSelect(query);
            while (rs.next()) {
                u.setUserId(rs.getInt("user_id"));
                u.setUserName(rs.getString("user_name"));
                u.setUserUsername(rs.getString("user_username"));
                u.setUserPassword(rs.getString("user_password"));
                u.setUserEmail(rs.getString("user_email"));
                u.setUserRoleId(rs.getInt("user_role_id"));
                u.setUserStatus(rs.getInt("user_status"));
                u.setUserTimeStamp(lib.strToDate(rs.getString("user_time_stamp")));
                u.setUserLastLogin(lib.strToDate(rs.getString("user_last_login")));
            }

        } catch (SQLException ex) {
            lib.logToFile("error - " + ex.toString());
        } finally {
            return u;
        }
    }
}