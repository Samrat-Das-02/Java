import java.util.LinkedList;
import java.util.Queue;

class Producer implements Runnable {
    private Queue<Integer> buffer;
    private int maxItems;

    public Producer(Queue<Integer> buffer, int maxItems) {
        this.buffer = buffer;
        this.maxItems = maxItems;
    }

    @Override
    public void run() {
        for (int i = 0; i < maxItems; i++) {
            synchronized (buffer) {
                while (buffer.size() >= maxItems) {
                    try {
                        buffer.wait(); // Wait if the buffer is full
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                buffer.offer(i);
                System.out.println("Produced: " + i);
                buffer.notifyAll(); // Notify consumer that an item is produced
            }
            try {
                Thread.sleep(1000); // Simulating production time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

class Consumer implements Runnable {
    private Queue<Integer> buffer;
    private int maxItems;

    public Consumer(Queue<Integer> buffer, int maxItems) {
        this.buffer = buffer;
        this.maxItems = maxItems;
    }

    @Override
    public void run() {
        for (int i = 0; i < maxItems; i++) {
            synchronized (buffer) {
                while (buffer.isEmpty()) {
                    try {
                        buffer.wait(); // Wait if the buffer is empty
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                int item = buffer.poll();
                System.out.println("Consumed: " + item);
                buffer.notifyAll(); // Notify producer that an item is consumed
            }
            try {
                Thread.sleep(2000); // Simulating consumption time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

public class Producer_consumer{
    public static void main(String[] args) {
        int bufferSize = 5; // Size of the buffer
        int maxItems = 10; // Total number of items to produce/consume

        Queue<Integer> buffer = new LinkedList<>();
        Producer producer = new Producer(buffer, maxItems);
        Consumer consumer = new Consumer(buffer, maxItems);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
