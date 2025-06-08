package ru.taranenko.testDatingApp.back.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home-page-MyDatingApp")
public class HomePage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // TODO: create these way to show html for all classes (LikeController.java; ProfileController.java)
        req.getRequestDispatcher("HomePage.jsp").forward(req, resp);
    }
}
