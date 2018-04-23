package priorityQueue;

public class MyLinkedList<T extends Comparable> {

    private Node<T> first;
    private Node<T> last;

    int size;

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

        size++;
    }

    public Node<T> getLast() {
        return last;
    }

    public int binarySearch(T element) {
        int lowerBound = 0;
        int upperBound = size - 1;
        int current;
        int steps = 0;

        while(true) {
            current = (lowerBound + upperBound) / 2;
            System.out.println(current);
            T item = at(current);
            if(item.equals(element)) {
                return steps;
            } else if(lowerBound > upperBound) {
                return size;
            } else {
                if(element.compareTo(current) > 0) {
                    lowerBound = current + 1;
                    steps++;
                } else {
                    upperBound = current - 1;
                    steps++;
                }
            }
        }
    }

    public T at(int index) {
        Node<T> temp = first;
        for(int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        T value = first.getValue();
        return temp.getValue();
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
