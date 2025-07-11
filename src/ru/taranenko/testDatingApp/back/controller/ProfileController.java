package ru.taranenko.testDatingApp.back.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.taranenko.testDatingApp.back.model.Gender;
import ru.taranenko.testDatingApp.back.model.Profile;
import ru.taranenko.testDatingApp.back.service.ProfileService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/profile")
public class ProfileController extends HttpServlet {

    private static final ProfileController INSTANCE = new ProfileController();

    private final ProfileService service = ProfileService.getInstance();

    public ProfileController() { }

    public static ProfileController getInstance() { return INSTANCE; }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String method = req.getParameter("method");

        if ("findById".equals(method)) {
            String id = req.getParameter("id");
            String forwardUri = "/notFound";
            if (!id.isBlank()) {
                Optional<Profile> optional = service.findById(Long.parseLong(id));
                if (optional.isPresent()) {
                    forwardUri = "ProfilePage.jsp";
                    req.setAttribute("profile", optional.get());
                }
            }
            req.getRequestDispatcher(forwardUri).forward(req, resp);
        }
        if ("findAll".equals(method)) {
            List<Profile> profiles = service.findAll();
            req.setAttribute("profiles", profiles);
            req.getRequestDispatcher("AllProfilesMda.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Profile profile = setupProfile(req);
        long id = service.save(profile).getId();
        resp.sendRedirect(String.format("/profile?method=findById&id=%s", id));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Profile profile = setupProfile(req);
        service.update(profile);
        resp.sendRedirect(String.format("/profile?method=findById&id=%s", profile.getId()));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String sId = req.getParameter("id");
        if (!sId.isBlank() && !sId.equals("0")) {
            service.delete(Long.parseLong(sId));
        }
        resp.sendRedirect("/registration");
    }

    private Profile setupProfile(HttpServletRequest req) {
        Profile profile = new Profile();
        String sId = req.getParameter("id");
        if (!sId.isBlank() && !sId.equals("0")) {
            profile.setId(Long.parseLong(sId));
        }
        profile.setEmail(req.getParameter("email"));
        profile.setName(req.getParameter("name"));
        profile.setSurname(req.getParameter("surname"));
        profile.setAbout(req.getParameter("about"));
        profile.setGender(Gender.valueOf(req.getParameter("gender")));
        return profile;
    }
}
