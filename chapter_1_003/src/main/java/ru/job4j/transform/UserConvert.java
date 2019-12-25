package ru.job4j.transform;

import java.util.*;

public class UserConvert {
    List<TransformUser> list = new ArrayList<>();

    public HashMap<Integer, TransformUser> process(List<TransformUser> list) {
        HashMap<Integer, TransformUser> userHashMap = new HashMap<>();
    for (TransformUser user: list) {
        userHashMap.put(user.getId(), user);
    }
        return userHashMap;
    }
}
