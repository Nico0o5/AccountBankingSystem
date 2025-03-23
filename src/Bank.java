import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import exception.InvalidWithdrawException;

public class Bank implements IbankService {

    List<Account> accounts = new ArrayList<>();

    public void register(Account account){
        accounts.add(account);
    }

    public void transferFunds(Account sAccount, Account desAccount, BigDecimal amount){

        Account source = accounts.get(accounts.indexOf(sAccount));
        Account destination = accounts.get(accounts.indexOf(desAccount));

        if(source.getBalance().compareTo(amount) < 0){
             throw new InvalidWithdrawException();
        }

        source.setBalance(source.getBalance().subtract(amount));
        destination.setBalance(destination.getBalance().add(amount));
    }
    
}