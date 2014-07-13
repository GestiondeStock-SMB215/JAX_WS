package net.smb215.lib;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jouj
 */
public class Func {
    public static String NOW(){
        return new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()).toString();
    }
    
    public static Object castResultSetToObject(ResultSet RS,Object obj){
        Field[]  FS = obj.getClass().getDeclaredFields();
        Class[] paramString = new Class[1];	
	paramString[0] = String.class;
        for (Field FS1 : FS) {
            String key = FS1.getName();
            if(key.equals("crud"))continue;
            try {
                String val = RS.getString(key);
                obj.getClass().getDeclaredMethod("set"+key.substring(0, 1).toUpperCase() + key.substring(1),paramString).invoke(obj, val);
            } catch (SQLException ex) {
                System.out.println("Key not foud in Result Set: "+FS1.getName());
                Logger.getLogger(Func.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                System.out.println("Error invoking Mthode " + FS1.getName() + " for class : '"+obj.getClass().getName()+"'");
                Logger.getLogger(Func.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return obj;
    }
    
}
