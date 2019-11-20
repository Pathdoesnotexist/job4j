package ru.job4j.сomparisons;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;

public class SortUsersTest {

    @Test
    public void sortTest() {
        SortUsers sortUsers = new SortUsers();
        List<User> users = new ArrayList<>();

        users.add(new User("Anton", 52));
        users.add(new User("Victor", 12));
        users.add(new User("Vlad", 3));
        users.add(new User("Irina", 37));
        Set<User> treeSet = sortUsers.sort(users);
        for (User user: treeSet) {
            System.out.println(user.getName() + " " + user.getAge());
        }
          int expected = users.get(2).getAge();
//          int result = treeSet.get(0).getAge(); нет доступа к методу get()

//        Assert.assertThat(result, is(expected));
    }
}
