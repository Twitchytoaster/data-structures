package priorityQueue;

public class PriorityMain {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.push(5);
        priorityQueue.push(3);
        priorityQueue.push(7);
        priorityQueue.pop();
        priorityQueue.pop();
        System.out.println(priorityQueue);
    }
}
