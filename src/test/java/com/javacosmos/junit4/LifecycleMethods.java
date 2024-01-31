package com.javacosmos.junit4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class LifecycleMethods {
  @BeforeClass
  static void beforeAll() {
    System.out.println("Before all test methods");
  }

  @Before
  void beforeEach() {
    System.out.println("Before each test method");
  }

  @After
  void afterEach() {
    System.out.println("After each test method");
  }

  @AfterClass
  static void afterAll() {
    System.out.println("After all test methods");
  }
}
