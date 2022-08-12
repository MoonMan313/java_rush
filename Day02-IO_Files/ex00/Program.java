import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    private static final String SIGNATURES_FILE = "signatures.txt";
    private static final String RESULT_FILE = "result.txt";


    private static String  nexConvert(FileInputStream file) throws IOException {
        int oneByte;

        String nexStr = "";
        while ((oneByte = file.read()) != -1) {
            nexStr += String.format("%02X ", oneByte).toLowerCase(Locale.ROOT);
        }
        return nexStr;
    }

    private static HashMap<String, String> parserFileSignatures() throws IOException {
        HashMap<String, String> signatures = new HashMap<>();
        FileInputStream fileSignatures = new FileInputStream(SIGNATURES_FILE);
        int byteCount = fileSignatures.available();
        byte[] buffer = new byte[byteCount];

        fileSignatures.read(buffer, 0, byteCount);

        String strSignatures = new String(buffer);

        String[] arrStr = strSignatures.split("\n");

        for (int i = 0; i < arrStr.length; ++i) {
            String[] pair = arrStr[i].split(",");
            signatures.put(pair[0], pair[1].trim().toLowerCase(Locale.ROOT));
        }
        fileSignatures.close();
        return signatures;
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String inputFile = input.nextLine();

        FileOutputStream result = new FileOutputStream(RESULT_FILE);
        HashMap<String, String> signatures = parserFileSignatures();

        boolean isProcessed = false;

        while (!inputFile.equals("42")) {
            try {
                FileInputStream file = new FileInputStream(inputFile);
                String hexFile = nexConvert(file);

                for (String key : signatures.keySet()) {
                    int countByte = signatures.get(key).length();
                    String values = signatures.get(key);

                    if (values.equals(hexFile.substring(0, countByte))) {
                        result.write(key.getBytes());
                        result.write('\n');
                        System.out.println("PROCESSED");
                        isProcessed = true;
                        break;
                    }
                }
                if(!isProcessed) {
                    System.out.println("UNDEFINED");
                }
                file.close();
            } catch (IOException e) {
                System.err.println("UNDEFINED");
            }
            inputFile = input.nextLine();
            isProcessed = false;
            }
        result.close();
    }
}
