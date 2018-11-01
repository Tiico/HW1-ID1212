package se.kth.ockel.id1212.sockets.server.net;

import se.kth.ockel.id1212.sockets.server.controller.ServerController;


import java.io.*;
import java.net.Socket;

public class RequestHandler implements Runnable {

    private Socket socket;
    private ServerController serverController;

    public RequestHandler(Socket socket, ServerController serverController) {
        this.serverController = serverController;
        this.socket = socket;
        System.out.printf("I got a task (%s)\n", socket.toString());
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()))) {
            String inputString = null;
            while ((inputString = reader.readLine()) != null) {
                System.out.println("Input: " + inputString);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
                writer.write("du sa: " + inputString);
                writer.flush();
                //serverController.parseCommand(inputString);
                if (inputString.equalsIgnoreCase("exit")) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}