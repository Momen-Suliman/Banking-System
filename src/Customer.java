import java.io.Serializable;
public class Customer implements Serializable {

    public Customer(String aName,Integer cusID, Accounts anAccount){
        nameOfCustomer = aName;
        customerID = cusID;
        userAccount = anAccount;
    }

    private Accounts userAccount;
    public void setUserAccount(Accounts cusAcc) {
        userAccount = cusAcc;
    }
    public Accounts getAccount() {
        return userAccount;
    }

    private String nameOfCustomer;
    public void setNameOfCustomer(String cusName){
        nameOfCustomer = cusName;
    }
    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

    private Integer customerID;
    public void setCustomerID(Integer cusNum){
        customerID = cusNum;
    }
    public Integer getCustomerID() {
        return customerID;
    }
    public Integer getCustomerAccountNumber() {
        return userAccount.getAccountNumber();
    }
    public Double getCustomerBalance() {
        return userAccount.getBalance();
    }
}