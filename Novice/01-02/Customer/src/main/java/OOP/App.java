/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package OOP;

public class App {

    public static void main(String[] args) {
        Customer c1 = new Customer("APRILIAN", "Lampung");
        Order order1 = new Order("Baju", 25000, 2);
        c1.order(order1);

        Customer c2 = new Customer("HOLAN", "Lampung");
        Order order2 = new Order("Baju", 25000, 2);
        c2.order(order2);
    }
}