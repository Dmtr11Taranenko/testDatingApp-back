package ru.taranenko.testDatingApp.back;

import ru.taranenko.testDatingApp.back.controller.LikeController;
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

        LikeController likeController = new LikeController();
        ProfileController controller = new ProfileController(new ProfileService(new ProfileDao()));
        TestDatingAppHttpServer testDatingAppHttpServer = new TestDatingAppHttpServer(8080, 5, controller, likeController);
        testDatingAppHttpServer.start();
    }
}
