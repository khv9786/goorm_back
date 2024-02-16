import java.util.EmptyStackException;

public class MyStack<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();
    private int size;
    private Node head;

    private class Node {
        T data;
        Node next;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public MyStack() {
        this.head = new Node(null, null); // head is a sentinel node
        this.size = 0;
    }

    public synchronized void push(T data) {
        Node node = new Node(data, head.next);
        head.next = node;
        size++;
    }

    public synchronized T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node node = head.next;
        head.next = node.next;
        size--;
        return node.data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return head.next.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}