package com.linkedin.app;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userServiceMock;

    @InjectMocks
    private UserController userController;

    private static final User USER = new User("John Doe", "test@gmail");

    @Test
    void createUser() throws Exception {
        when(userServiceMock.saveUser(USER)).thenReturn(USER);

        mockMvc.perform(MockMvcRequestBuilders.post("/users", USER))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(USER.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(USER.getEmail()));

    }

    @Test
    void getExisitingUserById() throws Exception {
        when(userServiceMock.getUserById(1L)).thenReturn(Optional.of(USER));

        mockMvc.perform(MockMvcRequestBuilders.get("/users/1")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(USER.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(USER.getEmail()));

        verify(userServiceMock).getUserById(1L);
    }

    @Test
    void getNonExisitingUserById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/2")).andExpect(MockMvcResultMatchers.status().isNotFound());

        verify(userServiceMock).getUserById(2L);
    }
}
