import java.util.ArrayList;
public class CafeUtil {
    public int getStreakGoal(){
        int drinkSum = 0;
        for ( int i = 1; i <= 10; i++){
            drinkSum += i;
        }
        return drinkSum;
    }
    public int getStreakGoal( int numWeeks ){
        int drinkSum = 0;
        for ( int i = 1; i <= numWeeks; i++){
            drinkSum += i;
        }
        return drinkSum;
    }
    public double getOrderTotal(double[] prices){
        double priceTotal = 0;
        for ( int i = 0; i < prices.length ; i++){
            priceTotal += prices[i];
        }
        return priceTotal;
    }
    public void displayMenu(ArrayList<String> menuItems){
        for(int i = 0; i < menuItems.size(); i++){
            System.out.println(String.format("%d: %s", i, menuItems.get(i)));
        }
        return;
    }
    public void addCustomer( ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println(String.format("Hello, %s", userName));
        System.out.println(String.format("There are %d people in front of you.", customers.size()));
        customers.add(userName);
        System.out.println(customers);
        return;
    }


}

