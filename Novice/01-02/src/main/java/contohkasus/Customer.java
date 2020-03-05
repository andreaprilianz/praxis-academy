package contohkasus;

/**
* custumer
*/
public class Customer{
    private String place_order;
    private String know_name;
    private String know_address;
    private String know_customer_number;
    private String order_history;

    public Customer(String know_name, String know_address){
        this.know_name = know_name;
        this.know_address = know_address;
    }
    public void order(Order order){
        order.orderItemDetail();
    }
}