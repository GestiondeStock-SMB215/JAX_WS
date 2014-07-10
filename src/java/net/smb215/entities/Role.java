package net.smb215.entities;

import net.smb215.lib.CRUD;
import net.smb215.lib.QueryCriteria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author jouj
 */
public class Role {
    private CRUD crud;
    public String role_id;
    public String role_name;
    public String role_desc;
    public String role_time_stamp;
    
    public Role() {
        crud = new CRUD("role");
    }
    
   public void Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields);
        while (rs.next()) {
            this.role_id = rs.getString("role_id");
            this.role_name = rs.getString("role_name");
            this.role_desc = rs.getString("role_desc");
            this.role_time_stamp = rs.getString("role_time_stamp");
        }        
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
    
}
