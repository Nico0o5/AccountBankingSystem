import java.math.BigDecimal;

public interface IbankService {

    void register(Account account);

    void transferFunds(Account sAccount, Account desAccount, BigDecimal amount);
    
}