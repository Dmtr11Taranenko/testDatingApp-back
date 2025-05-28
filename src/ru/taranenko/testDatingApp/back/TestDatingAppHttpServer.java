package ru.taranenko.testDatingApp.back;

import ru.taranenko.testDatingApp.back.controller.LikeController;
import ru.taranenko.testDatingApp.back.controller.ProfileController;
import ru.taranenko.testDatingApp.back.model.Profile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestDatingAppHttpServer {

    private final int port;
    private final ExecutorService threadPool;

    private final ProfileController profileController;
    private final LikeController likeController;

    public TestDatingAppHttpServer(int port, int poolSize, ProfileController profileController, LikeController likeController) {
        this.port = port;
        this.threadPool = Executors.newFixedThreadPool(poolSize);
        this.profileController = profileController;
        this.likeController = likeController;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket connection = serverSocket.accept();
                System.out.println("===== Client connected =====");
                threadPool.submit(() -> processConnection(connection));
            }
        }
    }

    private void processConnection(Socket connection) {
        try (connection;
             BufferedReader rqStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
             DataOutputStream rsStream = new DataOutputStream(connection.getOutputStream());
        ) {
            while (!rqStream.ready());
            String[] firstParams = null;
            while(rqStream.ready()) {
                String nextLine = rqStream.readLine();
                if (firstParams == null) {
                    firstParams = nextLine.split(" ");
                }
                System.out.println(nextLine);
            }
            String statusString = "404 Not Found";
            byte[] body = new byte[0];

            if (firstParams != null && firstParams.length == 3) {
                Map<String, String> queryParams = getQueryParams(firstParams[1]);
                String bodyString = null;
                if (firstParams[1].startsWith("/profile")) {
                    if ("GET".equals(firstParams[0])) {
                        if (queryParams.get("id") != null) {
                            Optional<Profile> maybeProfile = profileController.findById(Long.parseLong(queryParams.get("id")));
                            if (maybeProfile.isPresent()) bodyString = maybeProfile.get().toString();
                        } else {
                            bodyString = profileController.findAll();
                        }
                    }
                } else if (firstParams[1].startsWith("/like")) {
                    if ("GET".equals(firstParams[0])) {
                        bodyString = likeController.count() + "";
                    }
                }
                if (bodyString != null) {
                    statusString = "200 OK";
                    body = "<p>%s<p>".formatted(bodyString).getBytes();
                }
            }
            byte[] startString = "HTTP/1.1 200 OK\n".getBytes();
            byte[] headers = "Connect-Type: text/plain\nContent-Length: %s\n\n".formatted(body.length).getBytes();
            byte[] emptyLine = "\r\n".getBytes();

            rsStream.write(startString);
            rsStream.write(headers);
            rsStream.write(emptyLine);
            rsStream.write(body);
            System.out.println("=== Client disconnected ===");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private Map<String, String> getQueryParams(String url) {
        Map<String, String> result = new HashMap<>();
        if (!url.contains("?")) return result;
        String[] queryParams = url.split("\\?")[1].split("&");
        for (String param : queryParams) {
            String[] pair = param.split("=");
            result.put(pair[0], pair[1]);
        }
        return result;
    }
}
