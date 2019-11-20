package ru.job4j.сomparisons;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUsers {

    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }
}
