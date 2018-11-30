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
        for (int i = startPoint + step; i < array.length; i += step) {
            for (int j = i; j > startPoint; j -= step){
                if (array[j] < array[j-step]){
                    int temp = array[j];
                    array[j] = array[j - step];
                    array[j - step] = temp;
                }
            }
        }
    }
}
