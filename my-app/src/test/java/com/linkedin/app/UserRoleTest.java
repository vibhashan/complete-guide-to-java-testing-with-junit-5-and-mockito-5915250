package com.linkedin.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserRoleTest {

  @Test
  void adminHasWritePermission() {
    UserRole role = UserRole.ADMIN;
    assertTrue(role.hasWritePermission());
  }

  @Test
  void moderatorHasWritePermission() {
    UserRole role = UserRole.MODERATOR;
    assertTrue(role.hasWritePermission());
  }

  @Test
  void userHasNoWritePermission() {
    UserRole role = UserRole.USER;
    assertFalse(role.hasWritePermission());
  }

  @Test
  void guestHasNoWritePermission() {
    UserRole role = UserRole.GUEST;
    assertFalse(role.hasWritePermission());
  }
}
