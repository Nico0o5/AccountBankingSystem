import java.math.BigDecimal;
import java.util.Random;

public class TransactionTask implements Runnable{

    private Account account1;
    private Account account2;
    private Bank bank;
    private Random random = new Random();

    public TransactionTask(Account account1, Account account2, Bank bank) {
        this.account1 = account1;
        this.account2 = account2;
        this.bank = bank;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            BigDecimal amount = BigDecimal.valueOf(400);
            int action = 1;
            if (action == 0) {
                System.out.println("BALANCE: " + account1.getBalance());
                System.out.println("Deposit " + Thread.currentThread().getName() + " " + amount);

                account1.deposit(amount);
            } else if (action == 1) {
                System.out.println("BALANCE: " + account1.getBalance());

                System.out.println("Withdrawing " + Thread.currentThread().getName() + " " + amount);
                account1.withdraw(amount);

            } else {
                System.out.println("BALANCE: " + account1.getBalance());

                System.out.println("Transfering " + Thread.currentThread().getName() + " " + amount);

                bank.transferFunds(account1, account2, amount);
            }
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    
}
