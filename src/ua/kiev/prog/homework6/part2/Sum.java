package ua.kiev.prog.homework6.part2;

public class Sum implements Runnable {
    private int[] array;
    private int from;
    private int to;

    public Sum(int[] array, int from, int to) {
        this.array = array;
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = from; i <= to; i++) {
            sum += array[i];
        }
        ArraySum.setSum(sum);
    }
}
