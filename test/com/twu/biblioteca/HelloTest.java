package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloTest {

    @Test
    public void WhenUserEnterInApplication() {
        final String expectedHelloMessage = "Welcome to Biblioteca." +
                " Your one-stop-shop for great book title in Bangalore!";
        assertEquals(Messages.helloMessage(), expectedHelloMessage);
    }
}
