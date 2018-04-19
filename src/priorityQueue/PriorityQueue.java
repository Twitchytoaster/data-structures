package priorityQueue;

public class PriorityQueue<T extends Comparable> {

    private MyLinkedList<T> linkedList;

    public PriorityQueue() {
        linkedList = new MyLinkedList<>();
    }

    public void push(T element) {
        linkedList.insert(element);
    }

    public T pop() {
        return linkedList.getFirst();
    }

    public String toString() {
        return linkedList.toString();
    }
}
