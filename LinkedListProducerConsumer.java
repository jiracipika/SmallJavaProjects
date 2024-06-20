import java.util.LinkedList;

class LinkedListManager {
    private LinkedList<Integer> list;
    private int maxSize;

    public LinkedListManager(int maxSize) {
        this.maxSize = maxSize;
        list = new LinkedList<>();
    }

    public synchronized void produce(int value) {
        while (list.size() >= maxSize) {
            System.out.println("List is full, producer is waiting!");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(value);
        System.out.println("Produced: " + value);
        notifyAll();
    }

    public synchronized int consume() {
        while (list.isEmpty()) {
            System.out.println("List is empty, consumer is waiting!");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int value = list.remove();
        System.out.println("Consumed: " + value);
        notifyAll();
        return value;
    }
}

class Producer implements Runnable {
    private LinkedListManager manager;

    public Producer(LinkedListManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        while (true) {
            int value = (int) (Math.random() * 2024) + 1;
            manager.produce(value);
            try {
                Thread.sleep(2000); // Increased sleep time to 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private LinkedListManager manager;

    public Consumer(LinkedListManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        while (true) {
            manager.consume();
            try {
                Thread.sleep(500); // Reduced sleep time to 0.5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class LinkedListProducerConsumer {
    public static void main(String[] args) {
        int maxSize = 10;
        LinkedListManager manager = new LinkedListManager(maxSize);

        Thread producerThread = new Thread(new Producer(manager));
        Thread consumerThread = new Thread(new Consumer(manager));

        producerThread.start();
        consumerThread.start();
    }
}
