//part 1 Will explain the ways that concurrency can be implemented in java


package Concurrency;

public class Part1 {
    public static class MyRunnable implements Runnable {
    //this first method is really simple you just have to implement the method Runnable
        //than you call run
        @Override
        public void run() {
            //implement the variables
            System.out.println ("MyRunnable running");
            System.out.println("My Runnable is finished");
        }
    }
        public static void main (String[] args){
        //create an object using a Thread Parameter
        Thread t = new Thread(new MyRunnable());
        t.start();
        }


}
