package net.smb215.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.smb215.lib.CRUD;
import net.smb215.lib.Func;
import net.smb215.lib.QueryCriteria;

public class Category {
    private final CRUD crud;
    private String cat_id;
    private String cat_name;
    private String cat_desc;
    private String cat_pic;
    private String cat_time_stamp;

    public Category() {
        crud = new CRUD("category");
    }

    public ArrayList<Category> Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields, ArrayList<String> order) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields, order);
        ArrayList<Category> result = new ArrayList<>();
        while (rs.next()) {
            Category tmp = new Category();
            tmp = (Category) Func.castResultSetToObject(rs, tmp);
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
    
    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getCat_desc() {
        return cat_desc;
    }

    public void setCat_desc(String cat_desc) {
        this.cat_desc = cat_desc;
    }

    public String getCat_pic() {
        return cat_pic;
    }

    public void setCat_pic(String cat_pic) {
        this.cat_pic = cat_pic;
    }

    public String getCat_time_stamp() {
        return cat_time_stamp;
    }

    public void setCat_time_stamp(String cat_time_stamp) {
        this.cat_time_stamp = cat_time_stamp;
    }
    
}