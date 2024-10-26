package org.example.app;

import org.testng.annotations.*;

public class SimpleTest {

    @BeforeClass
    public void setUp() {
        System.out.println("TEST SET UP");
        // code that will be invoked when this test is instantiated
    }

    @Test(groups = {"fast"})
    public void aFastTest() {
        System.out.println("Fast test");
    }

    @Test(groups = {"slow"})
    public void aSlowTest() {
        System.out.println("Slow test");
    }

}