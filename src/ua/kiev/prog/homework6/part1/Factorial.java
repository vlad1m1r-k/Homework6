package ua.kiev.prog.homework6.part1;

import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            BigInteger factorial = new BigInteger("1");
            for (long i = 1; i <= Thread.currentThread().getId(); i++){
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            System.out.println(Thread.currentThread().getId() + "! = " + factorial);
        };
        for (int i = 1; i <= 100; i++){
            new Thread(runnable).start();
        }
    }
}
