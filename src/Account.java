
import java.math.BigDecimal;

import exception.InvalidDepositAmountException;
import exception.InvalidWithdrawException;

public abstract class Account {

    private static long count = 0;
    private long accountNumber;
    private String ownerName;
    private String email;
    private BigDecimal balance = BigDecimal.ZERO;

    Account(String name, String email){
        count++;
        this.ownerName = name;
        this.accountNumber = count;
        this.email = email;
    }

    public void deposit(BigDecimal depositAmount){
        if(depositAmount.compareTo(BigDecimal.valueOf(0)) < 0){
           throw new InvalidDepositAmountException();
        }
        else{
            this.setBalance(this.balance.add(depositAmount));
            System.out.println(Thread.currentThread().getName());
            System.out.println("Deposit Sucess! Financial responsibility +1! "); 
        }
            
    }

    public void withdraw(BigDecimal withdrawAmount){
        if(balance.compareTo(withdrawAmount) < 0){ // check if the balance is less than the withdraw amount
            throw new InvalidWithdrawException();
        }
        else{
            this.setBalance(balance.subtract(withdrawAmount));
            System.out.println(Thread.currentThread().getName());
            System.out.println("Withdraw Sucess! Hope it lasts a day!"); 
        }
    }

    public void displayAccountInfo(){
       String str = "%n Account Number: %d %n Owner Email: %s %n Account Holder: %S %n Balance: %,.2f";
       System.out.println(String.format(str, accountNumber, email, ownerName, balance));
    }  

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}