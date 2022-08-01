import java.util.ArrayList;
public class TestOrder {
    public static void main(String[] args) {
        
        // Menu items
        Item item1 = new Item("Mocha", 5.50 );
        Item item2 = new Item("Latte", 5.00 );
        Item item3 = new Item("Drip Coffee", 6.50 );
        Item item4 = new Item("Cappuccino", 4.00 );



        System.out.printf("Name: %s\n", item1.name);
        System.out.printf("Price: $%.2f\n", item1.price);
    
        // Order variables -- order1, order2 etc.
        Order order1 = new Order("Cindhuri");
        Order order2 = new Order("Jimmy");
        Order order3 = new Order("Noah");
        Order order4 = new Order("Sam");

        // Print the order1 variable to the console
        System.out.println(order1);
        // We see the object name along with a string referencing the memory location

        // Print total for order1
        System.out.printf("Order1 total: %s\n", order1.total);

        // Add item1 to order2
        order2.addItemToOrder(item1);
        System.out.printf("Order2 items: %s\n", order2.items.get(0).name);

        // Add cappuccino to order3
        order3.addItemToOrder(item4);
        System.out.printf("Order3 items: %s\n", order3.items.get(0).name);

        // Add latte to order4
        order4.addItemToOrder(item2);
        System.out.printf("Order4 items: %s\n", order4.items.get(0).name);

        // Update Cindhurri's order to ready
        order1.updateOrderStatus();
        System.out.printf("Order1 ready status: %s\n", order1.isReady);

        // Add 2 latte's to Sam's order
        order4.addItemToOrder(item2);
        order4.addItemToOrder(item2);
        System.out.printf("Order4 items: %s, %s, %s\n", order4.items.get(0).name, order4.items.get(1).name, order4.items.get(2).name);

        // Update Jimmy's oder to ready
        order2.updateOrderStatus();
        System.out.printf("Order2 ready status: %s\n", order2.isReady);
    }
}
