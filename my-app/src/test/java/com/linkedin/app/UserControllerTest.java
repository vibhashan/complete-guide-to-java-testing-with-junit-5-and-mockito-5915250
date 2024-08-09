package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  @InjectMocks
  private UserController underTest;

  private final User USER = new User("John Doe", "john.doe@example.com");

  @Test
  public void createUser() throws Exception {
    when(userService.saveUser(any(User.class))).thenReturn(USER);
    MvcResult mvcResult = mockMvc.perform(post("/users")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\":\"John Doe\", \"email\":\"john.doe@example.com\"}"))
        .andExpect(status().isOk())
        .andReturn();

    ObjectMapper objectMapper = new ObjectMapper();
    User result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
        User.class);

    assertEquals(USER.getId(), result.getId());
    assertEquals(USER.getName(), result.getName());
    assertEquals(USER.getEmail(), result.getEmail());
    verify(userService).saveUser(any(User.class));
  }

  @Test
  public void getUserById() throws Exception {
    when(userService.getUserById(1L)).thenReturn(Optional.of(USER));
    mockMvc.perform(get("/users/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("John Doe"))
        .andExpect(jsonPath("$.email").value("john.doe@example.com"));
    verify(userService).getUserById(1L);
  }

  @Test
  public void getUserById_notFound() throws Exception {
    mockMvc.perform(get("/users/2"))
        .andExpect(status().isNotFound());

    verify(userService).getUserById(2L);
  }

}
