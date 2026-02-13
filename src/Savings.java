import java.io.Serializable;
import java.lang.*;
public class Savings extends Accounts implements Serializable {

    public Savings (Integer aNum, Double aBalance) {
        setAccountNumber(aNum);
        setBalance(aBalance);
    }

    @Override
    public void withdraw(Double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive.");
        if (getBalance() - amount < 0) throw new IllegalStateException("Insufficient funds: Savings accounts do not allow overdraft.");
        setBalance(getBalance() - amount);
    }
}