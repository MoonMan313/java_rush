package edu.school21.sockets.app;

import edu.school21.sockets.client.Client;

public class Main {
    public static void main(String[] args) {

        if (args.length > 1 && !args[0].startsWith("--server-port=")) {
            System.err.println("");
            System.exit(0);
        }

        int port = 8001;

        if (args.length == 1) {
            port = Integer.parseInt(args[0].substring(14));
        }

        Client client = new Client(port);
        try {
            client.run();
        } catch (RuntimeException e) {
            System.out.println("Connection is lost");
        }
    }
}
