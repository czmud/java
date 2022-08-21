import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu = new ArrayList<Item>();
    private ArrayList<Order> orders = new ArrayList<Order>();

    public CoffeeKiosk(){
    }

    public Item addMenuItem( String name, Double price ){
        int index = this.menu.size();
        Item newItem = new Item( name, price, index );
        this.menu.add( newItem );
        return newItem;
    }

    public void displayMenu(){
        for ( Item menuItem : this.menu ){
            System.out.printf("%d %s -- $%.2f\n", menuItem.getIndex(), menuItem.getName(), menuItem.getPrice());
        }
    }

    public void newOrder() {
        
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
        Order addOrder = new Order(name);
        this.displayMenu();
        
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        Item addItem = null; 
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            for( Item menuItem : this.menu ){
                if ( menuItem.getIndex().equals( Integer.parseInt(itemNumber) )){
                    addItem = menuItem;
                    break;
                }
            }
            if( addItem == null ){
                System.out.println("item index not recognized.");
            } else {
                addOrder.getItems().add( addItem );
                System.out.printf("%s added to Order", addItem.getName() );
            }
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();

        }
        
        this.orders.add( addOrder );
        System.out.println("Thank you for your order.");
        addOrder.display();
        
    }


    public ArrayList<Item> getMenu(){
        return menu;
    }
    public ArrayList<Order> getOrders(){
        return orders;
    }
    public void setMenu( ArrayList<Item> menu){
        this.menu = menu;
    }
    public void setOrders( ArrayList<Order> orders ){
        this.orders = orders;
    }

}