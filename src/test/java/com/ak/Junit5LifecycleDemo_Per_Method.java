package com.ak;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class Junit5LifecycleDemo_Per_Method {
    public Junit5LifecycleDemo_Per_Method(){
        System.out.println("Inside Junit5LifecycleDemo_Per_Method()...");
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Inside beforeAll()...");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("Inside beforeEach()...");
    }

    @Test
    public void testOne(){
        System.out.println("Inside testOne()...");
    }

    @Test
    public void testTwo(){
        System.out.println("Inside testTwo()...");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("Inside afterEach()...");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Inside afterAll()...");
    }
}
