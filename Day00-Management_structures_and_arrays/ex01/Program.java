import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int flag = 0;

        int count = 1;

        int number = scanner.nextInt();

        if (number < 2) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }

        for (int i = 2; i * i <= number; ++i) {
            if (number % i == 0) {
                flag = 1;
                break;
            }
            ++count;
        }

        if (flag == 1)
            System.out.println("false " + count);
        else
            System.out.println("true " + count);
    }
}