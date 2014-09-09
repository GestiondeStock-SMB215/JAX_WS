package net.smb215.lib;
public class QueryCriteria {

    public enum Operand {

        EQUALS("="),
        NOTEQUALS("!="),
        IN("in"),
        NOTIN("not in"),
        LARGERTHAN(">"),
        LESSTHAN("<"),
        LARGERTHANOREQUAL(">="),
        LESSTHANOREQUAL("<="),
        LEFTLIKE("like"),
        RIGHTLIKE("like"),
        LIKE("like");
        private final String value;

        private Operand(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    public String field = "";
    public String value = "";
    public Operand operand = Operand.EQUALS;

    public QueryCriteria(String field, String value, Operand operand) {
        this.field = field;
        this.value = value;
        this.operand = operand;
    }
    
    /**
     *
     * @return
     */
    public String formatCriteria(){
        String formattedCriteria;
        switch(operand){
            case RIGHTLIKE:
                formattedCriteria = "`" + field + "` like '" + value + "%' " ;
            break;
                
            case LEFTLIKE:
                formattedCriteria = "`" + field + "` like '%" + value + "' " ;
            break;
                
            case LIKE:
                formattedCriteria = "`" + field + "` like '%" + value + "%' " ;
            break;
                
            case IN:
                formattedCriteria = "`" + field + "` in (" + value + ") " ;
            break;
                
            case NOTIN:
                formattedCriteria = "`" + field + "` notin (" + value + ") " ;
            break;
            
            default:
                formattedCriteria = "`" + field + "` "+ operand.getValue() + " '" + value + "' ";
            break;
                
        }
        return formattedCriteria;
    }

}
