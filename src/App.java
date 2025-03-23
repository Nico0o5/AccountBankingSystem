import java.math.BigDecimal;


public class App {
    public static void main(String[] args) {

        Bank bank = new Bank();
        String email = "hihaida@spinifexit.com";
        Account checkingAccount = new CheckingAccount("checking", email);
        SavingsAccount savingsAccount = new SavingsAccount("savings", email);

        checkingAccount.displayAccountInfo();
        savingsAccount.displayAccountInfo();

        bank.register(checkingAccount);
        bank.register(savingsAccount);
        checkingAccount.deposit(BigDecimal.valueOf(1000));
        savingsAccount.deposit(BigDecimal.valueOf(1000));
        

        Thread t1 = new Thread(new TransactionTask(savingsAccount, checkingAccount, bank), "User-1");
        Thread t2 = new Thread(new TransactionTask(savingsAccount, checkingAccount, bank), "User-2");

        t1.start();
        t2.start();

        

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance Savings Account: " + savingsAccount.getBalance());
        System.out.println("Final Balance Checking Account: " + checkingAccount.getBalance());


        // EmailValidator ev = new EmailValidator();



        // String rawEmail = "hihaida@spinifexit.com";

        // String email = ev.checkEmail(rawEmail) ? rawEmail : "N/A";

        // Account checkingAccount = new CheckingAccount("checking", email);
        // SavingsAccount savingsAccount = new SavingsAccount("savings", email);

        // checkingAccount.displayAccountInfo();
        // savingsAccount.displayAccountInfo();
        

        // IbankService bank = new Bank();


        // bank.register(checkingAccount);
        // bank.register(savingsAccount);

        // checkingAccount.deposit(BigDecimal.valueOf(13000));
        // savingsAccount.deposit(BigDecimal.valueOf(10000));

        // checkingAccount.displayAccountInfo();
        // savingsAccount.displayAccountInfo();

        // bank.transferFunds(savingsAccount, checkingAccount, BigDecimal.valueOf(500));

        // checkingAccount.displayAccountInfo();
        // savingsAccount.displayAccountInfo();

        // try {
        //     checkingAccount.withdraw(BigDecimal.valueOf(15000));
        // } catch (InvalidBankTransactionException e) {
        //     e.printerrorMessage();
        // }

        

        // checkingAccount.displayAccountInfo();

       
        // try {
        //     checkingAccount.deposit(BigDecimal.valueOf(-2515));
        // } catch (InvalidBankTransactionException e) {
        //     e.printerrorMessage();
        // }

        // checkingAccount.displayAccountInfo();

        // savingsAccount.applyInterest();

        // savingsAccount.displayAccountInfo();

        // BusinessAccount businessAccount = new BusinessAccount("Business", email);

        // businessAccount.loan(BigDecimal.valueOf(500));
        // businessAccount.displayAccountInfo();


    }
}
