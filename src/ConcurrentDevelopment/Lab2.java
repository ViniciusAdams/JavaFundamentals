//1.	Given below is a sequential program that calculates the frequency of even values in a large array. Your task is to write a parallel solution that distributes all of the workload over the number of processors on the machine executing your program. The work should be distributed so that each thread deals with block segments that do not differ in size by more than 1.

package ConcurrentDevelopment;


public class Lab2 {
    public static void main(String[] args) {
        int numThreads = Runtime.getRuntime().availableProcessors(); // Number of available processors
        int f[] = new int[1000000];
        for (int j = 0; j < f.length; j++)
            f[j] = (int) (Math.random() * 100000);

        FrequencyCounter[] counters = new FrequencyCounter[numThreads];

        Thread[] threads = new Thread[numThreads];

        int blockSize = f.length / numThreads;
        int freq = 0;

        for (int i = 0; i < numThreads; i++) {
            final int start = i * blockSize;
            final int end = (i == numThreads - 1) ? f.length : (i + 1) * blockSize;

            counters[i] = new FrequencyCounter(f, start, end);
            threads[i] = new Thread(counters[i]);

            threads[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
                freq += counters[i].getFrequency();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(freq);
    }

    static class FrequencyCounter implements Runnable {
        private final int[] array;
        private final int start;
        private final int end;
        private int frequency;

        FrequencyCounter(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        public int getFrequency() {
            return frequency;
        }

        @Override
        public void run() {
            frequency = 0;
            for (int j = start; j < end; j++) {
                if (array[j] % 2 == 0) {
                    frequency++;
                }
            }
        }
    }
}
