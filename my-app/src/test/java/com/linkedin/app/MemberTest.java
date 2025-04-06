package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MemberTest {
    private static Member member;

    @BeforeAll
    static void beforeAll() {
        member = new Member("M001", "Jonathan");
    }

    @AfterAll
    static void afterAll() {
        member = null;
    }

    @Test
    void getMemberId() {
        assertEquals("M001", member.getMemberId());
    }

    @Test
    void getName() {
        assertEquals("Jonathan", member.getName());
    }
}
