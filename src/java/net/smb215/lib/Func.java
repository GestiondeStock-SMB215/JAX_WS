package net.smb215.lib;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Func {
    public static String SQL_Path = "c:\\javaApp\\JAX_WS\\sql\\";
    public static String App_Path = "c:\\javaApp\\JAX_WS\\";
    public static String log_file = "log.txt";
    public static String cnx = "jdbc/gss";

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
    
    public static void logToFile(String contents) {
        try {
            contents = NOW() + " - " + contents + "\n";
            byte[] bytes = contents.getBytes();
            String fullPathFilename = App_Path + log_file;
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fullPathFilename, true));
            bos.write(bytes);
            bos.flush();
            bos.close();
        } catch (Exception ex) {
        }
    }

//    UNUSED TILL NOW    
//    ---------------
//    
//    public static void SaveTextToFile(String contents, String FileName) throws Exception {
//        String fullPathFilename = App_Path + FileName;
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullPathFilename))) {
//            writer.write(contents);
//            writer.flush();
//        }
//    }
//    
//    public static String GetFileContents(String pathname) throws Exception {
//        File file = new File(pathname);
//        StringBuilder fileContents = new StringBuilder((int) file.length());
//        Scanner scanner = new Scanner(file);
//        String lineSeparator = System.getProperty("line.separator");
//        try {
//            if (scanner.hasNextLine()) {
//                fileContents.append(scanner.nextLine());
//            }
//            while (scanner.hasNextLine()) {
//                fileContents.append(lineSeparator + scanner.nextLine());
//            }
//            return fileContents.toString();
//        } finally {
//            scanner.close();
//        }
//    }
//    
//    public static String ReadSelect(String FileName, String... Var) {
//        String sContents = "";
//        String SelectPath;
//        try {
//            SelectPath = SQL_Path + FileName + ".sql";
//            sContents = GetFileContents(SelectPath);
//            for (int i = 0; i < Var.length; i++) {
//                sContents = sContents.replace("{" + (i + 1) + "}", Var[i]);
//            }
//
//        } catch (Exception Ex) {
//            sContents = null;
//            logToFile(Ex.toString());
//        } finally {
//            return sContents;
//        }
//    }
//    
//    public static ResultSet exeSelect(String inSelect) {
//        ResultSet rs = null;
//        try {
//            InitialContext ctx = new InitialContext();
//            //The JDBC Data source that we just created
//            DataSource ds = (DataSource) ctx.lookup(cnx);
//            Connection connection = ds.getConnection();
//            if (connection == null) {
//                throw new SQLException("Error establishing connection!");
//            }
//            PreparedStatement statement = connection.prepareStatement(inSelect);
//            
//            //To test the querry
//            //SaveTextToFile(inSelect, "Querry.txt");
//            
//            rs = statement.executeQuery();
//            connection.close();
//            connection = null;
//        } catch (Exception ex) {
//            logToFile("error - " + ex.toString());
//        } finally {
//            return rs;
//        }
//    }
//    
//    public static int exeSQLCmd(String inSQL) {
//        int updateCount = 0;
//        try {
//            InitialContext ctx = new InitialContext();
//            //The JDBC Data source that we just created
//            DataSource ds = (DataSource) ctx.lookup(cnx);
//            Connection connection = ds.getConnection();
//            if (connection == null) {
//                throw new SQLException("Error establishing connection!");
//            }
//
//            Statement stmt = connection.createStatement();
//            // Execute the insert statement
//            updateCount = stmt.executeUpdate(inSQL);
//            // updateCount contains the number of updated rows
//
//            connection.close();
//            connection = null;
//        } catch (Exception ex) {
//            logToFile("error - " + ex.toString());
//        } finally {
//            return updateCount;
//        }
//    }    
//    public static String getDateTime(Date date){
//            SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd H:m:s");
//            return String.valueOf(date_format.format(date));
//    }
//
//
//    
//    public static Date strToDate(String strDate) throws ParseException{
//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        Date date = format.parse(strDate);
//        return date;
//    }
//    
//    //UNUSED TILL NOW
//

//
//
//
//    public static String formattedDate(String format) {
//        Format formatter = new SimpleDateFormat(format);
//        String s = formatter.format(new Date());
//        return s;
//    }
//
//    public static String changeDateFormat(Date date){
//            SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
//            return String.valueOf(date_format.format(date));
//    }
//    
//    public static String getCurDateTime(){
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd H:m:s");
//            Date d = new Date();
//            return String.valueOf(df.format(d));
//    }      
    
}