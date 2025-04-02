package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskManagerTest {
    private TaskManager taskManager;
    private static Task task1;
    private static Task task2;

    @BeforeAll
    static void beforeAll() {
        task1 = new Task();
        task1.setDescription("My first task");

        task2 = new Task();
        task2.setDescription("My second task");
    }

    @BeforeEach
    void beforeEach() {
        taskManager = new TaskManager();
    }

    @AfterAll
    static void afterAll() {
        task1 = null;
        task2 = null;
    }

    @AfterEach
    void afterEach() {
        taskManager = null;
    }

    @Test
    void addTask() {
        Task task = new Task();
        assertFalse(taskManager.exists(task.getId()));

        taskManager.addTask(task);
        assertTrue(taskManager.exists(task.getId()));
    }

    @Test
    void addTaskDuplicates() {
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        assertTrue(taskManager.exists(task1.getId()));
        assertTrue(taskManager.exists(task2.getId()));
        assertEquals(2, taskManager.getTaskCount());
    }

    @Test
    void removeTask() {
        Task nonexistingTask = new Task();
        nonexistingTask.setId(5);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> taskManager.removeTask(task1));
        assertEquals("No tasks to remove", e.getMessage());

        taskManager.addTask(task1);
        assertEquals(1, taskManager.getTaskCount());

        IllegalArgumentException e1 = assertThrows(IllegalArgumentException.class,
                () -> taskManager.removeTask(nonexistingTask));
        assertEquals("Task does not exist", e1.getMessage());

        taskManager.removeTask(task1);
        assertEquals(0, taskManager.getTaskCount());
    }

    @Test
    void getTask() {
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> taskManager.getTaskById(1));
        assertEquals("No tasks to retrieve", e.getMessage());

        taskManager.addTask(task1);
        taskManager.addTask(task2);

        assertNotNull(taskManager.getTaskById(2));

        IllegalArgumentException e1 = assertThrows(IllegalArgumentException.class, () -> taskManager.getTaskById(99));
        assertEquals("Task does not exist", e1.getMessage());
    }
}
