public class BarkingDog {
    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {
        if (hourOfDay < 0 || hourOfDay > 23) {
            return false;
        } else if (barking && (hourOfDay < 8 || hourOfDay > 22)) {
            return true;
        } else {
            return false;
        }
    }
    public static void main (String []args){
       boolean wakeUp1 = shouldWakeUp(true,7);
        boolean wakeUp2 =shouldWakeUp(false,7);

        System.out.println ("Wake up 1" + wakeUp1);
    }
}
