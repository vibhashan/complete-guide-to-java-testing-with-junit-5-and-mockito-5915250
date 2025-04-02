package com.linkedin.app;

import java.util.HashMap;
import java.util.Map;

public class TaskManager {
	private Map<Integer, Task> tasks;

	public TaskManager() {
		tasks = new HashMap<>();
	}

	public void addTask(Task task) {
		tasks.put(task.getId(), task);
	}

	public boolean exists(int id) {
		return tasks.containsKey(id);
	}

	public int getTaskCount() {
		return tasks.size();
	}

	public void removeTask(Task task) {
		if (tasks.isEmpty())
			throw new IllegalStateException("No tasks to remove");
		else if (exists(task.getId()))
			tasks.remove(task.getId());
		else
			throw new IllegalArgumentException("Task does not exist");
	}

	public Task getTaskById(Integer id) {
		if (tasks.isEmpty())
			throw new IllegalStateException("No tasks to retrieve");
		else if (exists(id))
			return tasks.get(id);
		else
			throw new IllegalArgumentException("Task does not exist");
	}
}
