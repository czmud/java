public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 4.25;
        double dripCoffeePrice = 2.5;
        double lattePrice = 3.5;
        double cappuccinoPrice = 3.25;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        if ( isReadyOrder1 ){
            System.out.println( customer1 + readyMessage );
            System.out.println( displayTotalMessage + dripCoffeePrice );
        } else {
            System.out.println( customer1 + pendingMessage );
        }
                if ( isReadyOrder4 ){
            System.out.println( customer4 + readyMessage );
            System.out.println( displayTotalMessage + cappuccinoPrice );
        } else {
            System.out.println( customer4 + pendingMessage );
        }
        if ( isReadyOrder2 ){
            System.out.println( customer2 + readyMessage );
            System.out.println( displayTotalMessage + 2*lattePrice );
        } else {
            System.out.println( customer2 + pendingMessage );
        }
        
        System.out.println( displayTotalMessage + (lattePrice - dripCoffeePrice));
    }
}
