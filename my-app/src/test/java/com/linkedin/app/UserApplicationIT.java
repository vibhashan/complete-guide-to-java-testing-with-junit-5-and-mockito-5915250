package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserApplicationIT {
    @Autowired
    private TestRestTemplate restTemplate;

    private static final String NAME = "John Doe";
    private static final String EMAIL = "test@example.com";

    @Test
    void saveUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>("{\"name\":\"" + NAME + "\", \"email\":\"" + EMAIL + "\"}",
                headers);

        var response = restTemplate.postForEntity("/users", request, User.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(NAME, response.getBody().getName());
        assertEquals(EMAIL, response.getBody().getEmail());
        assertInstanceOf(Long.class, response.getBody().getId());
    }

    @Test
    void saveAndRetrieveUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>("{\"name\":\"" + NAME + "\", \"email\":\"" + EMAIL + "\"}",
                headers);

        var response = restTemplate.postForEntity("/users", request, User.class);
        var getResponse = restTemplate.getForEntity(String.format("/users/%d", response.getBody().getId()), User.class);

        assertNotNull(getResponse);
        assertEquals(NAME, getResponse.getBody().getName());
        assertEquals(EMAIL, getResponse.getBody().getEmail());
        assertEquals(response.getBody().getId(), response.getBody().getId());
    }

    @Test
    void getUserByIdNotFound() {
        var response = restTemplate.getForEntity("/users/99", User.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
