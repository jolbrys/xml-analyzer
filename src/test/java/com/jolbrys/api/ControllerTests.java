package com.jolbrys.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ControllerTests {

    @Test
    void checkExceptionInfo() {
        //given
        Controller con = new Controller();
        String expected = Controller.INVALID_URL_MESSAGE;

        //when
        String actual = con.index("https://s3-eu-west-1.amazonaws.com/this-file-certainly-does-not-exist.xml");

        //then
        assertEquals(expected, actual);
    }
}
