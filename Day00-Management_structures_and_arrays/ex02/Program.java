import java.util.Scanner;

public class Program {

    private static final int NUMBER_END_INPUT = 42;

    static int isPrime(int number) {
        int flag = 1;

        for (int i = 2; i * i <= number; ++i) {
            if (number % i == 0) {
                flag = 0;
                break;
            }
        }
        return (flag);
    }

    static int sumDigits(int num) {
        if (num != 0)
            return (num % 10 + sumDigits(num / 10));
        return (0);
    }

    public static void main(String[] args) {
        int count = 0;

        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        while (number != NUMBER_END_INPUT) {
            count += isPrime(sumDigits(number));
            number = scanner.nextInt();
        }

        System.out.println("Count of coffee-request - " + count);
    }
}
