package ConcurrentDevelopment;

public class Lab1Q2 implements Runnable {
    //create variable volatile boolean is running?
    private volatile boolean isRunning = true;

    @Override
    //method runt
    public void run() {
       //while it is running print a message
        while (isRunning) {
            System.out.println("message");
           //try thread.sleep each 100 milliseconds
            try {
                Thread.sleep(100); // Sleep for 100 milliseconds
            //catch ifis Running is false print terminated
            } catch (InterruptedException e) {
                if (!isRunning) {
                    System.out.println("Terminated");
                    return;
                }
            }
        }
    }

    public void stopThread() {
        //creating a method and setting it to false
        isRunning = false;
    }

    public static void main(String[] args) {
        //creating method Lab1q2
        Lab1Q2 lab1Q2 = new Lab1Q2();
        //creating thread with method as an argument
        Thread thread = new Thread(lab1Q2);
        //thread start
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lab1Q2.stopThread();
    }
}
