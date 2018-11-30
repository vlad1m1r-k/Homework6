package ua.kiev.prog.homework6.part3;

public class Sort implements Runnable {
    private int startPoint;
    private int step;
    private int[] array;

    public Sort(int startPoint, int step, int[] array) {
        this.startPoint = startPoint;
        this.step = step;
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = startPoint; i < array.length; i += step) {
            
        }
    }
}
