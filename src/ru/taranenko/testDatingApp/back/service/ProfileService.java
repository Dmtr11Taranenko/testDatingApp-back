package ru.taranenko.testDatingApp.back.service;

import ru.taranenko.testDatingApp.back.dao.ProfileDao;
import ru.taranenko.testDatingApp.back.model.Profile;

import java.util.List;
import java.util.Optional;

public class ProfileService {

    private final ProfileDao dao;

    public ProfileService(ProfileDao dao) {
        this.dao = dao;
    }

    public Profile save(Profile profile) {
        return dao.save(profile);
    }

    public Optional<Profile> findById(Long id) {
        if (id == null) return Optional.empty();
        return dao.findById(id);
    }

    public Optional<List<Profile>> findByProfile(Profile profile) {
        return dao.findByProfile(profile);
    }

    public List<Profile> findAll() { return dao.findAll(); }

    public boolean delete(Long id) {
        if (id == null) return false;
        return dao.deleteById(id);
    }

    public void update(Profile profile) {
        dao.update(profile);
    }
}
