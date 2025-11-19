package com.ak.junit.assertions;

import com.ak.MyService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class FailTest {
    @Test
    public void failTest_01(){
        MyService service = new MyService();

        try {
            service.methodThrowsException();
            fail("Above method should throw exception...");
        }catch (Exception e){
            // Expecting the control should reach here
            System.out.println("Inside catch block...");
        }

    }
}
