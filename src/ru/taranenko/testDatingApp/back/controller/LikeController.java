package ru.taranenko.testDatingApp.back.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.taranenko.testDatingApp.back.service.LikeService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/like")
public class LikeController extends HttpServlet {

    private LikeService likeService = LikeService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String answer = "";
        if (id != null) {
            long l = Long.parseLong(id);
            long answerL = likeService.getLikesById(l);
            answer = answerL + "";
        }

        // TODO: redesign way of show html page (create footer and header)

        String userAgent = req.getHeader("User-Agent");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Title", "10");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h1>" + answer + "</h1>");
            writer.write("<h3>" + userAgent + "</h3>");
            writer.write("<h1>" + req.getRequestURL() + "</h1>");
            writer.write("<a href='/home-page-MyDatingApp'>Main</a>");
        }
    }
}
