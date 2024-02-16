import java.util.NoSuchElementException;

public class MyQueue<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();
    private int size;
    private Node head;
    private Node tail;

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public MyQueue() {
        this.head = new Node(null); // Create a dummy head node to simplify operations
        this.tail = this.head;
        this.size = 0;
    }

    public synchronized void offer(T data) {
        Node node = new Node(data);
        this.tail.next = node; // Link the new node as last node
        this.tail = node;      // Update the tail to the new node
        this.size++;           // Increment the size
    }

    public synchronized T poll() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node node = this.head.next; // The first real node is after dummy head
        this.head.next = node.next; // Remove the first real node from the list
        node.next = null;           // Help with garbage collection
        this.size--;

        if(this.head.next == null){ // If the list is now empty, reset tail to head
            this.tail = this.head;
        }

        return node.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.head.next.data; // Return data of the first real node
    }

    public synchronized void clear() {
        this.head.next = null; // Remove all elements
        this.tail = this.head; // Reset tail to the dummy head
        this.size = 0;         // Reset size
    }
}