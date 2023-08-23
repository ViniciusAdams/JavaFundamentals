/*In this challenge we're going to create two methods:
        The first method should be named displayHighScorePosition.
        This method should have two parameters, one for a player's name, and one for a player's position in a high score list.
        This method should print a message like "Tim managed to get into position 2 on the high score list".*/

/*The second method should be named calculateHighScorePosition.
This method should have only one parameter, the player's score.
This method should return a number between 1 and 4, based on the score values shown in this table.



Finally, we'll call both methods and display the results for the following scores: 1500, 1000, 500, 100, and 25.*/



public class Exercise3 {
    public static void main(String[] args) {
        int highScorePosition = calculateHighScorePosition(1500);
        displayHighScorePosition("Tim",highScorePosition);

        highScorePosition = calculateHighScorePosition(1000);
        displayHighScorePosition("Bob",highScorePosition);

        highScorePosition = calculateHighScorePosition(500);
        displayHighScorePosition("Percy",highScorePosition);

        highScorePosition = calculateHighScorePosition(100);
        displayHighScorePosition("Gilbert",highScorePosition);

        highScorePosition = calculateHighScorePosition(25);
        displayHighScorePosition("James",highScorePosition);

    }

    public static void displayHighScorePosition(String playerName, int highScorePosition) {


        System.out.println(playerName + " MANAGED TO GET INTO POSITION " + highScorePosition + " on the high score list");


    }


    public static int calculateHighScorePosition(int score) {
        int position =4;
        if (score >= 1000) {
             position =1;
        }else if (score >= 500){
            position =2;
        }else if (score >= 100 ) {
            position =3;
        }
        return position;

    }
}