package Services;

import Tools.CRUD;
import Tools.QueryCriteria;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author jouj
 */

public class CRUD_WS {

    public int Create(String table_name,HashMap<String, String> params) {
        Tools.CRUD CRUD_Obj = new CRUD(table_name);
        return CRUD_Obj.Create(params);        
    }
    
    public ResultSet Read(String table_name,ArrayList<QueryCriteria> criteria, ArrayList<String> fields) {
        Tools.CRUD CRUD_Obj = new CRUD(table_name);
        return CRUD_Obj.Read(criteria, fields);
    }
    
    public int Delete(String table_name,ArrayList<QueryCriteria> criteria) {
        Tools.CRUD CRUD_Obj = new CRUD(table_name);
        return CRUD_Obj.Delete(criteria);
    }
    
    public int Update(String table_name,ArrayList<QueryCriteria> criteria, HashMap<String, String> fields) {
        Tools.CRUD CRUD_Obj = new CRUD(table_name);
        return CRUD_Obj.Update(criteria, fields);
    }
    
}
