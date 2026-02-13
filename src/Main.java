import java.io.*;
public class Main {
    public static void sop(String s) {
        System.out.println(s);
    }
    public static double rng() {
        return 10010000 + (Math.random() * (10099999 - 10010000));
    }
    public static Checking accGen() {
        Checking someChecking = new Checking((int) rng(), 0.0);
        return someChecking;
    }
    public static void main(String[] args) {

        Checking myChecking = new Checking((int) rng(), 0.0);
        myChecking.deposit(147.38);
        Customer me = new Customer("Momen Suliman", 900915295, myChecking);

        CustomerQueue<Customer> cusQue = new CustomerQueue<>();
        cusQue.enqueue(me);
        for (int i=0; i<9; i++) {
            Customer someCus = new Customer("John Doe", (int) rng(), accGen());
            cusQue.enqueue(someCus);
        }

        try {
            ObjectOutputStream customerWriter = new ObjectOutputStream(new FileOutputStream("Customers"));
            for (int i = 0; i < 10; i++) {
                customerWriter.writeObject(cusQue.dequeue());
            }
            customerWriter.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            ObjectInputStream customerReader = new ObjectInputStream(new FileInputStream("Customers"));
            Statements<Accounts> accPrinter = new Statements<>();
            Checking needInfo;
            for (int i = 0; i < 10; i++) {
                Customer toQueue = (Customer) customerReader.readObject();
                cusQue.enqueue(toQueue);
                needInfo = (Checking) toQueue.getAccount();
                sop("Name of customer is " + toQueue.getNameOfCustomer());
                sop("Customer's ID is " + toQueue.getCustomerID());
                sop("User's account number is " + needInfo.getAccountNumber());
                sop("User's balance is $" + needInfo.getBalance() + "\n");
            }
            customerReader.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        sop("data has been retrieved!");
    }
}