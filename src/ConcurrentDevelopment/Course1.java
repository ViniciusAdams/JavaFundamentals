package ConcurrentDevelopment;

public class Course1 {

   public static class MyThread extends Thread {
       public void run(){
           System.out.println ("MyThread running");
           System.out.println ("MyThread finished");
       }
    }

    public static void main (String[] args){
        MyThread myThread = new MyThread ();
        myThread.start();
    }
}