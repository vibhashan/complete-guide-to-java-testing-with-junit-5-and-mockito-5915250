package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserApplicationIT {

  @Autowired
  private TestRestTemplate restTemplate;

  private static final String NAME = "John Doe";
  private static final String EMAIL = "john.doe@example.com";

  @Test
  public void createUser() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> request = new HttpEntity<>("{\"name\":\"" + NAME
        + "\"," + " \"email\":\"" + EMAIL + "\"}", headers);

    ResponseEntity<User> response = restTemplate.postForEntity("/users",
        request, User.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
    assertEquals(NAME, response.getBody().getName());
    assertEquals(EMAIL, response.getBody().getEmail());
    assertNotNull(response.getBody().getId());
  }

  @Test
  public void createUserAndRetrieve() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<String> request = new HttpEntity<>("{\"name\":\"" + NAME
        + "\"," + " \"email\":\"" + EMAIL + "\"}", headers);
    ResponseEntity<User> savedUserResponse = restTemplate.postForEntity("/users",
        request, User.class);

    assertNotNull(savedUserResponse.getBody());

    ResponseEntity<User> fetchedUserResponse = restTemplate.getForEntity("/users/"
        + savedUserResponse.getBody().getId(),
        User.class);

    assertEquals(HttpStatus.OK, fetchedUserResponse.getStatusCode());
    assertNotNull(fetchedUserResponse.getBody());

    assertEquals(NAME, fetchedUserResponse.getBody().getName());
    assertEquals(EMAIL, fetchedUserResponse.getBody().getEmail());
    assertEquals(savedUserResponse.getBody().getId(), fetchedUserResponse.getBody().getId());
  }

  @Test
  public void getUserById_notFound() {
    ResponseEntity<User> response = restTemplate.getForEntity("/users/999",
        User.class);
    assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
  }
}
