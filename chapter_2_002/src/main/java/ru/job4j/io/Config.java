package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Config {
    private final String path; //путь к файлу конфигу
    private final Map<String, String> values = new HashMap<>(); //карта настрое

    public Config(final String path) { //конструктор создания конфига с путем к файлу
        this.path = path;
    }
    /**
     * Загрузка файла настроек в карту
     */
    public void load() {
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            List<String> pair;
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                pair = Arrays.asList(line.split("="));
                values.put(pair.get(0), pair.get(1));
            }

//            Scanner scanner = new Scanner(new FileReader(path));
//            List<String> pair;
//            while (scanner.hasNextLine()) {
//                pair = Arrays.asList(scanner.nextLine().split("="));
//                values.put(pair.get(0), pair.get(1));
//          }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Получение значения параметра по имени параметра
     * @param key имя параметра
     * @return значение параметра по имени
     */
    public String value(String key) {
//        throw new UnsupportedOperationException("Don't impl this method yet!");
        return this.values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Config wrap = new Config("./chapter_2_002/data/app.properties");
        System.out.println(wrap);
        wrap.load();
        System.out.println(wrap.values.toString());

    }
}
