package ua.kiev.prog.homework6.part2;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ArraySum {
    private static int[] array = new int[5_000_000];
    private volatile static AtomicInteger sum = new AtomicInteger(0);
    private static int elementsPerThread = 500_000;

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        long startTime = System.currentTimeMillis();
        multiCalc();
        long endTime = System.currentTimeMillis();
        System.out.println("Array multi thread sum = " + sum + " Time: " + (endTime - startTime) + " ms");
        sum = new AtomicInteger(0);
        startTime = System.currentTimeMillis();
        singleCalc();
        endTime = System.currentTimeMillis();
        System.out.println("Array single thread sum = " + sum + " Time: " + (endTime - startTime) + " ms");
    }

    public static void setSum(int threadResult) {
        sum.getAndAdd(threadResult);
    }

    private static void singleCalc() {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        ArraySum.setSum(sum);
    }
    private static void multiCalc() throws InterruptedException {
        int index = 0;
        int from;
        int to;
        do {
            from = index;
            if (index + elementsPerThread > array.length - 1) {
                to = array.length - 1;
            } else {
                to = index + elementsPerThread;
            }
            Thread thread = new Thread(new Sum(array, from, to));
            thread.start();
            thread.join();
            index = to + 1;
        } while (index < array.length);
    }
}
