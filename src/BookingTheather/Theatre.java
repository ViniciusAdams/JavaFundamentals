package BookingTheather;

import java.util.concurrent.locks.ReentrantLock;

/*An automated booking system for a theatre is required. The system must support multiple users that are allowed to book a single seat at a time from a list of available seats. The system must ensure that double booking is not permitted whilst allowing
clients free choice of available seats. This means that a seat may appear to be free although it may be booked or in the process of being booked by another client. Implement a class that allows users to book seats whilst not permitting double booking.
 */
public class Theatre {
private boolean seats[];
private int freeSeats;
private ReentrantLock lock = new ReentrantLock();
public Theatre(int n){
    seats = new boolean[n];

    for (int j = 0; j
            < n; j++)
        seats[j] = true;
        freeSeats = n;
}
public int [] getSeats(){
//finding list of free seats
    lock.lock();
    try {
        int free []= new int [freeSeats];
    int k = 0;
    for (int j=0; j < seats.length;j++) {
        if (seats[j]){
            free[k]=j;
            k++;
        }
    }
    return free;}
finally {lock.unlock();

    }
    }
public boolean bookSeat(int k){
lock.lock();
try {
    if (seats[k]) {
        seats[k] = false;
        freeSeats--;
        return true; //Booked;

    } else
        return false;

}finally {lock.unlock();}

}
}

