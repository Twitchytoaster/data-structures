package queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(4);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.delete();
        queue.delete();
        queue.delete();
        System.out.println(queue);
    }
}
