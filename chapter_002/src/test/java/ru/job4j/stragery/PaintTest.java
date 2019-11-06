package ru.job4j.stragery;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
//    @Test
//    public void whenDrawSquare() {
//        // получаем ссылку на стандартный вывод в консоль.
//        PrintStream stdout = System.out;
//        // Создаем буфер для хранения вывода.
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        //Заменяем стандартный вывод на вывод в пямять для тестирования.
//        System.setOut(new PrintStream(out));
//        // выполняем действия в консоль.
//        new Paint().draw(new Square());
//        // проверяем результат вычисления
//        assertThat(
//                new String(out.toByteArray()),
//                is(
//                        new StringBuilder()
//                                .append("++++++++++\n")
//                                .append("+        +\n")
//                                .append("+        +\n")
//                                .append("++++++++++")
//                                .append(System.lineSeparator())
//                                .toString()
//                )
//        );
//        // возвращаем обратно стандартный вывод в консоль.
//        System.setOut(stdout);
//    }
}
