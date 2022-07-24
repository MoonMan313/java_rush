package Game;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import java.io.IOException;


public class Main {
    @Parameter(names={"--enemiesCount"})
    private static int enemiesCount;
    @Parameter(names={"--wallsCount"})
    private static int wallsCount;
    @Parameter(names={"--size"})
    private static int size;
    @Parameter(names={"--profile"})
    private static String profile = String.valueOf(Main.class.getResource("/resources/application-production.properties"));

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);

        char[][] map = new char[size][size];

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                map[i][j] = '-';
            }
        }

        PictureProperties imgProperties = new PictureProperties(profile);
        PrintImage img = new PrintImage(size, imgProperties, map);
    }
}
