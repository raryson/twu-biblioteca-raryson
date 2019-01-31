package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EnumTest {

    @Test
    public void whenNeedParseAIntToAEnum() {
        assertEquals(EnumParser.intToEnum(1), MenuTypes.LISTOFBOOKS);
    }

}
