package se.kth.ockel.id1212.sockets.server.starter;

import se.kth.ockel.id1212.sockets.server.controller.ServerController;

public class ServerApp {

    private static int SERVER_PORT = 54321;

    public static void main(String[] args) {
        if (args.length > 0) {
            SERVER_PORT = Integer.parseInt(args[0]);
        }
        new ServerController(SERVER_PORT);
    }

}
