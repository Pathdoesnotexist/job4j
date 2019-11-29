package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    /**
     * Получение списка адресов из профилей клиентов
     * @param profiles список профилей клентов
     * @return список адрессов
     */
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }
}
