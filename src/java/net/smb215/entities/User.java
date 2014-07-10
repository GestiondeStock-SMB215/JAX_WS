/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.smb215.entities;

import java.util.Date;

/**
 *
 * @author henry_kozhaya
 */

public class User {
    private Integer user_id;
    private Integer user_role_id;
    private String user_name;
    private String user_username;
    private String user_password;
    private String user_email;
    private Integer user_status;
    private Date user_last_login;
    private Date user_time_stamp;

    public User() {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(Integer user_role_id) {
        this.user_role_id = user_role_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_nsername) {
        this.user_username = user_nsername;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Integer getUser_status() {
        return user_status;
    }

    public void setUser_status(Integer user_status) {
        this.user_status = user_status;
    }

    public Date getUser_last_login() {
        return user_last_login;
    }

    public void setUser_last_login(Date user_last_login) {
        this.user_last_login = user_last_login;
    }

    public Date getUser_time_stamp() {
        return user_time_stamp;
    }

    public void setUser_time_stamp(Date user_time_stamp) {
        this.user_time_stamp = user_time_stamp;
    }
    
}