package ConcurrentDevelopment;

import java.util.Random;
//Question 1
//Write a thread that tosses a coin 1000 times and computes the frequency of heads and tails.
public class Lab1 extends Thread{
    //extend Threads
private static final int TOSSES = 1000;
//setting tosses to 1000
private int heads = 0;
//heads = 0;
private int tails = 0;
//tails = 0;

public void run() {
    //run method
    Random random = new Random();
    //random method
    for (int i = 0; i < TOSSES; i++) {
        //for loop with tosses on it 1000
        boolean isHead = random.nextBoolean();
        //boolean is head? =
        if (isHead) {
            heads++;
        } else {
            tails++;
        }

    }
    System.out.println("Heads" + heads);
    System.out.print("Tails" + tails);
}
public static void main (String[] args){

    Lab1 threads =  new Lab1();
    threads.start();

}


}


