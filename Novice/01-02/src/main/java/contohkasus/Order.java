package contohkasus;

/**
* custumer
*/
public class Order {

    private String Know_placement_date;
    private String delivery_date;
    private String order_items;
    private int amount;
    private int total;
    private int price_items;
    private String applicable_taxes;
    private String order_number;

    public Order(String order_items, int price_items, int amount) {
        this.order_items = order_items;
        this.price_items = price_items;
        this.amount = amount;
    }
    public void orderItemDetail(){
        total = price_items * amount;

        System.out.println("--------your detail order-----");
        System.out.println("name item : " + order_items);
        System.out.println("price item : " + price_items);
        System.out.println("amount item : " + amount);
        System.out.println("total : " + total);
    

    }

}