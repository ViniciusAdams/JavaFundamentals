package ConcurrentDevelopment;

//
//Given 10 threads ensure that they execute in order 0..9. Each thread should print a message listing its number in the sequence when it gets to execute. The values must be in order.
public class Lab5 {
    private static final int THREADS = 10;
    private static int current = 0;

    public static void main(String[] args) {
        Lab5 ordering = new Lab5();

        for (int i = 0; i < THREADS; i++) {
            final int threadNumber = i;
            Thread thread = new Thread(() -> ordering.Order(threadNumber));
            thread.start();
        }
    }

    public synchronized void Order(int thNumber) {
        while (thNumber != current) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Thread " + thNumber + " execut");
        current++;
        notifyAll();
    }
}
