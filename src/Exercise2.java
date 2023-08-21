/*Insert a code segment after the code we've just reviewed:
        Set the existing score variable to 10,000.
        Set the existing levelCompleted variable to 8.
        Set the existing bonus variable to 200.
        Use the same if condition (meaning if gameOver is true) you want to perform the same calculation, and print out the value of the finalScore variable.
*/
public class Exercise2<gameOver> {
    public static void main(String[] args) {

        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        int finalScore = score;

        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Your final score was " + finalScore);
        }


    //first method
       // boolean NewgameOver = true;
       // int Newscore = 10000;
        //int NewlevelCompleted = 8;
        //int Newbonus = 200;

       // int NewfinalScore = score;

       // if (gameOver) {
       //     finalScore += (levelCompleted * bonus);
          //  finalScore += 1000;
           // System.out.println("Your final score was " + finalScore);

         score = 10000;
         levelCompleted = 8;
         bonus = 200;

         finalScore = score;

        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Your final score was " + finalScore);
        }
    }
}
