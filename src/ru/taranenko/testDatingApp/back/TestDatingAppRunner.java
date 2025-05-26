package ru.taranenko.testDatingApp.back;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class TestDatingAppRunner {
    public static void main(String[] args) throws IOException, InterruptedException {
        try (HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build()) {

            HttpRequest httpRequest = HttpRequest.newBuilder(URI.create("http://localhost:8080"))
                    .setHeader("My-Token", "asddfghgfj")
                    .GET()
                    .build();

            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            Map<String, List<String>> map = httpResponse.headers().map();

            System.out.println(httpResponse.statusCode());
            System.out.println();
            System.out.println(map);
            System.out.println(httpResponse.body());
        }

//                Socket socket = new Socket("localhost", 8080);
//             DataOutputStream rqStream = new DataOutputStream(socket.getOutputStream());
//             DataInputStream rsStream = new DataInputStream(socket.getInputStream());
//             Scanner scanner = new Scanner(System.in)) {
//                 while (scanner.hasNextLine()) {
//                     String request = scanner.nextLine();
//                     rqStream.writeUTF(request);
//                     String response = rsStream.readUTF();
//                     System.out.println(response);
//                 }
//        }
    }
}