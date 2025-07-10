package ru.taranenko.testDatingApp.back.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.taranenko.testDatingApp.back.model.Profile;
import java.io.IOException;

/**
 * @author Dmitrii Taranenko
 */
@WebServlet("/registration")
public class RegistrationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("profile", new Profile());
        req.getRequestDispatcher("ProfilePage.jsp").forward(req, resp);
    }
}
