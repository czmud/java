import java.util.ArrayList;
public class Order {
    private String name;
    private boolean isReady;
    private ArrayList<Item> items = new ArrayList<Item>();

    public Order () {
        this.name = "Guest";
    }
    public Order (String name) {
        this.name = name;
    }

    // ORDER METHODS
    public void addItem(Item newItem) {
        this.items.add(newItem);
        return;
    }
    public String getStatusMessage(){
        if ( isReady ){
            return "Your order is ready.";
        } else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }
    public double getOrderTotal(){
        double orderTotal = 0;
        for ( Item item : items ) {
            orderTotal += item.getPrice();
        }
        return orderTotal;
    }
    public void display(){
        System.out.printf("Customer “Name: %s\n", name);
        for ( Item item : items ) {
            System.out.printf("%s - $%.2f\n", item.getName(), item.getPrice());
        }
        System.out.printf("Total: $%.2f\n", getOrderTotal());
        return;
    }

    // GETTERS & SETTERS
    public String getName() {
        return name;
    }
    public boolean isOrderReady() {
        return isReady;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public void setName( String name ) {
        this.name = name;
    }
    public void updateOrderStatus() {
        this.isReady = ! this.isReady;
        return;
    }


}
