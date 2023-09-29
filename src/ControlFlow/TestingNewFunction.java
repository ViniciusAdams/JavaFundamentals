public class TestingNewFunction {
    private boolean running = true;

    public void startPrinting() {
        while (running) {
            System.out.println("Printing a message...");
            try {
                Thread.sleep(100);  // Sleep for 100 milliseconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stopPrinting() {
        running = false;
    }

    public static void main(String[] args) {
        MessagePrinter printer = new MessagePrinter();

        // Start a new thread to run the printing
        Thread thread = new Thread(() -> printer.startPrinting());
        thread.start();

        // Allow the thread to print messages for a while
        try {
            Thread.sleep(500);  // Sleep for 500 milliseconds (0.5 seconds)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Stop the printing
        printer.stopPrinting();
    }
}