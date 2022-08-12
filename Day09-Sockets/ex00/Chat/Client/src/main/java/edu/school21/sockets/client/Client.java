package edu.school21.sockets.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private int port;
    private BufferedWriter writer;
    private BufferedReader reader;
    private Scanner scanner;

    public Client(int port) {
        this.port = port;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        try (Socket client = new Socket("127.0.0.1", port)) {
            reader = new BufferedReader(
                new InputStreamReader(
                        client.getInputStream()));
            writer = new BufferedWriter(
                new OutputStreamWriter(
                        client.getOutputStream()));

            String message = reader.readLine();
            while (!message.equals("Successful!")) {
                System.out.println(message);
                sendMessageFromServer(scanner.nextLine());
                message = reader.readLine();
            }
            System.out.println(message);
            reader.close();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessageFromServer(String message) throws IOException {
        writer.write(message);
        writer.newLine();
        writer.flush();
    }
}
