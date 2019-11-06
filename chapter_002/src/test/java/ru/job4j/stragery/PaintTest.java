package ru.job4j.stragery;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PaintTest {

    @Test
    public void whenTriangle() {
        Shape triangle = new Triangle();
        String created = triangle.draw();
        String expected = "      +     \n" + "    +   +   \n" + "  +       + \n" + "+++++++++++++";
        assertThat(created, is(expected));
    }

    @Test
    public void whenSquare() {
        Shape square = new Square();
        String created = square.draw();
        String expected = "++++++++++\n" + "+        +\n" + "+        +\n" + "++++++++++";
        assertThat(created, is(expected));
    }
}
