package net.smb215.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.smb215.lib.CRUD;
import net.smb215.lib.Func;
import net.smb215.lib.QueryCriteria;

public class Shipper {
    private final CRUD crud;
    private static final long serialVersionUID = 1L;
    private String ship_id;
    private String ship_name;
    private String ship_type;
    private String ship_add_1;
    private String ship_add_2;
    private String ship_tel_1;
    private String ship_tel_2;
    private String ship_fax;
    private String ship_email;
    private String ship_taxable;
    private String ship_time_stamp;

    public Shipper() {
        crud = new CRUD("shipper");
    }
    
    public ArrayList<Shipper> Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields, ArrayList<String> order) throws SQLException {
        ResultSet rs = crud.Read(criteria, fields, order);
        ArrayList<Shipper> result = new ArrayList<>();
        while (rs.next()) {
            Shipper tmp = new Shipper();
            tmp = (Shipper) Func.castResultSetToObject(rs, tmp);
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

    public String getShip_id() {
        return ship_id;
    }

    public void setShip_id(String ship_id) {
        this.ship_id = ship_id;
    }

    public String getShip_name() {
        return ship_name;
    }

    public void setShip_name(String ship_name) {
        this.ship_name = ship_name;
    }

    public String getShip_type() {
        return ship_type;
    }

    public void setShip_type(String ship_type) {
        this.ship_type = ship_type;
    }

    public String getShip_add_1() {
        return ship_add_1;
    }

    public void setShip_add_1(String ship_add_1) {
        this.ship_add_1 = ship_add_1;
    }

    public String getShip_add_2() {
        return ship_add_2;
    }

    public void setShip_add_2(String ship_add_2) {
        this.ship_add_2 = ship_add_2;
    }

    public String getShip_tel_1() {
        return ship_tel_1;
    }

    public void setShip_tel_1(String ship_tel_1) {
        this.ship_tel_1 = ship_tel_1;
    }

    public String getShip_tel_2() {
        return ship_tel_2;
    }

    public void setShip_tel_2(String ship_tel_2) {
        this.ship_tel_2 = ship_tel_2;
    }

    public String getShip_fax() {
        return ship_fax;
    }

    public void setShip_fax(String ship_fax) {
        this.ship_fax = ship_fax;
    }

    public String getShip_email() {
        return ship_email;
    }

    public void setShip_email(String ship_email) {
        this.ship_email = ship_email;
    }

    public String getShip_taxable() {
        return ship_taxable;
    }

    public void setShip_taxable(String ship_taxable) {
        this.ship_taxable = ship_taxable;
    }

    public String getShip_time_stamp() {
        return ship_time_stamp;
    }

    public void setShip_time_stamp(String ship_time_stamp) {
        this.ship_time_stamp = ship_time_stamp;
    }
    
}