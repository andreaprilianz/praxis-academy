package contohkasus; 
/*
 * This Java source file was generated by the Gradle 'init' task.
 */

public class App {

    public static void main(String[] args) {
        Customer customer1 = new Customer("APRILIAN", "Lampung");
        Order order1 = new Order("baju", 50000, 2);
        customer1.order(order1);

        Customer customer2 = new Customer("HOLAN", "Lampung");
        Order order2 =  new Order("celana", 25000, 4);
        customer2.order(order2);

    }
}