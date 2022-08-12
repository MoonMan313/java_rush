package edu.school21.sockets.server;

import edu.school21.sockets.config.SocketsApplicationConfig;
import edu.school21.sockets.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    private int port;
    private BufferedWriter writer;
    private BufferedReader reader;
    private final ApplicationContext context;


    public Server(int port) {
        context = new AnnotationConfigApplicationContext(SocketsApplicationConfig.class);
        this.port = port;
    }

    public void run() {

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server started!");

            try (Socket socket = server.accept()) {

                System.out.println("Client connected");

                reader = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));

                writer = new BufferedWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream()));

                sendMessageFromServer("Hello from Server!");

                commandWaiting();

                reader.close();
                writer.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessageFromServer(String message) throws IOException {
        writer.write(message);
        writer.newLine();
        writer.flush();
    }

    public void commandWaiting() throws IOException {
        String request;
        request = reader.readLine();

        while (true) {
            if (request.equals("signUp")) {
                signUp();
                break;
            } else if (request.equals("exit")) {
                return;
            } else {
                sendMessageFromServer("Enter \"signUp\" for registration or \"exit\" to end the program");
            }
            request = reader.readLine();
        }
    }

    public void signUp() throws IOException {
        UsersService usersService = context.getBean(UsersService.class);
        sendMessageFromServer("Enter username:");
        String userName = reader.readLine();
        sendMessageFromServer("Enter password:");
        String password = reader.readLine();

        usersService.signUp(userName, password);
        sendMessageFromServer("Successful!");
    }
}