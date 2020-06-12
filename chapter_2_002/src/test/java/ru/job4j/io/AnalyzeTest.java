package ru.job4j.io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalyzeTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenUsingTemporaryFolder() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.csv");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01" + System.lineSeparator() + "400 10:58:13" + System.lineSeparator() + "200 10:59:24");
        }
        Analyze wrap = new Analyze();
        wrap.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:58:13;10:59:24"));

    }

    @Test
    public void whenLogFromTestSource() throws IOException {
        String in = "./data/testSource.log";
        String out = "./data/testTarget.csv";
        Analyze wrap = new Analyze();
        wrap.unavailable(in, out);
        BufferedReader br = new BufferedReader(new FileReader("./data/testTarget.csv"));
        assertThat(br.readLine(), is("10:58:13;10:59:24"));
    }
    @Test
    public void whenLogFromRealSource() throws IOException {
        String in = "./data/server.log";
        String out = "./data/unavailable.csv";
        Analyze wrap = new Analyze();
        wrap.unavailable(in, out);
        BufferedReader br = new BufferedReader(new FileReader("./data/unavailable.csv"));
        assertThat(br.readLine(), is("10:58:13;10:59:24"));
        assertThat(br.readLine(), is("11:01:15;11:02:46"));
        assertThat(br.readLine(), is("11:58:27;18:02:50"));
    }

}
