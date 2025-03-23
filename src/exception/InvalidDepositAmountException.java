package exception;

public class InvalidDepositAmountException extends InvalidBankTransactionException {

    @Override
    public void printerrorMessage() {
        System.err.println("How can you deposit a negative value? You dunderhead!");
    }
    
}