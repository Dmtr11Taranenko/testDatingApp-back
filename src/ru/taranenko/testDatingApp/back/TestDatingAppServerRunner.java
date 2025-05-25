package ru.taranenko.testDatingApp.back;

import ru.taranenko.testDatingApp.back.controller.ProfileController;
import ru.taranenko.testDatingApp.back.dao.ProfileDao;
import ru.taranenko.testDatingApp.back.service.ProfileService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static ru.taranenko.testDatingApp.back.model.Commands.*;

public class TestDatingAppServerRunner {
    public static void main(String[] args) throws IOException {

        ProfileController controller = new ProfileController(new ProfileService(new ProfileDao()));

        try (ServerSocket serverSocket = new ServerSocket(8800);
            Socket socket = serverSocket.accept();
            DataOutputStream rsStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream rqStream = new DataInputStream(socket.getInputStream())
        ) {
            String request = rqStream.readUTF();
            while (!"stop".equals(request)) {
                String response;
                if (request.startsWith(SAVE.getPrefix())) {
                    response  = controller.save(request.split("save ")[1]);
                }
                else if (request.startsWith(FIND_BY_ID.getPrefix())) {
                    response = controller.findById(request.split("findById ")[1]);
                }
                else if (request.startsWith(FIND_ALL.getPrefix())) {
                    response = controller.findAll();
                }
                else if (request.startsWith(UPDATE.getPrefix())) {
                    response = controller.update(request.split("update ")[1]);
                }
                else if (request.startsWith(DELETE.getPrefix())) {
                    response = controller.deleteById(request.split("delete ")[1]);
                }
                else {
                    response = "Unsupported operation";
                }

                System.out.println("Client request: " + request);
                rsStream.writeUTF(response);
                request = rqStream.readUTF();

            }
        }
    }
}
