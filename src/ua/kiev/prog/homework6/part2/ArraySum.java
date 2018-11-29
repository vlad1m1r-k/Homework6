package ua.kiev.prog.homework6.part2;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ArraySum {
    private static int[] array = new int[27];
    private volatile static AtomicInteger sum = new AtomicInteger(0);
    private static int elementsPerThread = 5;

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(array));
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
        } while ((index + elementsPerThread) < array.length);
        System.out.println("Array Threading sum = " + sum);
    }

    static void setSum(int threadResult) {
        sum.getAndAdd(threadResult);
    }
}
