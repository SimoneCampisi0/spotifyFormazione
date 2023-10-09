package com.simonecampisi.spotifyFormazione.model.enums;

public enum GenereMusicale {
    ROCK,
    POP,
    HIP_HOP,
    ELETTRONICA,
    JAZZ,
    CLASSICA,
    RAP,
    COUNTRY,
    METAL,
    REGGAE;

    public static boolean isValid(String value) {
        try {
            GenereMusicale.valueOf(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
