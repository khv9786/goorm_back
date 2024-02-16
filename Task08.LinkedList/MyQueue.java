import java.util.NoSuchElementException;

public class MyQueue<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void offer(T element) {
       list.add(element);
    }

    public T poll() {
        if(list.isEmpty()){
            throw new NoSuchElementException();
        }
        T element = list.get(0);
        list.delete(0);
        return element;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public T peek() {
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.get(0); // Return data of the first real node
    }

    public synchronized void clear() {
        while (!list.isEmpty()) {
            list.delete(0);
        }
    }
}