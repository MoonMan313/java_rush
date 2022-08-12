package edu.school21.printer.app;

import edu.school21.printer.logic.PrintImage;

public class ImagesToChar {

    private static void error(String message) {
        System.err.println(message);
        System.exit(0);
    }


    public static void main(String[] args) {
        if (args.length != 2 || args[0].length() != 1 || args[1].length() != 1) {
            error("Enter <symbol for white color> <symbol for black color>");
        }

        PrintImage myImage = new PrintImage(args[0].charAt(0), args[1].charAt(0));
        myImage.print();
    }
}
