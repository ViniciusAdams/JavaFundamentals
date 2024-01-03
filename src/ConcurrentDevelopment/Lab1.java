package ConcurrentDevelopment;

import java.util.Random;
//Question 1
//Write a thread that tosses a coin 1000 times and computes the frequency of heads and tails.
class TossThread extends Thread{
    private int n=0;

    public void run() {
        for(int k = 0; k < 1000; k++)
            if ((int)( Math.random()*2)==1) n++;
    }

    public int getResult(){
        return n;

    }

    class Lab1{
        public static void main(String args[]){
            TossThread res = new TossThread();
            res.start();
            try{
                res.join();
            }
            catch(InterruptedException e){}
            System.out.println("Head =  "+ res.getResult());
            System.out.println("Tail =  "+ (1000 -res.getResult()));
        }
    }
}







