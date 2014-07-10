package Tools;

import com.sun.corba.se.impl.util.Utility;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author jouj
 */
public class DBHelper {
    public Connection conn=null;
    
    public DBHelper(){
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/mysql");
            this.conn = ds.getConnection();
        } catch (SQLException | NamingException ex) {
            System.out.println("ERROR!!!!!!!!!!!");
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, "Erreur pendant la connection a la base de donnee.", ex);
        }
    }
    
    /**
     *
     * @param Query
     * @return
     */
    public int executeUpdate(String Query){
        try {
            Statement stmt = this.conn.createStatement();
            int rs = stmt.executeUpdate(Query);
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
   /**
     *
     * @param Query
     * @return
     */
    public ResultSet executeQuery(String Query){
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(Query);
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
