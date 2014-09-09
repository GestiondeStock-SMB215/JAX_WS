package net.smb215.lib;
public class QueryOrder {
    public enum Order{
        D("DESC"),
        A("ASC");
        private final String value;
        private Order(String value){
            this.value = value;
        }
        public String getValue(){
            return value;
        }
    }
    public String field = "";
    public Order order = Order.A;
    
    public QueryOrder(String field, Order order){
        this.field = field;
        this.order = order;
    }
    public String formattedOrder(){
        String formattedOrder;
        switch(order){
            case D:
                formattedOrder = "`" + field + "` DESC ";
                break;
            default:
                formattedOrder = "`" + field + "` ASC ";
        }
        return formattedOrder;
    }
}
