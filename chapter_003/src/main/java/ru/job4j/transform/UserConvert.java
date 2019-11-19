package ru.job4j.transform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UserConvert {
    List<User> list = new ArrayList<>();

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> userHashMap = new HashMap<>();
    for (User user: list) {
        userHashMap.put(user.getId(), user);
    }
        return userHashMap;
    }

    public static void main(String[] args) {
        UserConvert wrap = new UserConvert();
        wrap.list.add(new User(1487, "Jack", "London"));
        wrap.list.add(new User(2570, "Saul", "Haifa"));
        wrap.list.add(new User(9088, "Oleg", "Rostov"));

        for (User user: wrap.list)
        System.out.println("ID:" + user.getId() + " | Name: " + user.getName() + " | City: " + user.getCity());

        HashMap<Integer, User> userMap = wrap.process(wrap.list);
        System.out.println(userMap.keySet());
        System.out.println(userMap.values());

    }

}
