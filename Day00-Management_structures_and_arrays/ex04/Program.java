import java.util.Scanner;

public class Program {

    private static final int ARRAY_SIZE = 65535;
    private static final int COUNT_TOP_SIZE = 10;
    private static final int DIAGRAM_HEIGHT = COUNT_TOP_SIZE + 2;
    private static final int DIAGRAM_WIDTH = COUNT_TOP_SIZE * 3;
    private static final int CHAR_ZERO = 48;

    static int maxCharCount(int[] arr) {
        int max = 0;
        char maxChar = 0;

        for (int i = 0; i < ARRAY_SIZE; ++i) {
            if (max < arr[i]) {
                max = arr[i];
                maxChar = (char)i;
            }
        }
        arr[maxChar] = 0;
        return (max);
    }

    static char maxChar(int[] arr) {
        int max = 0;
        char maxChar = 0;

        for (int i = 0; i < ARRAY_SIZE; ++i) {
            if (max < arr[i]) {
                max = arr[i];
                maxChar = (char)i;
            }
        }
        return (maxChar);
    }

    static void convertToChar(int[] arrTop, char[][] top) {
        for (int i = 0; i < COUNT_TOP_SIZE; ++i) {
            int tmp = arrTop[i];
            top[i][2] = (char)((tmp % 10) + CHAR_ZERO);

            if (tmp / 10 > 0) {
                tmp /= 10;
                top[i][1] = (char)((tmp % 10) + CHAR_ZERO);
                if (tmp / 10 > 0) {
                    tmp /= 10;
                    top[i][0] = (char)((tmp % 10) + CHAR_ZERO);
                }
                else {
                    top[i][0] = ' ';
                }
            }
            else {
                top[i][1] = ' ';
                top[i][0] = ' ';
            }
        }
    }

    static void printImg(char[][] img) {
        for (int k = DIAGRAM_HEIGHT - 1; k != -1; --k) {
            for (int m = 0; m < DIAGRAM_WIDTH; ++m) {
                System.out.print(img[k][m]);
            }
            System.out.println();
        }
    }

    static void creatImg(char[] topChar, char[][] countTop, int[] countTopChar) {
        char[][] img = new char[DIAGRAM_HEIGHT][DIAGRAM_WIDTH];

        double index = (double) countTopChar[0] / 10;

        int height;

        for (int i = 0; i < COUNT_TOP_SIZE; ++i) {

            height = (int)(countTopChar[i] / index);

            for (int j = i * 3; (j - i * 3) < 3; ++j) {
                for (int l = 0; l < DIAGRAM_HEIGHT; ++l) {
                    if (l == 0 && (j - i * 3) == 2 && countTopChar[i] != 0) {
                        img[0][j] = topChar[i];
                    }
                    else if (l == (height + 1) && countTopChar[i] != 0) {
                        img[l][j] = countTop[i][j - i * 3];
                    }
                    else if (l <= height && (j - i * 3) == 2 && countTopChar[i] != 0) {
                        img[l][j] = '#';
                    }
                    else {
                        img[l][j] = ' ';
                    }
                }
            }
        }

        printImg(img);
    }

    static void printDiagram(int[] arr) {
        char[] topChar = new char[COUNT_TOP_SIZE];

        int[] countTopChar = new int[COUNT_TOP_SIZE];

        char[][] countTop = new char[COUNT_TOP_SIZE][3];

        for (int i = 0; i < COUNT_TOP_SIZE; ++i) {
            topChar[i] = maxChar(arr);
            countTopChar[i] = maxCharCount(arr);
        }

        convertToChar(countTopChar, countTop);
        creatImg(topChar, countTop, countTopChar);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        char[] arrLine = new char[line.length()];

        arrLine = line.toCharArray();

        int[] frequency = new int[ARRAY_SIZE];

        for (int i = 0; (i < line.length()) && (frequency[i] != '\n'); ++i) {
            frequency[arrLine[i]] += 1;
        }

        printDiagram(frequency);
    }
}