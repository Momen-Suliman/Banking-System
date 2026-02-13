public class Statements <T extends Accounts> {
    private T infoToPrint;

    public Statements() {
        infoToPrint = null;
    }
    public void printStatement(T accToPrint) {
        infoToPrint = accToPrint;
        System.out.println("User's account number is " + infoToPrint.getAccountNumber());
        System.out.println("User's balance is $" + infoToPrint.getBalance() + "\n");
    }
}