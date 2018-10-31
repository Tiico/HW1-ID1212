package se.kth.id1212.sockets.server.starter;

import se.kth.id1212.sockets.server.net.Server;

public class starter {
    public static void main(String[] args) {
        Server server = new Server(2319);
        new Thread(server).start();

        try {
            Thread.sleep(50 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stopping Server");
        server.stop();
    }
}
