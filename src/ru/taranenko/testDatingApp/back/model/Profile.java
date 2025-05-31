package ru.taranenko.testDatingApp.back.model;

public class Profile {
    private long id;

    private String email;
    private String name;
    private String surname;
    private String about;

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Profile{" +
                " id = " + id +
                ", email = " + email +
                ", name = " + name +
                ", surname = " + surname +
                ", about = " + about +
                '}';
    }
}
