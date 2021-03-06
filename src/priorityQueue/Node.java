package priorityQueue;

public class Node<T extends Comparable> {

    private Node<T> next;
    private Node<T> previous;

    private T value;

    public Node(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public T  getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
