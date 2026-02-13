import java.io.Serializable;
import java.lang.*;
public class Checking extends Accounts implements Serializable {

    public Checking (Integer aNum, Double aBalance){
        setAccountNumber(aNum);
        setBalance(aBalance);
    }
}