package net.smb215.lib;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jouj
 */
public class CRUD {

    DBHelper DBConn;
    String table;

    public CRUD(String table) {
        this.table = table;
    }

    /**
     *
     * @param params
     * @return
     */
    public int Create(HashMap<String, String> params) {
        this.DBConn = new DBHelper();
        String fields = "", values = "", QueryStr;
        Iterator<Map.Entry<String, String>> it = params.entrySet().iterator();
        while (it.hasNext()) {
            if (!fields.equals("")) {
                fields += " , ";
            }
            if (!values.equals("")) {
                values += " , ";
            }
            Map.Entry<String, String> m = it.next();
            fields += "`" + m.getKey() + "`";
            values += "'" + m.getValue() + "'";
            System.out.println(fields);
            System.out.println(values);
        }
        QueryStr = "INSERT INTO `" + this.table + "` (" + fields + ") VALUES (" + values + ");";
        System.out.println(QueryStr);
        int result = this.DBConn.executeUpdate(QueryStr);
        try {
            this.DBConn.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    /**
     *
     * @param criteria
     * @param fields
     * @return
     */
        public ResultSet Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields, ArrayList<QueryOrder> order) {
        this.DBConn = new DBHelper();
        ResultSet result = null;
        try {
            String whereClause = "", fieldsStr = "", orderStr = "", QueryStr;
            for (int i = 0; i < criteria.size(); i++) {
                if (!whereClause.equals("")) {
                    whereClause += " and ";
                }
                whereClause += criteria.get(i).formatCriteria();
            }   
            for (int i = 0; i < fields.size(); i++) {
                if (!fieldsStr.equals("")) {
                    fieldsStr += ", ";
                }
                fieldsStr += "`" + fields.get(i) + "` ";
            }
            for(int i = 0; i<order.size(); i++){
                if(orderStr != ""){
                    orderStr += ", ";
                }
                orderStr += order.get(i).formattedOrder();
            }            
            if (fieldsStr.equals("")) {
                fieldsStr = "*";
            } else {
                fieldsStr = " " + fieldsStr + " ";
            }   
            if (whereClause.equals("")) {
                whereClause = "1";
            }
            if (orderStr.equals("")) {
                orderStr = "1";
            }

            
            QueryStr = "SELECT "+ fieldsStr +" FROM `" + this.table + "` WHERE " + whereClause+ " ORDER BY "+orderStr;
            System.out.println(QueryStr);
            result = this.DBConn.executeQuery(QueryStr);
            System.out.println(result.getFetchSize());
            
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int Delete(ArrayList<QueryCriteria> criteria) {
        this.DBConn = new DBHelper();
        String whereClause = "", QueryStr;

        for (int i = 0; i < criteria.size(); i++) {
            if (!whereClause.equals("")) {
                whereClause += " and ";
            }
            whereClause += criteria.get(i).formatCriteria();
        }
        if (whereClause.equals("")) {
            whereClause = "1";
        }
        QueryStr = "DELETE FROM " + this.table + " WHERE " + whereClause;
        int result = this.DBConn.executeUpdate(QueryStr);
        try {
            this.DBConn.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int Update(ArrayList<QueryCriteria> criteria, HashMap<String, String> fields) {
        this.DBConn = new DBHelper();
        String whereClause = "", fieldsStr = "", QueryStr;

        for (int i = 0; i < criteria.size(); i++) {
            if (!whereClause.equals("")) {
                whereClause += "and";
            }
            whereClause += criteria.get(i).formatCriteria();
        }
        Iterator<Map.Entry<String, String>> it = fields.entrySet().iterator();
        while (it.hasNext()) {
            if (!fieldsStr.equals("")) {
                fieldsStr += " , ";
            }
            Map.Entry<String, String> m = it.next();
            fieldsStr += "`" + m.getKey() + "`='" + m.getValue() + "'";
        }
        if (whereClause.equals("")) {
            whereClause = "1";
        } 
        QueryStr = "Update " + this.table + " SET " + fieldsStr + " WHERE " + whereClause + ";";
        int result = this.DBConn.executeUpdate(QueryStr);
        try {
            this.DBConn.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }

}
