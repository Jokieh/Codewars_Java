package com.jokieh.kyu_8;

import com.jokieh.kyu_8.Multiply;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MultiplyTest {

    @Test
    public void test_Associativity_Of_Multiplication() throws Exception {
        for (int i = 0; i < 100; i++) {
            Double a = Math.random();
            Double b = Math.random();
            Double c = Math.random();
            String message = String.format("(%g * %g) * %g == %g * (%g * %g)", a, b, c, a, b, c);
            assertEquals(message,
                    Multiply.multiply(Multiply.multiply(a, b), c),
                    Multiply.multiply(a, Multiply.multiply(b, c)),
                    1E-14);
        }
    }

}
