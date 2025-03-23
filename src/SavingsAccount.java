import java.math.BigDecimal;

public class SavingsAccount extends Account {
    
    private BigDecimal interestRate;


    SavingsAccount(String name, String email){
        super(name, email);
        this.interestRate = BigDecimal.valueOf(0.005);
    }

    public void applyInterest(){
        this.setBalance(this.getBalance().add(this.getBalance().multiply(interestRate)));
    }



    protected void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }
    
}