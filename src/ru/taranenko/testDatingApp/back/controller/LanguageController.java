package ru.taranenko.testDatingApp.back.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Dmitrii Taranenko
 */
@WebServlet("/lang")
public class LanguageController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lang = req.getParameter("lang");
        Cookie cookie = new Cookie("lang", "en");
        if("ru".equals(lang)) {
            cookie.setValue("ru");
        }
        resp.addCookie(cookie);
        String referer = req.getHeader("referer");
        resp.sendRedirect(referer);
    }
}
