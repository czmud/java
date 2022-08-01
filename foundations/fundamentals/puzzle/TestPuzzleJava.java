import java.util.ArrayList;
import java.util.Random;
public class TestPuzzleJava {
    public static void main(String[] args) {
        PuzzleJava generator = new PuzzleJava();
        ArrayList<Integer> randomRolls = generator.getTenRolls();
        System.out.println(randomRolls);
        
        
        char nextChar = generator.getRandomLetter();
        System.out.println( nextChar );

        String newPassword = generator.generatePassword();
        System.out.println( newPassword );

        ArrayList<String> newPasswordSet1 = generator.getNewPasswordSet( 3 );
        ArrayList<String> newPasswordSet2 = generator.getNewPasswordSet( 12 );
        System.out.println(newPasswordSet1);
        System.out.println(newPasswordSet2);

        generator.shuffleArray( newPasswordSet2 );
        System.out.println(newPasswordSet2);
    }
}
