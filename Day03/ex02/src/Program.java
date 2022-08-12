import java.lang.ref.Reference;
import java.util.Random;

public class Program {

    private static final int MAX_MODULO_VALUE = 1000;

    private static void error(String message) {
        System.err.println(message);
        System.exit(0);
    }

    private static void runThreads(Integer[] arr, int arraySize, int threadsCount) {
        int[] resultSum = new int[1];
        Object monitor = new Object();
        Thread[] arrThreads = new Thread[threadsCount];

        int index = (arraySize - (arraySize % threadsCount)) / threadsCount;
        for (int i = 0; i < threadsCount; ++i) {
            if (i == threadsCount - 1) {
                arrThreads[i] = new Thread(new SumRange(i + 1, arr, i * index, arraySize - 1, resultSum, monitor));
            } else {
                arrThreads[i] = new Thread(new SumRange(i + 1, arr, i * index, i * index + index - 1, resultSum, monitor));
            }
            arrThreads[i].start();
        }

        try {
            for (int i = 0; i < threadsCount; ++i) {
                arrThreads[i].join();
            }
        } catch (InterruptedException e) {
            System.err.println("Something went wrong...");
        }
        System.out.println("Sum by threads: " + resultSum[0]);
    }

    private static void initArray(Integer[] arr, int size) {
        Random randNum = new Random();
        long sum = 0;

        for (int i = 0; i < size; ++i) {
            arr[i] = randNum.nextInt(MAX_MODULO_VALUE * 2) - MAX_MODULO_VALUE;
            sum += arr[i];
        }
        System.out.println("Sum: " + sum);
    }

    public static void main(String[] args) {
        if (args.length != 2 || !args[0].startsWith("--arraySize=") || !args[1].startsWith("--threadsCount=")) {
            error("Enter the number of iterations in the format: \"java Program --arraySize=ARRAY SIZE --threadsCount=COUNT THREADS\"");
        }

        int arraySize = Integer.parseInt(args[0].substring(12));
        int threadsCount = Integer.parseInt(args[1].substring(15));

        if (arraySize <= 0 || threadsCount <= 0) {
            error("Enter a positive number.");
        }
        if (arraySize < threadsCount) {
            error("Array size cannot be greater than the number of threads!");
        }
        if (arraySize > 2000000) {
            error("Max size of array = 2'000'000!");
        }

        Integer[] arr = new Integer[arraySize];

        initArray(arr, arraySize);
        runThreads(arr, arraySize, threadsCount);
    }
}
