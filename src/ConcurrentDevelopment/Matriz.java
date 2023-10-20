package ConcurrentDevelopment;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Matriz {
    public static void main (String[] args){
        char [][] m = {

        };
    }
    String word = "fun";
    int threadC = Runtime.getRuntime().availableProcessors();
    ExecutorService es = Executors.newFixedThreadPool(threadC);
    //Creating an Executor with a pool
    private static class Search implements Callable <Integer> {
        private char [][] m ;
        private String t;
        private int sRow;
        private int eRow;
        private int Count;

        @Override
        public Integer call() {
            int count = 0;

            for (int i = sRow; i < eRow; i++) {
                for (int j = 0; j < Count; j++) {
                    // Horizontal search
                    if (Horizontal(i, j)) {
                        count++;
                    }
                    // Vertical search
                    if (Vertical(i, j)) {
                        count++;
                    }
                    // Diagonal search (left to right)
                    if (DiagonalL(i, j)) {
                        count++;
                    }
                    // Diagonal search (right to left)
                    if (DiagonalR(i, j)) {
                        count++;
                    }
                }
            }

            return count;
        }



        private boolean Vertical(int row, int col) {
            // checking verticaly
            if (row + 2 >= eRow) {
                return false;
            }

            for (int i = 0; i < 3; i++) {
                if (m[row + i][col] != t.charAt(i)) {
                    return false;
                }
            }
            return true;
        }

        private boolean Horizontal(int row, int col) {
            // Check horizontally
            if (col + 2 >= Count) {
                return false;
            }

            for (int i = 0; i < 3; i++) {
                // Check "fun"
                if (m[row][col + i] != t.charAt(i)) {
                    return false;
                }
            }
            return true;
        }

        private boolean DiagonalL(int row, int col) {
            // checking left to right
            if (col + 2 >= Count || row + 2 >= eRow) {
                return false;
            }
            // fun?
            for (int i = 0; i < 3; i++) {
                if (m[row + i][col + i] != t.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
        private boolean DiagonalR(int row, int col) {
            // Check if there is "fun" diagonally (right to left)
            if (col - 2 < 0 || row + 2 >= eRow) {
                return false;
            }
            // Check if the characters form "fun"

            //check if all the letters make "fun"
            for (int i = 0; i < 3; i ++){
                if (m[row + i][col - i] != t.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
