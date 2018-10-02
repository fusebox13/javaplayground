package com.fuseworks.labs.playground.endless;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.JstlUtils;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController("/photos")
public class EndlessController {

    EndlessServiceImpl endlessService;
    PhotoRepository repository;

    public EndlessController(EndlessServiceImpl endlessService, PhotoRepository repository) {
        this.endlessService = endlessService;
        this.repository = repository;
    }

    @Cacheable("photos")
    @RequestMapping( value = "photos", method = GET )
    @ResponseBody
    public Page<Photo> getPhotos(@PageableDefault(value=10, page=0) Pageable pageable
    ) {
        Page<Photo> page = repository.findAll(pageable);
        return page;

    }
}
