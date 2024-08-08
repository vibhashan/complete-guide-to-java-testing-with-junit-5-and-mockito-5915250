package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MemberTest {

  @Test
  public void getMemberFields() {
    String memberId = "MEM001";
    String name = "John Doe";

    Member member = new Member(memberId, name);
    assertEquals(memberId, member.getMemberId());
    assertEquals(name, member.getName());
  }
}
