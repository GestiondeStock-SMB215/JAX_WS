package Tools;

import java.util.Calendar;

/**
 *
 * @author jouj
 */
public class Func {
    public static String NOW(){
        return new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()).toString();
    }
}
