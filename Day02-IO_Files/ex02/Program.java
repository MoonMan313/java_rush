import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Program {

    private static Path curDir;

    private static void mv(String[] arr, Path path) throws IOException {
        Path tmp1 = Paths.get(curDir + "/" + arr[1]).normalize();
        Path tmp2 = Paths.get(curDir + "/" + arr[2]).normalize();

        if (Files.isRegularFile(tmp1)) {
            if (Files.isDirectory(tmp2))
                tmp2 = Paths.get(tmp2 + "/" + tmp1.getFileName());
            Files.move(tmp1, tmp2, REPLACE_EXISTING);
        }
        else
            System.out.println("Wrong source file path");

    }

    private static void ls(String[] arr, Path path) throws IOException {
        if (arr.length > 1) {
            System.out.println("Incorrect command");
            return;
        }

        List<Path> listFiles = Files.list(path).collect(Collectors.toList());
        for (Path tmp: listFiles) {
                System.out.println(tmp.getFileName() + " " + Files.size(tmp) + " KB");
        }

    }

    private static void cd(String[] arr, Path path) {

        Path allPath = Paths.get(path.toString() + "/" + arr[1].toString());
        if (Files.exists(allPath) && Files.isDirectory(allPath)) {
            curDir = allPath.normalize();
            System.out.println(path);
        }
        else
            System.out.println("Wrong path");
    }

    private static void runCommand(String[] values, Path path) throws IOException {
        switch (values[0]) {
            case "mv":
                mv(values, path);
                break;
            case "ls":
                ls(values, path);
                break;
            case "cd":
                cd(values, path);
                break;
            case "exit":
                System.exit(0);
            default:
                System.out.println("Not found command: " + values[0]);
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0 || !args[0].startsWith("--current-folder=")) {
            System.err.println("Specify the argument for the program in the form \"--current-folder=YOUR PATH\"");
            System.exit(-1);
        }

        Path mainPath = Paths.get(args[0].substring(17));
        System.out.println(mainPath);

        if (!Files.exists(mainPath)) {
            System.err.println("Not found your path: " + mainPath);
            System.exit(-1);
        }

        Scanner scanner = new Scanner(System.in);
        String termCommand = scanner.nextLine();

        String[] com;

        while (true) {
            com = termCommand.split(" ");
            runCommand(com, mainPath);
            termCommand = scanner.nextLine();
        }
    }
}
