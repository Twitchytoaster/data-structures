package priorityQueue;

public class PriorityMain {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.insert(0);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);
        linkedList.insert(6);
        linkedList.insert(7);
        linkedList.insert(8);
        linkedList.insert(9);
        linkedList.insert(10);
        System.out.println(linkedList.binarySearch(0));
    }
}
