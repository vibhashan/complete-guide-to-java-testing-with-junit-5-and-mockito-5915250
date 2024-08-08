package com.linkedin.app;

interface UserRepository {
  User findById(String username);
}