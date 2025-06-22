package com.negrete.challenge_literatura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
    @JsonProperty("title") String title,
    @JsonProperty("authors") List<AuthorData> authors,
    @JsonProperty("languages") List<String> languages,
    @JsonProperty("download_count") Integer downloadCount
) {}
