package com.fuseworks.labs.playground.endless;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class EndlessServiceImpl implements EndlessService {

    public static final String PHOTOS_URI = "https://jsonplaceholder.typicode.com/photos";

    @Override
    public List<Photo> getPhotos() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ArrayNode> response =
                restTemplate.getForEntity(PHOTOS_URI, ArrayNode.class);
        ArrayList<Photo> responseList = new ArrayList<>();
        response.getBody().spliterator().forEachRemaining(jsonNode -> {
            responseList.add(
                    new Photo(
                            jsonNode.get("id").asLong(),
                            jsonNode.get("albumId").asLong(),
                            jsonNode.get("title").asText(),
                            jsonNode.get("url").asText(),
                            jsonNode.get("thumbnailUrl").asText()
                    ));
        });
        return responseList;
    }
}
