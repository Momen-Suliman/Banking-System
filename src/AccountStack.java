import java.util.ArrayList;
public class AccountStack <T extends Accounts> {

    private ArrayList<T> accStack;

    public AccountStack() {
        accStack = new ArrayList<>();
    }

    public boolean isEmpty() {
        return accStack.isEmpty();
    }

    public int size() {
        return accStack.size();
    }

    public void push(T acc) {
        accStack.add(acc);
    }

    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        else {
            accStack.remove(accStack.size() - 1);
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return accStack.get(accStack.size() - 1);
    }
}