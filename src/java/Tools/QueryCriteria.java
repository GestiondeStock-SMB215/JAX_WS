package Tools;

/**
 *
 * @author jouj
 */
public class QueryCriteria {

    public enum Operand {

        EQUALS("="),
        IN("in"),
        NOTIN("not in"),
        LARGERTHAN(">"),
        LESSTHAN("<");
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

}
