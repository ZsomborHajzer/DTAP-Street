package com.ZsomborSebastian.JabberPoint;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class JabberPointTest {

    @Test
    public void testMain() {
        assertDoesNotThrow(() -> JabberPoint.main(new String[]{}));
    }
}