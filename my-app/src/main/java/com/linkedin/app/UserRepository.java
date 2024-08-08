package com.linkedin.app;

public interface UserRepository {
  User findById(String userId);
}
