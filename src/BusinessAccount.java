import java.math.BigDecimal;

import exception.InvalidLoanTransactionException;

public class BusinessAccount extends Account {

    private BigDecimal maxLoan;
    private BigDecimal credit;

    BusinessAccount(String name, String email){
        super(name, email);
        this.maxLoan = BigDecimal.valueOf(13000);
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println(" Credit: " + credit);
    }

    public void loan(BigDecimal loanAmount){
        if(maxLoan.compareTo(loanAmount) < 0 || maxLoan.equals(credit)){
            throw new InvalidLoanTransactionException();
        }
        else{
            this.setBalance(this.getBalance().add(loanAmount));
            this.credit = loanAmount;
        }
    }

    public BigDecimal getCredit() {
        return credit;
    }


    public BigDecimal getMaxLoan() {
        return maxLoan;
    }

    
}
