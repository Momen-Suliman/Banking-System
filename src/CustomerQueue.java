class Node <T extends Customer> {
    T data;
    Node<T> next;

    public Node(T theCustomer) {
        data = theCustomer;
        next = null;
    }
}

public class CustomerQueue <T extends Customer> {
    private Node<T> front, rear;

    public CustomerQueue() {
        front = rear = null;
    }

    public void enqueue(T theCustomer) {
        Node<T> newCustomer = new Node<>(theCustomer);

        if(rear == null) {
            front = newCustomer;
            rear = newCustomer;
        } else {
            rear.next = newCustomer;
            rear = newCustomer;
        }
    }

    public T dequeue() {
        if(front == null){
            throw new IllegalStateException("Queue is empty!");
        }
        T data = front.data;
        front = front.next;

        if(front == null) {
            rear = null;
        }
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public T peek() {
        if(front == null) {
            throw new IllegalStateException("Queue is empty!");
        }
        return front.data;
    }
}