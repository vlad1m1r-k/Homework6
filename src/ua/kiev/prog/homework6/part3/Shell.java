package ua.kiev.prog.homework6.part3;

import java.util.Arrays;
import java.util.Random;

public class Shell {
    private static int[] array = new int[2_000_000];

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(90);
        }
        int[] arr2 = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        Arrays.sort(arr2);
        long endTime = System.currentTimeMillis();
        System.out.println("Array library sort Time: " + (endTime - startTime) + " ms");
        startTime = System.currentTimeMillis();
        int step = array.length > 1000 ? 100 : array.length / 3;
        while (step >= 1) {
            Thread[] threads = new Thread[step];
            for (int i = 0; i < step; i++) {
                Thread thread = new Thread(new Sort(i, step, array));
                threads[i] = thread;
                thread.start();
            }
            for (Thread thread : threads) {
                thread.join();
            }
            step /= 2;
        }
        endTime = System.currentTimeMillis();
        System.out.println("Array Shell sort Time: " + (endTime - startTime) + " ms");
        System.out.println(Arrays.equals(array, arr2));
    }
}
