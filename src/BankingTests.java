import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankingTests {

    // --- Accounts (via Checking) ---

    @Test
    void testInitialBalance() {
        Checking acc = new Checking(1001, 0.0);
        assertEquals(0.0, acc.getBalance());
    }

    @Test
    void testDeposit() {
        Checking acc = new Checking(1002, 0.0);
        acc.deposit(200.0);
        assertEquals(200.0, acc.getBalance());
    }

    @Test
    void testWithdraw() {
        Checking acc = new Checking(1003, 0.0);
        acc.deposit(300.0);
        acc.withdraw(100.0);
        assertEquals(200.0, acc.getBalance());
    }

    @Test
    void testCheckingAllowsOverdraft() {
        Checking acc = new Checking(1004, 0.0);
        acc.withdraw(50.0); // should NOT throw
        assertEquals(-50.0, acc.getBalance());
    }

    @Test
    void testSavingsBlocksOverdraft() {
        Savings acc = new Savings(2001, 0.0);
        acc.deposit(100.0);
        assertThrows(IllegalStateException.class, () -> acc.withdraw(200.0));
    }

    @Test
    void testDepositNegativeThrows() {
        Checking acc = new Checking(1005, 0.0);
        assertThrows(IllegalArgumentException.class, () -> acc.deposit(-50.0));
    }

    @Test
    void testWithdrawNegativeThrows() {
        Checking acc = new Checking(1006, 0.0);
        assertThrows(IllegalArgumentException.class, () -> acc.withdraw(-10.0));
    }

    // --- Customer ---

    @Test
    void testCustomerHoldsAccount() {
        Checking acc = new Checking(3001, 0.0);
        Customer cus = new Customer("Jane Doe", 111, acc);
        assertEquals(3001, cus.getCustomerAccountNumber());
        assertEquals("Jane Doe", cus.getNameOfCustomer());
        assertEquals(111, cus.getCustomerID());
    }

    @Test
    void testCustomerBalanceReflectsAccount() {
        Checking acc = new Checking(3002, 0.0);
        acc.deposit(500.0);
        Customer cus = new Customer("John Smith", 222, acc);
        assertEquals(500.0, cus.getCustomerBalance());
    }

    // --- AccountStack ---

    @Test
    void testStackPushAndPeek() {
        AccountStack<Checking> stack = new AccountStack<>();
        Checking acc = new Checking(4001, 0.0);
        stack.push(acc);
        assertEquals(acc, stack.peek());
    }

    @Test
    void testStackPop() {
        AccountStack<Checking> stack = new AccountStack<>();
        stack.push(new Checking(4002, 0.0));
        stack.push(new Checking(4003, 0.0));
        stack.pop();
        assertEquals(1, stack.size());
    }

    @Test
    void testStackPopEmptyThrows() {
        AccountStack<Checking> stack = new AccountStack<>();
        assertThrows(RuntimeException.class, stack::pop);
    }

    // --- CustomerQueue ---

    @Test
    void testQueueEnqueueDequeue() {
        CustomerQueue<Customer> queue = new CustomerQueue<>();
        Customer cus = new Customer("Alice", 555, new Checking(5001, 0.0));
        queue.enqueue(cus);
        assertEquals(cus, queue.dequeue());
    }

    @Test
    void testQueueOrder() {
        CustomerQueue<Customer> queue = new CustomerQueue<>();
        Customer first = new Customer("First", 1, new Checking(5002, 0.0));
        Customer second = new Customer("Second", 2, new Checking(5003, 0.0));
        queue.enqueue(first);
        queue.enqueue(second);
        assertEquals("First", queue.dequeue().getNameOfCustomer());
        assertEquals("Second", queue.dequeue().getNameOfCustomer());
    }

    @Test
    void testQueueDequeueEmptyThrows() {
        CustomerQueue<Customer> queue = new CustomerQueue<>();
        assertThrows(IllegalStateException.class, queue::dequeue);
    }

    @Test
    void testQueueIsEmpty() {
        CustomerQueue<Customer> queue = new CustomerQueue<>();
        assertTrue(queue.isEmpty());
        queue.enqueue(new Customer("Bob", 9, new Checking(5004, 0.0)));
        assertFalse(queue.isEmpty());
    }
}
