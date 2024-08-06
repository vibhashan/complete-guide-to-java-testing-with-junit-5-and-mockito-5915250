package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskManagerTest {

  private static TaskManager underTest;
  private Task task;

  @BeforeEach
  void setUp() {
    underTest = new TaskManager();
    task = new Task("Read a book");
    assertEquals(0, underTest.count());
  }

  @Test
  public void addTask() {
    underTest.add(task);

    assertTrue(underTest.exists(task.getId()));
    assertEquals(1, underTest.count());
  }

  @Test
  public void addTask_duplicateTasks() {
    Task task2 = new Task("Do laundry");

    underTest.add(task);
    underTest.add(task2);
    assertTrue(underTest.exists(task.getId()));
    assertTrue(underTest.exists(task2.getId()));
    assertEquals(2, underTest.count());
  }

  @Test
  public void removeTask() {
    underTest.add(task);
    int preTaskCount = underTest.count();

    underTest.remove(task.getId());

    assertFalse(underTest.exists(task.getId()));
    assertEquals(preTaskCount - 1, underTest.count());
  }

  @Test
  public void getTask() {
    underTest.add(task);

    Task result = underTest.get(task.getId());

    assertEquals(task, result);
  }
}
