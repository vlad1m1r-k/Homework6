package ua.kiev.prog.homework6.part3;

import java.util.Random;

public class Shell {
    private static int[] array = new int[500];
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(400);
        }
        int step = array.length/10;
        while (step > 1){

        }
    }
}
