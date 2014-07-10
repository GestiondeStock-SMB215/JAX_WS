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
        this.DBConn = new DBHelper();
        this.table = table;
    }

    /**
     *
     * @param params
     * @return
     */
    public int Create(HashMap<String, String> params) {
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
        return result;
    }

    /**
     *
     * @param criteria
     * @param fields
     * @return
     */
    public ResultSet Read(ArrayList<QueryCriteria> criteria, ArrayList<String> fields) {
        ResultSet result = null;
        try {
            String whereClause = "", fieldsStr = "", QueryStr;
            for (int i = 0; i < criteria.size(); i++) {
                if (!whereClause.equals("")) {
                    whereClause += " and ";
                }
                whereClause += "`" + criteria.get(i).field + "` " + criteria.get(i).operand.getValue() + " '" + criteria.get(i).value + "'";
            }   
            for (int i = 0; i < fields.size(); i++) {
            if (!fieldsStr.equals("")) {
                fieldsStr += ", ";
            }
            fieldsStr += "`" + fields.get(i) + "` ";
        }   if (fieldsStr.equals("")) {
            fieldsStr = "*";
        } else {
            fieldsStr = "( " + fieldsStr + " )";
        }   QueryStr = "SELECT "+ fieldsStr +" FROM " + this.table + " WHERE " + whereClause;
        System.out.println(QueryStr);
            result = this.DBConn.executeQuery(QueryStr);
            System.out.println(result.getFetchSize());
            
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int Delete(ArrayList<QueryCriteria> criteria) {
        String whereClause = "", QueryStr;

        for (int i = 0; i < criteria.size(); i++) {
            if (!whereClause.equals("")) {
                whereClause += " and ";
            }
            whereClause += "`"+criteria.get(i).field + "` " + criteria.get(i).operand.getValue() + " '" + criteria.get(i).value + "'";
        }

        QueryStr = "DELETE FROM " + this.table + " WHERE " + whereClause;
        int result = this.DBConn.executeUpdate(QueryStr);
        return result;
    }

    public int Update(ArrayList<QueryCriteria> criteria, HashMap<String, String> fields) {
        String whereClause = "", fieldsStr = "", QueryStr;

        for (int i = 0; i < criteria.size(); i++) {
            if (!whereClause.equals("")) {
                whereClause += " and ";
            }
            whereClause += "`" + criteria.get(i).field + "` " + criteria.get(i).operand.getValue() + " '" + criteria.get(i).value + "'";
        }
        Iterator<Map.Entry<String, String>> it = fields.entrySet().iterator();
        while (it.hasNext()) {
            if (!fieldsStr.equals("")) {
                fieldsStr += " , ";
            }
            Map.Entry<String, String> m = it.next();
            fieldsStr += "`" + m.getKey() + "`='" + m.getValue() + "'";
        }
        QueryStr = "Update " + this.table + " SET " + fieldsStr + " WHERE " + whereClause + ";";
        int result = this.DBConn.executeUpdate(QueryStr);
        return result;

    }

}
