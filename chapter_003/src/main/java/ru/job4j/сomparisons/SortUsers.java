package ru.job4j.сomparisons;

import java.util.*;

public class SortUsers {

    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }
    public List<User> sortNameLength(List<User> users) {
        Comparator<User> nComp = new NameComparator();
        users.sort(nComp);
        return users;
    }

    public List<User> sortByAllFields(List<User> users) {
        Comparator<User> allComp = new NameComparator().thenComparing(new AgeComparator());
        users.sort(allComp);
        return users;
    }


}
