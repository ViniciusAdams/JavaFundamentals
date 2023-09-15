package MethodOverLoading;

public class Cat {
    public static boolean isCatPlaying(boolean summer, int temperature) {
        int upperLimit = (summer) ? 45 : 35;git

        return temperature >= 25 && temperature <= upperLimit;
    }
}
