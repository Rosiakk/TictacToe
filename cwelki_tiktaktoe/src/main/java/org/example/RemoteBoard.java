package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class RemoteBoard extends Board{


    Symbol[][] socketBoard = new Symbol[3][3];
    private ServerSocket serverSocket;
    PrintWriter writer;

    public RemoteBoard(Symbol[][] symbolBoard) throws IOException {
        super(symbolBoard);
    }
    
    public void port() throws IOException {
       this.serverSocket = new ServerSocket(3000);
    }


//    public void listen() throws IOException {
//        System.out.println("Server started");
//        Socket socket = serverSocket.accept();
//        System.out.println("Client connected");
//        InputStream input = socket.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
//        OutputStream output = socket.getOutputStream();
//        writer = new PrintWriter(output, true);
//        socket.close();
//        System.out.println("Client disconnected");
//
//    }


    @Override
    public void start() {
        try {
            Socket socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void playGame(Player player1, Player player2) {

    }
}
