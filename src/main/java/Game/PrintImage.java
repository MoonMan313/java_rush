package Game;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

public class PrintImage {
    private int size;
    private PictureProperties properties;
    private char[][] map;

    public PrintImage(int size, PictureProperties properties, char[][] map) {
        this.size = size;
        this.properties = properties;
        this.map = map;
    }

    public void print() {
        ColoredPrinter coloredPrinter = new ColoredPrinter
                .Builder(1, false)
                .foreground(Ansi.FColor.BLACK)
                .build();

        String empty = properties.getEmpty().getColor();
        String player = properties.getPlayer().getColor();
        String goal = properties.getGoal().getColor();
        String wall = properties.getWall().getColor();
        String enemy = properties.getEnemy().getColor();

        try {
            Ansi.BColor.valueOf(empty);
            Ansi.BColor.valueOf(player);
            Ansi.BColor.valueOf(goal);
            Ansi.BColor.valueOf(wall);
            Ansi.BColor.valueOf(enemy);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: bad color in property");
            System.exit(-1);
        }

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (map[i][j] == properties.getEnemy().getCharacter()) {
                    coloredPrinter.setBackgroundColor(Ansi.BColor.valueOf(enemy));
                } else if (map[i][j] == properties.getGoal().getCharacter()) {
                    coloredPrinter.setBackgroundColor(Ansi.BColor.valueOf(player));
                } else if (map[i][j] == properties.getPlayer().getCharacter()) {
                    coloredPrinter.setBackgroundColor(Ansi.BColor.valueOf(goal));
                } else if (map[i][j] == properties.getWall().getCharacter()) {
                    coloredPrinter.setBackgroundColor(Ansi.BColor.valueOf(wall));
                } else {
                    coloredPrinter.setBackgroundColor(Ansi.BColor.valueOf(empty));
                }
            }
        }
    }
}
