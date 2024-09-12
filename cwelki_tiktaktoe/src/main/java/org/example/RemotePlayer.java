package org.example;

import java.io.*;
import java.net.Socket;

public class RemotePlayer extends Player{



    Socket socket;
    BufferedReader reader ;
    PrintWriter writer;
    private volatile boolean running = true;

    public RemotePlayer(String address, int port) throws IOException {
        socket = new Socket(address, port);
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();
        reader = new BufferedReader(new InputStreamReader(input));
        writer = new PrintWriter(output, true);

    }

    public void run() {

        try {
            String message;
            // Odbieranie wiadomości od serwera
            while (running && (message = reader.readLine()) != null) {
                System.out.println("Received from server: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection();  // Zamykanie połączenia po zakończeniu
        }
    }

    private void closeConnection() {
        try {
            if (reader != null) reader.close();
            if (writer != null) writer.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String message){
        writer.println(message);
    }

    public static void main(String[] args) throws IOException {
//        Client client = new Client("localhost", 3000);
//        new Thread(client).start();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        while (true){
//            String message = reader.readLine();
//            client.send(message);
//        } 


    }


    @Override
    public void playTurn(Symbol[][] board) {

    }

    @Override
    public String inform(String text) {
        return null;
    }
}
