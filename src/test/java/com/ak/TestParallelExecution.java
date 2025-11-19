package com.ak;

import org.junit.jupiter.api.*;

public class TestParallelExecution {

    public TestParallelExecution(){
        System.out.println("Inside TestParallelExecution...");
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
    public void testOne() throws InterruptedException {
        System.out.println("Inside testOne(), Executed By : "+Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.println("Finished testOne...");
    }
    @Test
    public void testTwo() throws InterruptedException {
        System.out.println("Inside testTwo(), Executed By : "+Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.println("Finished testTwo...");
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
