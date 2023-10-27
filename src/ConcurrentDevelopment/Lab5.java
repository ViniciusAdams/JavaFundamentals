package ConcurrentDevelopment;
public class Lab5 {
    private static int threads = 10;
    private static int current = 0;


    public static void main(String[] args) {
        Lab5 ordering = new Lab5();

        for (int i = 0; i < threads; i++) {
            int threadNumber = i;
            Thread thread = new Thread(() -> ordering.Order(threads));
            thread.start();
        }


    }
    public synchronized void Order ( int thNumber){
        while (thNumber != current) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Thread" + threads + " ");

    }


}