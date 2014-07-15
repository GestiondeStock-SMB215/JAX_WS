/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.smb215;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import net.smb215.entities.*;
import net.smb215.lib.*;
import net.smb215.lib.QueryCriteria.*;
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
}