package Sharing_resources;

class Messenger implements Runnable{
    String message;
    int n;
    public Messenger(String m, int k){
        message = m;
        n = k;
    }
    public void run(){
        for(int j = 0; j < n; j++)
            System.out.println(message);
    }
}

