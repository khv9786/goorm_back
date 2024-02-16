import java.util.NoSuchElementException;
public class MyStack<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void push(T element) {
        list.add(element); // Elements are added to the end for simplicity
    }

    public T pop() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        // Retrieve the last element to simulate stack behavior
        T element = list.get(list.size() - 1);
        list.delete(list.size() - 1);
        return element;
    }

    public T peek() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        // Retrieve the last element without removing it
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}