package ConcurrentDevelopment;

public class EggTimer extends Thread {
    private int et = 0;
    private volatile boolean go = true;

    @Override
    public void run() {
        while (et < 30 && go) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                et++;
                System.out.print(et + " ");
            }
        }
    }

    public void terminate() {
        go = false;
    }

    public static void main(String[] args) {
        EggTimer timer = new EggTimer();
        timer.start();

        // Simulate a control program that stops the timer after 10 seconds
        try {
            Thread.sleep(10000); // Sleep for 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.terminate();
    }
}
