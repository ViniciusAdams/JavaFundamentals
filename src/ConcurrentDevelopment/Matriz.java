import java.util.concurrent.ExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
;
public class Question1 {
    public static void main(String[] args) {
        char[][] m = generateRandomMatrix(1000, 1000); // Genarating a 1000x1000
        String word = "fun";
        int threadC = 6;
        ExecutorService es = Executors.newFixedThreadPool(threadC);
        List<Search> tasks = new ArrayList<>();
        // Creating tasks to different directions
        tasks.add(new Search(m, word.toCharArray(), D.H));
        tasks.add(new Search(m, word.toCharArray(), D.V));
        tasks.add(new Search(m, word.toCharArray(), D.DF));
        tasks.add(new Search(m, word.toCharArray(), D.DR));
        int Count = 0;
        long sTime = System.currentTimeMillis();

        try {
            List<Future<Integer>> results = es.invokeAll(tasks);
            for (Future<Integer> result : results) {
                Count += result.get();
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            es.shutdown();

        }


        long aendTime = System.currentTimeMillis();

        long eTime = aendTime - sTime;
        System.out.println("Count=" +Count);
        System.out.println("Execution-Time:" +eTime +" ms");
    }
    //
    private static char[][] generateRandomMatrix(int r, int c) {
        Random randomGenerator = new Random();
        char[][] arr = new char[r][c];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (char) (randomGenerator.nextInt(26) + 97);
            }
        }
        return arr;
    }
}
//defining set of constants
enum D {
    H, V, DF, DR
}
class Search implements Callable<Integer> {
    private char[][] m;
    private char[] t;
    private D location;
    public Search(char[][] m, char[] t, D location) {
        this.m = m;
        this.t = t;
        this.location = location;
    }
    public Integer call() {
        int c = 0;
        int rows = m.length;
        int cols = m[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (checkWord(i, j, rows, cols)) {
                    c++;
                }
            }
        }
        return c;
    }
    //METHOD TO CHECK THE WORDS
    private boolean checkWord(int row, int col, int rows, int cols) {
        for (int i = 0; i < t.length; i++) {
            int r = row, c = col;

            switch (location) {
                case H:
                    c += i;
                    break;
                case V:
                    r += i;
                    break;
                case DF:
                    r += i;
                    c -= i;
                    break;
                case DR:
                    r += i;
                    c += i;
                    break;
            }
            if (r < 0 || r >= rows || c < 0 || c >= cols || m[r][c] != t[i]) {
                return false;
            }
        }

        return true;
    }
}
//Vinicius Eduardo Adams de Castro#
//3052655