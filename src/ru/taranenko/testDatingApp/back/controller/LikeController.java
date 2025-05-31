package ru.taranenko.testDatingApp.back.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/like")
public class LikeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write(
            "<html>"+
                "<head>" +
                    "<meta charset=\"UTF-8\">" +
                    "<title>10</title>" +
                "</head>" +
                "<body>" +
                    "<h1>10</h1>" +
                    "<a href='/home-page-MyDatingApp'>Назад на главную проекта</a>" +
                "</body>" +
            "</html>");
    }
}
