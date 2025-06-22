package com.negrete.challenge_literatura.model;

import java.util.List;

public enum Language {
    ENGLISH("en"), SPANISH("es");

    private final String value;

    Language (String value) {
        this.value = value;
    }

    public static Language findLanguage(List<String> values) {
        var value = values.getFirst();
        for (Language l : Language.values()) {
            if (l.value.equals(value)) {
                return l;
            }
        }

        return null;
    }


}
