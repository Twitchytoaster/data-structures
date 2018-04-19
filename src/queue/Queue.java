package queue;

public class Queue<T> {

    private int capacity;
    private int size;

    private T items[];

    private int first;
    private int last;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.items = (T[]) new Object[capacity];
        this.last = -1;
        this.first = 0;
    }

    public void add(T element) {
        if(last == capacity - 1) {
            last = -1;
        }
        items[++last] = element;
        size++;
    }

    public T delete() {
        if(first == capacity - 1) {
            first = 0;
        }
        T temp = items[first++];
        size--;
        return temp;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(T item : items) {
            stringBuilder.append(item);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
