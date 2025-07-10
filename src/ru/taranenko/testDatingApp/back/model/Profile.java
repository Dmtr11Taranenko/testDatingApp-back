package ru.taranenko.testDatingApp.back.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Profile {
    private long id;
    private String email;
    private String name;
    private String surname;
    private String about;
}
