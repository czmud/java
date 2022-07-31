import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        return String.format("Hello, %s. Lovely to see you.", name);
    }
    
    public String dateAnnouncement() {
        // Calendar currentDate = Calendar.getInstance();
        // return String.format("The current date is %d", currentDate.get( Calendar.DAY_OF_WEEK ) );
        // Date class is almost completely deprecated.... why they making us use it?
        Date currentDate = new Date();
        return "It is currently " + currentDate;
    }
    
    public String respondBeforeAlexis(String conversation) {
        String verbalResponse;
        if ( conversation.indexOf("Alexis") != -1 ){
            verbalResponse = "Right away, sir. She certainly isn't sophisticated enough for that.";
        } else if ( conversation.indexOf("Alfred") != -1 ){
            verbalResponse = "At your service. As you wish, naturally.";
        } else {
            verbalResponse = "Right. And with that I shall retire.";
        }
        return verbalResponse;
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

