package com.fuseworks.labs.playground.endless;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class EndlessServiceImplTest {

    private EndlessService subject;

    @Before
    public void setUp() {
        subject = new EndlessServiceImpl();
    }

    @Test
    public void getPhotos_gets_photos(){

        List<Photo> photos = subject.getPhotos();

        System.out.println(photos);
    }
}