package net.smb215.lib;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBHelper {
    public Connection conn=null;
    
    public DBHelper(){
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup(Func.cnx);
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
            int rs = stmt.executeUpdate(Query,Statement.RETURN_GENERATED_KEYS);
            this.conn.close();
            ResultSet rss = stmt.getGeneratedKeys();
            int key=-1;
            if (rss != null && rss.next()) {
                 key = rss.getInt(1);
            }
            return (key==-1)?rs:key;
        } catch (SQLException ex) {
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
            this.conn.close();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
