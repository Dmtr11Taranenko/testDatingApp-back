package ru.taranenko.testDatingApp.back.dao;

import ru.taranenko.testDatingApp.back.model.Gender;
import ru.taranenko.testDatingApp.back.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ProfileDao {

    private static final ProfileDao INSTANCE = new ProfileDao();

    private final ConcurrentHashMap<Long, Profile> storage;

    private final AtomicLong idStorage;

    private ProfileDao() {
        this.storage = new ConcurrentHashMap<>();
        Profile profile = new Profile();
        profile.setId(1L);
        profile.setEmail("ivanov@mail.ru");
        profile.setName("Ivan");
        profile.setSurname("Ivanov");
        profile.setAbout("Man");
        profile.setGender(Gender.MALE);
        this.storage.put(1L, profile);
        Profile profile1 = new Profile();
        profile1.setId(2L);
        profile1.setEmail("dtaranenko1@g.nsu.ru");
        profile1.setName("Dmitrii");
        profile1.setSurname("Taranenko");
        profile1.setAbout("Creator");
        profile1.setGender(Gender.MALE);
        this.storage.put(2L, profile1);
        this.idStorage = new AtomicLong(2L);
    }

    public static ProfileDao getInstance() { return INSTANCE; }

    public Profile save(Profile profile) {
        long id = idStorage.incrementAndGet();
        profile.setId(id);
        storage.put(id, profile);
        System.out.println(storage.values());
        return profile;
    }

    public Optional<Profile> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public Optional<List<Profile>> findByProfile(Profile profile) {
        List<Profile> targetProfile = new ArrayList<>();
        if (storage.containsValue(profile)) {
            storage.values()
                    .stream()
                    .filter(profile::equals)
                    .forEach(p -> targetProfile.add((Profile) p));
            return Optional.of(targetProfile);
        } else {
            return Optional.empty();
        }
    }

    public List<Profile> findAll() { return new ArrayList<>(storage.values()); }

    public boolean deleteById(Long id) {
        return storage.remove(id) != null;
    }

    public void update(Profile profile) {
        Long id = profile.getId();
        if (id == null) return;
        storage.put(id, profile);
    }
}
