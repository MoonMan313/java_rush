import java.util.Scanner;

public class Program {

    private static final String NUMBER_END_INPUT = "42";
    private static final int MAX_WEEK = 18;
    private static final int TESTS_IN_WEEK = 5;
    private static final int MAX_GRADE = 9;

    static void printDiagram(long tests) {
        for (int i = 1; tests != 0; ++i) {
            System.out.print("Week ");
            System.out.print(i);
            System.out.print(" ");

            for (long j = tests % 10; j != 0; --j) {
                System.out.print("=");
            }

            System.out.println(">");
            tests /= 10;
        }
    }

    static long getZero(int i) {
        long num = 1;

        while (i != 0) {
            num *= 10;
            --i;
        }
        return (num);
    }

    static int findMinTest() {
        int min = MAX_GRADE;
        Scanner scanner = new Scanner(System.in);
        int tmp = scanner.nextInt();

        for (int i = 0; i < TESTS_IN_WEEK; ++i) {
            if (tmp > MAX_GRADE || tmp < 1) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }

            if (tmp < min) {
                min = tmp;
            }
            if (i < (TESTS_IN_WEEK - 1)) {
                tmp = scanner.nextInt();
            }
        }
        return (min);
    }

    static void checkWeek(String str, int numWeek) {
        if (!str.equals("Week " + numWeek)) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String week = scanner.nextLine();

        long tests = 0;

        for (int i = 0; i < MAX_WEEK && !week.equals(NUMBER_END_INPUT); ++i) {
            checkWeek(week, i + 1);
            tests += findMinTest() * getZero(i);
            if (i < (MAX_WEEK - 1)) {
                week = scanner.nextLine();
            }
        }
        printDiagram(tests);
    }
}
