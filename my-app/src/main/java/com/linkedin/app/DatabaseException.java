package com.linkedin.app;

public class DatabaseException extends RuntimeException {

  public DatabaseException(String message) {
    super(message);
  }
}