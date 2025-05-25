package ru.taranenko.testDatingApp.back.controller;

import ru.taranenko.testDatingApp.back.model.Profile;
import ru.taranenko.testDatingApp.back.service.ProfileService;

import java.util.Optional;

public class ProfileController {

    private final ProfileService service;

    public ProfileController(ProfileService service) {
        this.service = service;
    }

    public String save(String save) {
        String[] params = save.split("; ");
        if (params.length != 4) return "Bad request: need 4 numbers parameter";

        Profile profile = new Profile();
        profile.setEmail(params[0]);
        profile.setName(params[1]);
        profile.setSurname(params[2]);
        profile.setAbout(params[3]);

        return service.save(profile).toString();
    }

    public String findById(String targetId) {
        String[] params = targetId.split("; ");
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
        String[] params = newProfile.split("; ");
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
        String[] params = targetId.split("; ");
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
        String[] params = profileData.split("; ");

        if (params.length < 4) return null;

        Profile profile = new Profile();
        profile.setEmail(params[0]);
        profile.setName(params[1]);
        profile.setSurname(params[2]);
        profile.setAbout(params[3]);
        return profile;
    }

//    public String work (String request) {
//
//    }
}
