package ru.taranenko.testDatingApp.back.service;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author Dmitrii Taranenko
 */
public class WordBundle {

    private final ResourceBundle resourceBundle;

    public WordBundle(String lang) {
        Locale locale = Locale.of("en");

        if ("ru".equals(lang)) {
            locale = Locale.of("ru");
        }

        this.resourceBundle = ResourceBundle.getBundle("words", locale);
    }

    public String getWord(String key) {
        String result;
        try {
            result = resourceBundle.getString(key);
        } catch (MissingResourceException | ClassCastException e) {
            result = key;
        } catch (Exception e) {
            result = "=empty=";
        }
        return result;
    }
}
