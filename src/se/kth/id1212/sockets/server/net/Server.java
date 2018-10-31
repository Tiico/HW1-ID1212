package se.kth.id1212.sockets.server.net;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class Server implements Runnable{

    protected int          serverPort   = 8080;
    protected ServerSocket serverSocket = null;
    protected boolean      isStopped    = false;
    protected Thread       runningThread= null;

    public Server(int port) {
        this.serverPort = serverPort;
    }
}