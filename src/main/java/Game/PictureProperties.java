package Game;

import java.io.*;
import java.util.Properties;
import java.io.File;
import java.io.FileReader;


public class PictureProperties {

    class CharAndColor {
        private String color;
        private Character character;

        public CharAndColor(String color, Character character) {
            this.color = color;
            this.character = character;
        }

        public String getColor() {
            return color;
        }

        public char getCharacter() {
            return character;
        }
    }

    private CharAndColor enemy;
    private CharAndColor player;
    private CharAndColor wall;
    private CharAndColor goal;
    private CharAndColor empty;


    public PictureProperties(String profile) throws IOException {
        File file = new File(profile);

        Properties properties = new Properties();
        properties.load(new FileReader(file));

        enemy = new CharAndColor(properties.getProperty("enemy.color"), properties.getProperty("enemy.char").charAt(0));
        player = new CharAndColor(properties.getProperty("player.color"), properties.getProperty("player.char").charAt(0));
        wall = new CharAndColor(properties.getProperty("wall.color"), properties.getProperty("wall.char").charAt(0));
        goal = new CharAndColor(properties.getProperty("goal.color"), properties.getProperty("goal.char").charAt(0));
        empty = new CharAndColor(properties.getProperty("empty.color"), properties.getProperty("empty.char", "  ").charAt(0));
    }

    public CharAndColor getEnemy() {
        return enemy;
    }

    public CharAndColor getPlayer() {
        return player;
    }

    public CharAndColor getWall() {
        return wall;
    }

    public CharAndColor getGoal() {
        return goal;
    }

    public CharAndColor getEmpty() {
        return empty;
    }
}
