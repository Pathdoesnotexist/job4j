package ru.job4j.stragery;

import org.junit.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PaintTest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

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

    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("++++++++++\n")
                                .append("+        +\n")
                                .append("+        +\n")
                                .append("++++++++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        assertThat(
                this.out.toString(),
                is(
                        new StringBuilder()
                                .append("      +     \n")
                                .append("    +   +   \n")
                                .append("  +       + \n")
                                .append("+++++++++++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
