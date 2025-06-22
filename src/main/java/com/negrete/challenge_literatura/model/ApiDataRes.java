package com.negrete.challenge_literatura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiDataRes(
    @JsonProperty("count") int count,
    @JsonProperty("results") List<BookData> results
) {}
