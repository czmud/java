import java.util.ArrayList;
public class TestExceptions {
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48.0);
        myList.add("Goodbye World");

        //I think the type casting only works for primitive variable types
        //It doesn't like the idea of casting Double -> Integer...
        double testVal = 48.89237;
        int testCastVal = (int) testVal;
        System.out.println(testCastVal);
        
        for(int i = 0; i < myList.size(); i++) {
            try{
                Integer castedValue = (Integer) myList.get(i);
            } 
            catch (ClassCastException e){
                System.out.println("That didn't work so great...");
                System.out.println(String.format("We got ourselves an error at index : %d", i));
                System.out.println(e);
            }
        }
    }
}