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
        System.out.println("큐가 비어있나요?: " + myQueue.isEmpty());
        System.out.println("큐 종료 ==========================");

        System.out.println("스택 테스트 ==========================");
        for (int i = 0; i < 4; i++) {
            myStack.push(i + "");
            System.out.printf("push: " + i + " ");
        }
        System.out.println("");
        System.out.println("스택의 크기는?: " + myStack.size());
        System.out.println("peek: " + myStack.peek());
        for (int i = 0; i < 3; i++) {
            System.out.printf("pop: " + myStack.pop()+" ");
        }
        System.out.println("");
        System.out.println("스택 종료 ==========================");

        System.out.println("링크드 리스트 테스트 ==========================");
        myLinkedList.add("김밥");
        myLinkedList.add("라면");
        myLinkedList.add("떡볶이");

        for (String s : myLinkedList) {
            System.out.printf("add: " + s+" ");
        }
        System.out.println("");

        for (int i = 0; i < 3; i++) {
            System.out.printf(i + "의 요소: " + myLinkedList.get(i)+ " ");
        }
        System.out.println("");

        System.out.println("리스트의 크기: " + myLinkedList.size());

        myLinkedList.delete(1);
        System.out.println("삭제 후 1의 요소: " + myLinkedList.get(1));
        System.out.println("삭제 후 리스트의 크기: " + myLinkedList.size());

        System.out.println("리스트가 비어 있나요? " + myLinkedList.isEmpty());
        myLinkedList.delete(0);
        myLinkedList.delete(0);
        System.out.println("delete 두번 수행");
        System.out.println("리스트가 비어 있나요? " + myLinkedList.isEmpty());
        System.out.println("링크드 리스트 종료 ==========================");
    }
}