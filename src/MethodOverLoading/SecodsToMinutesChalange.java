package MethodOverLoading;

class SecodsToMinutesChallenge {
    public static void main (String [] args) {
        System.out.println (getDurationString(3945));
    }
public static String getDurationString (int seconds){
   //two step approach to get the hours
    int minutes = seconds/60;
    int hours = minutes /60;
    System.out.println ("hours = " + hours );
    int remainingMinutes = minutes % 60;
    System.out.println("minutes = " + minutes);
    System.out.println ("remainingMinutes = " + remainingMinutes );
    int remainingSeconds = seconds % 60;
    System.out.println ("remainingSeconds = " + remainingSeconds);


    //One step approach
    int hours1 = seconds / 3600;
    System.out.println ("hours1 ="  + hours1);
    return hours + "h" + remainingMinutes + "m" + remainingSeconds + "s";
}
public static String getDurationString (int minutes,int seconds){
    return "";
}

}
