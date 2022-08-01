import java.util.ArrayList;
public class Order {
    public String name;
    public double total;
    public boolean isReady;
    public ArrayList<Item> items = new ArrayList<Item>();

    public Order (String name){
        this.name = name;
    }
    public void addItemToOrder(Item newItem){
        this.items.add(newItem);
        this.total += newItem.price;
        return;
    }
    public void updateOrderStatus() {
        this.isReady = ! this.isReady;
        return;
    }
}
