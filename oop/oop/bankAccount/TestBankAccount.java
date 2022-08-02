public class TestBankAccount {
    public static void main( String[] args ){

        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount( 750, 2000 );

        account1.depositToChecking( 450 );
        account2.depositToChecking( 275 );
        account2.withdrawFromSavings( 500 );

        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getSavingsBalance());
        System.out.println(account1.getTotalBalance());
        System.out.println(account2.getCheckingBalance());
        System.out.println(account2.getSavingsBalance());
        System.out.println(account2.getTotalBalance());


        account1.withdrawFromSavings(500);
        account1.withdrawFromChecking(200);
        account1.withdrawFromChecking(500);
    }
}