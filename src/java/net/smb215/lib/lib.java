package net.smb215.lib;


import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author henry_kozhaya
 */
public class lib {

    public static String SQL_Path = "c:\\javaApp\\JAX_WS\\sql\\";
    public static String App_Path = "c:\\javaApp\\JAX_WS\\";
    public static String log_file = "log.txt";
    public static String cnx = "jdbc/gss";
    
    public static void logToFile(String contents) {
        try {
            contents = getCurDateTime() + " - " + contents + "\n";
            byte[] bytes = contents.getBytes();
            String fullPathFilename = App_Path + log_file;
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fullPathFilename, true));
            bos.write(bytes);
            bos.flush();
            bos.close();
        } catch (Exception ex) {
        }
    }

    public static void SaveTextToFile(String contents, String FileName) throws Exception {
        String fullPathFilename = App_Path + FileName;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullPathFilename))) {
            writer.write(contents);
            writer.flush();
        }
    }
    
    public static String GetFileContents(String pathname) throws Exception {
        File file = new File(pathname);
        StringBuilder fileContents = new StringBuilder((int) file.length());
        Scanner scanner = new Scanner(file);
        String lineSeparator = System.getProperty("line.separator");
        try {
            if (scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine());
            }
            while (scanner.hasNextLine()) {
                fileContents.append(lineSeparator + scanner.nextLine());
            }
            return fileContents.toString();
        } finally {
            scanner.close();
        }
    }
    
    public static String getCurDateTime(){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd H:m:s");
            Date d = new Date();
            return String.valueOf(df.format(d));
    }      
    
    public static String ReadSelect(String FileName, String... Var) {
        String sContents = "";
        String SelectPath;
        try {
            SelectPath = SQL_Path + FileName + ".sql";
            sContents = GetFileContents(SelectPath);
            for (int i = 0; i < Var.length; i++) {
                sContents = sContents.replace("{" + (i + 1) + "}", Var[i]);
            }

        } catch (Exception Ex) {
            sContents = null;
            logToFile(Ex.toString());
        } finally {
            return sContents;
        }
    }
    
    public static ResultSet exeSelect(String inSelect) {
        ResultSet rs = null;
        try {
            InitialContext ctx = new InitialContext();
            //The JDBC Data source that we just created
            DataSource ds = (DataSource) ctx.lookup(cnx);
            Connection connection = ds.getConnection();
            if (connection == null) {
                throw new SQLException("Error establishing connection!");
            }
            PreparedStatement statement = connection.prepareStatement(inSelect);
            
            //To test the querry
            //SaveTextToFile(inSelect, "Querry.txt");
            
            rs = statement.executeQuery();
            connection.close();
            connection = null;
        } catch (Exception ex) {
            logToFile("error - " + ex.toString());
        } finally {
            return rs;
        }
    }
    
    public static int exeSQLCmd(String inSQL) {
        int updateCount = 0;
        try {
            InitialContext ctx = new InitialContext();
            //The JDBC Data source that we just created
            DataSource ds = (DataSource) ctx.lookup(cnx);
            Connection connection = ds.getConnection();
            if (connection == null) {
                throw new SQLException("Error establishing connection!");
            }

            Statement stmt = connection.createStatement();
            // Execute the insert statement
            updateCount = stmt.executeUpdate(inSQL);
            // updateCount contains the number of updated rows

            connection.close();
            connection = null;
        } catch (Exception ex) {
            logToFile("error - " + ex.toString());
        } finally {
            return updateCount;
        }
    }    
    
    
//    UNUSED TILL NOW    
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

}