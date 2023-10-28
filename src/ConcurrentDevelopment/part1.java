package ConcurrentDevelopment;

class part1 extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread " + Thread.currentThread().getId() + " - Count: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class ThreadExample {
    public static void main(String[] args) {
        part1 thread1 = new part1();
        part1 thread2 = new part1();

        thread1.start();
        thread2.start();
    }
}
