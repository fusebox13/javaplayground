package com.fuseworks.labs.playground.endless;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


public interface EndlessService {
    public List<Photo> getPhotos();
}
