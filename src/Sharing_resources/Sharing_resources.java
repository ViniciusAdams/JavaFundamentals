package Sharing_resources;
//When two or more threads share a resource then interference can occur.
public class Sharing_resources {
    class SharedScreen{
        public static void main(String args[]){
            new Thread(new Messenger("Happy days are here again",10)).start();
            new Thread(new Messenger("She loves me - she loves me not",15)).start();
        }
    }


}
