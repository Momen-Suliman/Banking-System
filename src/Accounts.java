import java.io.Serializable;
import java.lang.*;
public abstract class Accounts implements Serializable {

    private Integer accountNumber;
    public void setAccountNumber(Integer accNum){
        accountNumber = accNum;
    }
    public Integer getAccountNumber(){
        return accountNumber;
    }

    private Double balance = 0.0;
    public void setBalance(Double newBalance){
        balance = newBalance;
    }
    public void deposit(Double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive.");
        balance += amount;
    }
    public void withdraw(Double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive.");
        balance -= amount;
    }
    public Double getBalance(){
        return balance;
    }
}