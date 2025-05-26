package ru.taranenko.testDatingApp.back;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestDatingAppHttpServer {

    ExecutorService executorService;

    public TestDatingAppHttpServer(int poolSize) {
        this.executorService = Executors.newFixedThreadPool(poolSize);
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                Socket connection = serverSocket.accept();
                System.out.println("=== Client connected ===");
                executorService.submit(() -> processConnection(connection));
            }
        }
    }

    private void processConnection(Socket connection) {
        try (connection;
             BufferedReader rqStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
             DataOutputStream rsStream = new DataOutputStream(connection.getOutputStream());
        ) {
            while (!rqStream.ready());

            while(rqStream.ready()) {
                System.out.println(rqStream.readLine());
            }

            byte[] body = "Hi from TestDatingAppHttpServer!".getBytes();
            byte[] startString = "HTTP/1.1 200 OK\n".getBytes();
            byte[] headers = "Connect-Type: text/plain\nContent-Length: %s\n\n".formatted(body.length).getBytes();

            rsStream.write(startString);
            rsStream.write(headers);
            rsStream.write(body);
            System.out.println("=== Client disconnected ===");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
