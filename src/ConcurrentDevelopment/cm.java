package ConcurrentDevelopment;

class ThreadOrdering {
    private static final int NUM_THREADS = 10;
    private static int currentThread = 0;

    public static void main(String[] args) {
        ThreadOrdering ordering = new ThreadOrdering();

        for (int i = 0; i < NUM_THREADS; i++) {
            final int threadNumber = i;
            Thread thread = new Thread(() -> ordering.executeInOrder(threadNumber));
            thread.start();
        }
    }

    public synchronized void executeInOrder(int threadNumber) {
        while (threadNumber != currentThread) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Thread " + threadNumber + " executed.");
        currentThread++;
        notifyAll();
    }
}