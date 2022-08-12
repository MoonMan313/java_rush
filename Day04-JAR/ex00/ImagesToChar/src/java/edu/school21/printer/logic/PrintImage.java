package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PrintImage {
    private char white;
    private char black;
    private char[][] image;
    private int height;
    private int width;

    public PrintImage(char white, char black, String imageFile) {
        this.white = white;
        this.black = black;
        convert(imageFile);
    }

    private void convert(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
        }
        this.height = img.getHeight();
        this.width = img.getWidth();

        this.image = new char[height][width];

        int pixelColor;
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                pixelColor = img.getRGB(i, j);
                if (pixelColor == -1) {
                    image[i][j] = white;
                } else {
                    image[i][j] = black;
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                System.out.print(image[j][i]);
            }
            System.out.println();
        }
    }
}
