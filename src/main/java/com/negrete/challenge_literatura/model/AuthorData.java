package com.negrete.challenge_literatura.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthorData(
    @JsonProperty("name") String name,
    @JsonProperty("birth_year") Integer birthYear,
    @JsonProperty("death_year") Integer deathYear
) {}
