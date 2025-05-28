package ru.taranenko.testDatingApp.back.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/home-page")
public class HomePage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        var name = req.getReader().readLine();
        resp.getWriter().write(name + " Hello! This is my first project\n");
        resp.getWriter().write("So, if you want, you can stay here :/");
    }


}
