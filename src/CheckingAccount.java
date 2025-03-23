import java.math.BigDecimal;

import exception.InvalidWithdrawException;

public class CheckingAccount extends Account {
    
    private BigDecimal overdraftLimit;


    CheckingAccount(String name, String email){
        super(name, email);
        this.overdraftLimit = BigDecimal.valueOf(500);
    }

    CheckingAccount(String name, BigDecimal overdraftLimit, String email){
        super(name, email);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public synchronized void withdraw(BigDecimal withdrawAmount){

        if(this.getBalance().compareTo(BigDecimal.valueOf(0)) < 0){
            throw new InvalidWithdrawException();
        }

        BigDecimal max = this.getBalance().add(overdraftLimit);
        if(max.compareTo(withdrawAmount) < 0){
           throw new InvalidWithdrawException();
        }
        else{
            BigDecimal newBalance = this.getBalance().subtract(withdrawAmount);
            this.setBalance(newBalance);
            System.out.println("Withdraw Sucess! Hope it lasts a day!");
        }
    }

    public void setOverdraftLimit(BigDecimal overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public BigDecimal getOverdraftLimit() {
        return overdraftLimit;
    }
    
}