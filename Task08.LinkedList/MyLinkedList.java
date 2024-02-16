import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList <T> implements Iterable<T> {

    private int size;
    private Node head;
    private Node current;

    public MyLinkedList() {
        this.size = 0;
        this.head = null;
    }


    private class Node {
        private T data;
        private Node next;
        // 데이터만 받는 경우와, 다음 포인터 객체를 받는 경우를 위한 생성자
        Node(T data) {
            this.data = data;
            this.next = null;
        }
        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    public void add(T t) {
        if (head == null) {
            head = new Node(t);
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(t);
        }
        this.size++;
    }

    public T get(int idx) {
        if (idx >= this.size || idx < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node curr = head;
        for (int i = 0; i < idx; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    public boolean delete(int idx){
        if(idx >= this.size || idx < 0){
            throw new IndexOutOfBoundsException();
        }
        if (idx == 0) {
            head = head.next;
            this.size--;
            return true;
        }
        Node pre = head;
        for (int i = 0; i < idx - 1; i++) {
            pre = pre.next;
        }
        Node curr = pre.next;
        pre.next = curr.next;
        this.size--;
        return true;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }

}