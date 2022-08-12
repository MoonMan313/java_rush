package edu.school21.printer.app;

import edu.school21.printer.logic.PrintImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

public class ImagesToChar {

    private static final String BMP_SIGNATURE = "42 4d";

    private static void error(String message) {
        System.err.println(message);
        System.exit(0);
    }

    private static boolean checkSignature(String signature, String fileName) {
        try {
            FileInputStream file = new FileInputStream(fileName);
            int oneByte;
            String nexStr = "";

            for (int i = 0; (oneByte = file.read()) != -1; ++i) {
                nexStr += String.format("%02X ", oneByte).toLowerCase(Locale.ROOT);
            }
            file.close();
            if (signature.equals(nexStr.substring(0, signature.length()))) {
                return true;
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        if (args.length != 3 || args[0].length() != 1 || args[1].length() != 1) {
            error("Enter <symbol for white color> <symbol for black color> <file_name.bmp>");
        }

        if (!checkSignature(BMP_SIGNATURE, args[2])) {
            error("This is not a bmp file");
        }

        PrintImage myImage = new PrintImage(args[0].charAt(0), args[1].charAt(0), args[2]);
        myImage.print();
    }
}
