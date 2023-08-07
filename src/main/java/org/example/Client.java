package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        clientSendUsername("Alex");

    }
    public static void clientSendUsername(String username) {
        String host = "localhost";
        int port = 8081;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) {
            out.println(username);
            String resp = in.readLine();
            System.out.println(resp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
