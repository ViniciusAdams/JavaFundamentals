package MethodOverLoading;

class SecodsToMinutesChallenge {
    public static void main (String [] args) {
        System.out.println (getDurationString(3945));
        System.out.println(getDurationString(65,45));

    }

public static String getDurationString (int seconds){
   //two step approach to get the hours
    int minutes = seconds/60;
    int hours = minutes /60;
    int remainingMinutes = minutes % 60;
    int remainingSeconds = seconds % 60;
    //One step approach
    int hours1 = seconds / 3600;
    return hours + "h" + remainingMinutes + "m" + remainingSeconds + "s";
}
public static String getDurationString (int minutes,int seconds){

    int hours = minutes /60;
    int remainingMinutes = minutes % 60;
    int remainingSeconds = seconds % 60;
    //One step approach
    int hours1 = seconds / 3600;
    return hours + "h" + remainingMinutes + "m" + remainingSeconds + "s";
}

}
