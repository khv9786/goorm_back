public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        MyStack<String> myStack = new MyStack<>();
        MyQueue<String> myQueue = new MyQueue<>();
        System.out.println("큐 테스트 ==========================");
        for (int i = 0; i < 4; i++) {
            myQueue.offer(i + "");
            System.out.printf("offer: " + i + " ");
        }
        System.out.println("");


        System.out.println("Peek: " + myQueue.peek());

        System.out.println("Poll: " + myQueue.poll());
        System.out.println("Poll: " + myQueue.poll());

        System.out.println("Size: " + myQueue.size());

        myQueue.clear();
        System.out.println("clear 사이즈: " + myQueue.size());
        System.out.println("큐 종료 ==========================");

        System.out.println("스택 테스트 ==========================");
        for (int i = 0; i < 4; i++) {
            myStack.push(i + "");
            System.out.printf("push: " + i + " ");
        }
        System.out.println("");
        System.out.println("peek: " + myStack.peek());
        for (int i = 0; i < 3; i++) {
            System.out.println("pop: " + myStack.pop());
        }
        System.out.println("스택 종료 ==========================");

        System.out.println("링크드 리스트 테스트 ==========================");
        myLinkedList.add("김밥");
        myLinkedList.add("라면");
        myLinkedList.add("떡볶이");

        for (String s : myLinkedList) {
            System.out.printf("add: " + s+" ");
        }
        System.out.println("");

        System.out.println("인덱스 0의 요소: " + myLinkedList.get(0));
        System.out.println("인덱스 1의 요소: " + myLinkedList.get(1));
        System.out.println("인덱스 2의 요소: " + myLinkedList.get(2));

        System.out.println("리스트의 크기: " + myLinkedList.size());

        myLinkedList.delete(1);
        System.out.println("삭제 후 인덱스 1의 요소: " + myLinkedList.get(1));
        System.out.println("삭제 후 리스트의 크기: " + myLinkedList.size());

        System.out.println("리스트가 비어 있습니까? " + myLinkedList.isEmpty());
        myLinkedList.delete(0);
        myLinkedList.delete(0);
        System.out.println("리스트가 비어 있습니까? " + myLinkedList.isEmpty());
        System.out.println("링크드 리스트 종료 ==========================");
    }
}