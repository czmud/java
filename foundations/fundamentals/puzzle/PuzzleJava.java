import java.util.ArrayList;
import java.util.Random;
public class PuzzleJava {
    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> resultsArray = new ArrayList<Integer>();
        Random rnd = new Random();
        for ( int i = 0; i < 10; i++ ) {
            resultsArray.add(rnd.nextInt( 21 ));
        }
        return resultsArray;
    }
    public char getRandomLetter() {
        char[] lettersArray = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        Random rnd = new Random();
        return lettersArray[rnd.nextInt( 26 )];
    }
    public String generatePassword() {
        String passwordString = new String();
        for ( int i = 0; i < 8; i++ ){
            passwordString += getRandomLetter();
        }
        return passwordString;
    }
    public ArrayList<String> getNewPasswordSet( int passwordCount ){
        ArrayList<String> resultsPasswordSet = new ArrayList<String>();
        for ( int i = 0; i < passwordCount; i++ ){
            resultsPasswordSet.add(generatePassword());
        }
        return resultsPasswordSet;
    }
    public void shuffleArray( ArrayList<String> startArray ) {
        Random rnd = new Random();
        int pos1, pos2;
        String temp;
        for ( int i = 0; i<startArray.size(); i++ ){
            //determine positions to swap
            pos1 = rnd.nextInt(startArray.size());
            pos2 = rnd.nextInt(startArray.size());
            //now do the swap them
            temp = startArray.get(pos1);
            startArray.set(pos1, startArray.get(pos2));
            startArray.set(pos2, temp);
        }
        return;
    }
}