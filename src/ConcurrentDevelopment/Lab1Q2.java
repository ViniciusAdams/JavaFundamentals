package ConcurrentDevelopment;

public class Lab1Q2 extends Thread {
    class MessagePrinter extends Thread{
        private volatile boolean go = true;
        private Thread t;
        public void run(){
            while(go){
                try{
                    this.sleep(100);
                }catch(InterruptedException e){}
                t = Thread.currentThread();

                if (t.isAlive())
                    System.out.println("Running");
            }
        }
        public void terminate()
        {
            go = false; }
    }


    //create variable volatile boolean is running?


    }

