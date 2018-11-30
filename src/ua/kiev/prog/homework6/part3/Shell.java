package ua.kiev.prog.homework6.part3;

import java.util.Arrays;
import java.util.Random;

public class Shell {
    private static int[] array = new int[50];
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(90);
        }
        int[] arr2 = Arrays.copyOf(array, 50);
        Arrays.sort(arr2);
        int step = array.length/10;
        while (step >= 1){
            for (int i = 0; i < step ; i++) {
                Thread thread = new Thread(new Sort(i, step, array));
                thread.start();
                thread.join();
                step /= 2;
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.equals(array, arr2));
    }
}
