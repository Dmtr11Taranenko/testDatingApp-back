package ru.taranenko.testDatingApp.back.dao;

import ru.taranenko.testDatingApp.back.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class ProfileDao {

    private final ConcurrentHashMap<Long, Profile> storage;

    private final AtomicLong idStorage;

    public ProfileDao() {
        this.storage = new ConcurrentHashMap<>();
        Profile profile = new Profile();
        profile.setId(1L);
        profile.setEmail("ivanov@mail.ru");
        profile.setName("Ivan");
        profile.setSurname("Ivanov");
        profile.setAbout("Man");
        this.storage.put(1L, profile);
        this.idStorage = new AtomicLong(1L);
    }

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
