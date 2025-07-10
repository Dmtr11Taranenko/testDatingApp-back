package ru.taranenko.testDatingApp.back.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.taranenko.testDatingApp.back.service.LikeService;

import java.io.IOException;

@WebServlet("/like")
public class LikeController extends HttpServlet {

    private LikeService likeService = LikeService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String answer = "";
        String userAgent = req.getHeader("User-Agent");
        if (id != null) {
            long l = Long.parseLong(id);
            long answerL = likeService.getLikesById(l);
            answer = answerL + "";
        }

        req.setAttribute("userAgent", userAgent);
        req.setAttribute("answer", answer);
        req.setAttribute("reqURL", req.getRequestURL());
        req.getRequestDispatcher("LikePage.jsp").forward(req, resp);
    }
}
