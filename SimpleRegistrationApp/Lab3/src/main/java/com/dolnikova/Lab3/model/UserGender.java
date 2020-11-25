package com.dolnikova.Lab3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@AllArgsConstructor
public enum UserGender {

    MALE(Constants.MALE), FEMALE(Constants.FEMALE), OTHER(Constants.OTHER);

    private static final UserGender[] GENDERS = {MALE, FEMALE, OTHER};

    @Getter
    private String type;

    @JsonCreator
    public static UserGender of(@JsonProperty("userGender") String value) {
        return Stream.of(GENDERS)
                .filter(userGender -> userGender.toString().equals(value))
                .findFirst()
                .orElseGet(() -> Stream.of(GENDERS)
                        .filter(userGender -> userGender.getType().equals(value))
                        .findFirst()
                        .orElse(null));
    }

    public static final class Constants {
        public static final String MALE = "Male";
        public static final String FEMALE = "Female";
        public static final String OTHER = "Other";
    }

}
