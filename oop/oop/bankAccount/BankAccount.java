import java.util.Random;
public class BankAccount {
    private long accountNumber;
    private double checkingBalance;
    private double savingsBalance;
    public static int numberOfBankAccounts;
    public static double totalMoneyInAllBankAccounts;

    public BankAccount() {
        accountNumber = generateAccountNumber();
        numberOfBankAccounts++;
    }
    public BankAccount( double checkingBalance, double savingsBalance) {
        this.checkingBalance = checkingBalance; 
        this.savingsBalance = savingsBalance;
        numberOfBankAccounts++;
    }

    // GETTERS & SETTERS
    public double getCheckingBalance() {
        return checkingBalance;
    }
    public double getSavingsBalance() {
        return savingsBalance;
    }
    public double getTotalBalance(){
        return checkingBalance + savingsBalance;
    }
    public void depositToSavings( double deposit ){
        savingsBalance += deposit;
        System.out.printf("Deposit Complete!\nNew Balance: $%.2f\n", savingsBalance);
        return;
    }
    public void depositToChecking( double deposit ){
        checkingBalance += deposit;
        System.out.printf("Deposit Complete!\nNew Balance: $%.2f\n", checkingBalance);
        return;
    }
    public void withdrawFromSavings( double withdrawal ) {
        if ( savingsBalance - withdrawal >= 0 ){
            savingsBalance -= withdrawal;
            System.out.printf("Withdrawal Complete!\nNew Balance: $%.2f\n", savingsBalance);
        } else {
            System.out.println("Insufficient Funds. No withdrawal made.");
        }
        return;
    }
    public void withdrawFromChecking( double withdrawal ) {
        if ( checkingBalance - withdrawal >= 0 ){
            checkingBalance -= withdrawal;
            System.out.printf("Withdrawal Complete!\nNew Balance: $%.2f\n", checkingBalance);
        } else {
            System.out.println("Insufficient Funds. No withdrawal made.");
        }
        return;
    }




    private static long generateAccountNumber() {
        Random rnd = new Random();
        long newAccountNumber = 0;
        long nextNumber;
        long numberBase = 1;
        for ( int i = 0; i < 10; i++) {
            nextNumber = rnd.nextInt(10)*numberBase;
            newAccountNumber += nextNumber;
            numberBase *= 10;
        }
        return newAccountNumber;
    }

}