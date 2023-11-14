package ConcurrentDevelopment;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Plataform {
    //int current counter
    private int currentPeople = 0;
    //lock locker
    private final Lock lock = new ReentrantLock();
    //condition plataformOpen
    private final Condition platformOpen = lock.newCondition();

    // Method for someone entering
    public void enter()
            throws InterruptedException {
        lock.lock();
        try {
            // If its full wait
            while (currentPeople >= 100) {
                platformOpen.await();
            }

            currentPeople++; // counter++
        } finally {
            lock.unlock();
        }
    }

    // Method leaving the platform
    public void exit() {
        lock.lock();
        try {
            currentPeople--; //  leaves the platform--
            platformOpen.signalAll(); //
        } finally {
            lock.unlock();
        }
    }
}
