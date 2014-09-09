package net.smb215.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.smb215.lib.CRUD;
import net.smb215.lib.Func;
import net.smb215.lib.QueryCriteria;
import net.smb215.lib.QueryOrder;

public class Role {
    private final CRUD crud;
    private String role_id;
    private String role_name;
    private String role_desc;
    private String role_time_stamp;
    
    public Role() {
        crud = new CRUD("role");
    }
    
    public ArrayList<Role> Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields, ArrayList<QueryOrder> order) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields, order);
        ArrayList<Role> result = new ArrayList<>();
        while (rs.next()) {
            Role tmp = new Role();
            tmp = (Role) Func.castResultSetToObject(rs, tmp);
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

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_desc() {
        return role_desc;
    }

    public void setRole_desc(String role_desc) {
        this.role_desc = role_desc;
    }

    public String getRole_time_stamp() {
        return role_time_stamp;
    }

    public void setRole_time_stamp(String role_time_stamp) {
        this.role_time_stamp = role_time_stamp;
    }
    
}
