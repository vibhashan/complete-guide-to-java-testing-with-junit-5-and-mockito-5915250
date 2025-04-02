package com.linkedin.app;

import lombok.Data;

@Data
public class Task {
	private Integer id;
	private String description;

	private static int counter = 0;

	public Task() {
		id = ++counter;
	}

	public void updateDescription(String desc) {
		setDescription(desc);
	}
}
