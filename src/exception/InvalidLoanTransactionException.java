package exception;

public class InvalidLoanTransactionException extends InvalidBankTransactionException {

    public void printerrorMessage(){
        System.err.println("You're too greedy for someone who borrow money!");
    }

}
