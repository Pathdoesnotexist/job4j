package ru.job4j.transform;

import java.util.*;

public class UserConvert {
    List<User> list = new ArrayList<>();

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> userHashMap = new HashMap<>();
    for (User user: list) {
        userHashMap.put(user.getId(), user);
    }
        return userHashMap;
    }
}
