package MethodOverLoading;
//https://www.udemy.com/course/java-the-complete-java-developer-course/learn/lecture/34998720#content
public class MethodOverloading {
    public static void main(String[] args) {
   int newScore = calculateScore("Vini", 500);
    System.out.println ("New score is" + newScore);
    //passing return to int
    calculateScore(75);
    calculateScore(100);


    }

    public static int calculateScore(String playerName, int score) {

        System.out.println("Player" + playerName + "scored" + score + "points");
        return score * 1000;
    }
    public static int calculateScore(int score) {

        System.out.println("UnnamedPlayer" + "scored" + score + "points");
        return score * 1000;
    }
    }

