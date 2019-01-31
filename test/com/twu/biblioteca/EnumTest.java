package com.twu.biblioteca;


import com.twu.biblioteca.helpers.EnumParser;
import com.twu.biblioteca.helpers.MenuTypes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EnumTest {

    @Test
    public void whenNeedParseAIntToAEnum() {
        assertEquals(EnumParser.intToEnum(1), MenuTypes.LISTOFBOOKS);
    }

}
