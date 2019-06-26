package ru.example.democlient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;

@Service
public class CellServiceRest implements CellService {

    private final RestTemplate restTemplate;
    private final String serverUrl;

    public CellServiceRest(
            RestTemplate restTemplate, @Value("${application.server.url}") String serverUrl
    ) {
        this.restTemplate = restTemplate;
        this.serverUrl = serverUrl;
    }

    @Override
    public HashSet<Cell> getNextGeneration() {
        return restTemplate.exchange(
                serverUrl + "/life-cells",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<HashSet<Cell>>() {
                }
        ).getBody();
    }

}
