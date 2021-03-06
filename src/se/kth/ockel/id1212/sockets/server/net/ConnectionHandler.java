package se.kth.ockel.id1212.sockets.server.net;

import se.kth.ockel.id1212.sockets.server.controller.ServerController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionHandler {

    private ServerController serverController;

    public ConnectionHandler(int port, ServerController serverController){
        this.serverController = serverController;
        try(ServerSocket serverSocket = new ServerSocket(port)){
            while (true){
                Socket socket = serverSocket.accept();
                Thread handlerThread = new Thread(new RequestHandler(socket, serverController));
                handlerThread.setPriority(Thread.MAX_PRIORITY);
                handlerThread.start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
