package ru.taranenko.testDatingApp.back.model;

import lombok.Data;

@Data
public class Profile {
    private long id;

    private String email;
    private String name;
    private String surname;
    private String about;
}
