package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class GymMembershipTest {

  private GymMembership membership;
  private String memberName = "John Doe";
  private String memberEmail = "john.doe@example.com";

  @Nested
  class BasicMembershipTests {

    @BeforeEach
    void setUp() {
      membership = new GymMembership(MembershipType.BASIC, memberName, memberEmail);
    }

    @Test
    void upgradeToPremium() {
      membership.upgradeMembership();
      assertEquals(MembershipType.PREMIUM, membership.getMembershipType());
      assertEquals(50, membership.calculateMonthlyFee());
    }

    @Test
    void cancelMembership() {
      membership.cancelMembership();
      assertFalse(membership.isActive());
    }
  }

  @Nested
  class PremiumMembershipTests {

    @BeforeEach
    void setUp() {
      membership = new GymMembership(MembershipType.PREMIUM, memberName, memberEmail);
    }

    @Test
    void upgradeToVip() {
      membership.upgradeMembership();
      assertEquals(MembershipType.VIP, membership.getMembershipType());
      assertEquals(80, membership.calculateMonthlyFee());
    }

    @Test
    void cancelMembership() {
      membership.cancelMembership();
      assertFalse(membership.isActive());
    }
  }

  @Nested
  class VipMembershipTests {

    @BeforeEach
    void setUp() {
      membership = new GymMembership(MembershipType.VIP, memberName, memberEmail);
    }

    @Test
    void attemptToUpgradeVip() {
      membership.upgradeMembership();
      assertEquals(MembershipType.VIP, membership.getMembershipType()); // VIP cannot upgrade further
      assertEquals(80, membership.calculateMonthlyFee());
    }

    @Test
    void cancelMembership() {
      membership.cancelMembership();
      assertFalse(membership.isActive());
    }
  }
}