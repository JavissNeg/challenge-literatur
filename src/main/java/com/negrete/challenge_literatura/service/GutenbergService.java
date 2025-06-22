package com.negrete.challenge_literatura.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.negrete.challenge_literatura.model.ApiDataRes;
import com.negrete.challenge_literatura.model.BookData;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class GutenbergService {
    private static final String API_URL = "http://gutendex.com/books/?search=";
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Optional<BookData> searchBookByTitle(String title) {
        try {
            String url = API_URL + URLEncoder.encode(title, StandardCharsets.UTF_8);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                ApiDataRes apiDataRes = objectMapper.readValue(response.body(), ApiDataRes.class);

                if (apiDataRes != null && apiDataRes.count() > 0 && apiDataRes.results() != null && !apiDataRes.results().isEmpty()) {
                    return Optional.of(apiDataRes.results().getFirst());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
