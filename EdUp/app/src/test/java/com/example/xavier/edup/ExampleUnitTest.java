package com.example.xavier.edup;

import org.junit.Test;
import problem.*;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void addition_isCorrect2() throws Exception {
        Generator gen = Generator.getInstance();

        System.out.println(gen.makeProblem(1,1).toString());
        assertEquals(4, 2 + 2);
    }


}