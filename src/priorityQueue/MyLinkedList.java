package priorityQueue;

public class MyLinkedList<T extends Comparable> {

    private Node<T> first;
    private Node<T> last;

    public void insertFirst(T element) {
        Node next = new Node(element);
        if (first != null) {
            Node temp = first;
            first = next;
            first.setNext(temp);
            temp.setPrevious(first);
        } else {
            first = next;
            last = next;
        }
    }

    public void insertLast(T element) {
        Node node = new Node(element);
        if (last != null) {
            Node temp = last;
            last = node;
            last.setPrevious(temp);
            temp.setNext(last);
        } else {
            first = node;
            last = node;
        }
    }

    public T getFirst() {
        T element = first.getValue();
        Node temp = first.getNext();
        first = temp;
        return element;
    }

    public void insert(T element) {
        Node node = new Node(element);
        Node current = first;
        boolean replaced = false;

        if(first == null) {
            first = node;
            last = node;
        }

        while(!replaced && current != null) {
            int result = element.compareTo(current.getValue());
            if(result < 0) {
                if(current.equals(first)) {
                    Node temp = first;
                    first = node;
                    first.setNext(temp);
                    temp.setPrevious(first);
                    replaced = true;
                } else {
                    node.setNext(current);
                    node.setPrevious(current.getPrevious());
                    current.getPrevious().setNext(node);
                    replaced = true;
                }
            } else {
                if(current.getNext() != null) {
                    current = current.getNext();
                } else {
                    Node temp = current;
                    current = node;
                    current.setPrevious(temp);
                    temp.setNext(current);
                    last = current;
                    current = current.getNext();
                }
            }
        }
    }

    public Node<T> getLast() {
        return last;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Node current = first; current != null; current = current.getNext()) {
            result.append(current.getValue());
            result.append(" ");
        }
        return result.toString();
    }
}
