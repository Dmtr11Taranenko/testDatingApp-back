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
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println(
            "<html>"+
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                    "<title>MyDatingApp</title>" +
                "</head>" +
                "<body>" +
                    "<h1>Welcome to my Dating App!</h1>" +
                    "<h3>Here you can choose some method and look what happening </h3>" +
                    "<form action = \"like\" method = \"get\">" +
                        "<button type = \"submit\">Go to page with like</button>" +
                    "</form>" +

                    "<form action = \"forward\" method = \"get\">" +
                    "<button type = \"submit\">Go to page with forward</button>" +
                    "</form>" +

                    "<form action = \"profile.html\" method = \"get\">" +
                        "<button type = \"submit\">Go to page with profiles</button>" +
                    "</form>" +
                    "<a href='index.html'>Main</a>" +
                    "</body></html>");
    }
}
