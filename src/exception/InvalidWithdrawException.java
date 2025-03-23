package exception;

public class InvalidWithdrawException extends InvalidBankTransactionException {

    @Override
    public void printerrorMessage() {
        System.err.println("You don't have enough money for your withdraw request. Go get back to work.");
    }
    
}