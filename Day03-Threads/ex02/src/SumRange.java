public class SumRange implements Runnable{
    Integer[] array;
    int indexFirst;
    int indexLast;
    int[] result;
    int numThread;
    Object monitor;

    public SumRange(int numThread, Integer[] array, int indexFirst, int indexLast, int[] result, Object monitor) {
        this.array = array;
        this.indexFirst = indexFirst;
        this.indexLast = indexLast;
        this.result = result;
        this.numThread = numThread;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        Integer sum = 0;

        for (int i = indexFirst; i <= indexLast; ++i) {
            sum += array[i];
        }
        synchronized (monitor) {
            result[0] += sum;
            System.out.println("Thread " + numThread + ": from " + indexFirst + " to " + indexLast + " sum is " + sum);
        }
    }
}
