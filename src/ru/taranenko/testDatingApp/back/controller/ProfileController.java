package ru.taranenko.testDatingApp.back.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
        String response = "";

        if ("findById".equals(method)) {
            String id = req.getParameter("id");
            String forwardUri = "/notFound";
            if (id != null) {
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        String response = "";

        if("save".equals(method)) {
            String params = req.getParameter("email") + " " +
                    req.getParameter("name") + " " +
                    req.getParameter("surname") + " " +
                    req.getParameter("about") + " ";
            response = save(params);
        }
        if ("update".equals(method)) {
            String params = req.getParameter("id") + " " +
                    req.getParameter("email") + " " +
                    req.getParameter("name") + " " +
                    req.getParameter("surname") + " " +
                    req.getParameter("about") + " ";
            response = update(params);
        }
        if ("deleteById".equals(method)) {
            String params = req.getParameter("id");
            response = deleteById(params);
        }

        req.setAttribute("response", response);
        req.getRequestDispatcher("ProfileControllerPage.jsp").forward(req, resp);
    }

    public String save(String save) {
        String[] params = save.split(" ");
        if (params.length != 4) return "Bad request: need 4 numbers parameter";

        Profile profile = new Profile();
        profile.setEmail(params[0]);
        profile.setName(params[1]);
        profile.setSurname(params[2]);
        profile.setAbout(params[3]);

        return service.save(profile).toString();
    }

    public Optional<Profile> findById(Long targetId){
        return service.findById(targetId);

    }

    public String findById(String targetId) {
        String[] params = targetId.split(" ");
        if (params.length != 1) return "Bad request: need one number parameter";

        long id;
        try {
            id = Long.parseLong(params[0]);
        } catch (NumberFormatException e) {
            return "Bad request: can't parse string [" + params[0] + "] to long.";
        }
        Optional<Profile> maybeProfile = service.findById(id);
        if(maybeProfile.isEmpty()) return "Not found";

        return maybeProfile.toString();
    }

    public String findAll() { return service.findAll().toString(); }

    public String update(String newProfile) {
        String[] params = newProfile.split(" ");
        if (params.length != 5) return "Bad request: need 5 parameters to update profile";

        long id;
        try {
            id = Long.parseLong(params[0]);
        } catch (NumberFormatException e) {
            return "Bad request: can't parse string [" + params[0] + "] to long.";
        }

        Profile profile = new Profile();
        profile.setId(id);
        profile.setEmail(params[1]);
        profile.setName(params[2]);
        profile.setSurname(params[3]);
        profile.setAbout(params[4]);

        service.update(profile);
        return "Updated successfully";
    }

    public String deleteById(String targetId) {
        String[] params = targetId.split(" ");
        if (params.length != 1) return "Bad request: need one number parameter";

        long id;
        try {
            id = Long.parseLong(params[0]);
        } catch (NumberFormatException e) {
            return "Bad request: can't parse string [" + params[0] + "] to long.";
        }

        boolean result = service.delete(id);
        if (!result) return "Not found";
        return "Deleted successfully";
    }

    private Profile setProfile(String profileData) {
        String[] params = profileData.split(" ");

        if (params.length < 4) return null;

        Profile profile = new Profile();
        profile.setEmail(params[0]);
        profile.setName(params[1]);
        profile.setSurname(params[2]);
        profile.setAbout(params[3]);
        return profile;
    }
}
