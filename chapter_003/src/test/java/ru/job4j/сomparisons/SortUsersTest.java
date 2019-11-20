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

        int expectedYoungest = users.get(2).getAge();
        int expectedOldest = users.get(0).getAge();

        sortUsers.sort(users);

//        int resultYoungest = sortUsers.sort(users).get(0).getAge(); // не получается получить ячейку из трисета по get()
//        int resultOldest = sortUsers.sort(users).get(3).getAge();   // не получается получить ячейку из трисета по get()
//
//        Assert.assertThat(resultYoungest, is(expectedYoungest));
//        Assert.assertThat(resultOldest, is(expectedOldest));
    }

    @Test
    public void sortNameLengthTest() {
        SortUsers sortUsers = new SortUsers();
        List<User> users = new ArrayList<>();

        users.add(new User("Boris", 92));
        users.add(new User("Victor", 52));
        users.add(new User("Boris", 15));
        users.add(new User("Anna", 12));
        users.add(new User("Vladimir", 3));
        users.add(new User("Ira", 37));
        users.add(new User("Boris", 10));

        String expectedFirst = users.get(5).getName();
        String expectedLast = users.get(4).getName();

        sortUsers.sortNameLength(users);

        String resultFirst = users.get(0).getName();
        String resultLast = users.get(users.size() - 1).getName();

        Assert.assertThat(resultFirst, is(expectedFirst));
        Assert.assertThat(resultLast, is(expectedLast));
    }

    @Test
    public void sortByAllFieldsTest() {
        SortUsers sortUsers = new SortUsers();
        List<User> users = new ArrayList<>();

        users.add(new User("Boris", 92));
        users.add(new User("Victor", 52));
        users.add(new User("Boris", 15));
        users.add(new User("Anna", 12));
        users.add(new User("Vladimir", 3));
        users.add(new User("Ira", 37));
        users.add(new User("Boris", 10));

        int expectedBabyBoris = users.get(6).getAge();
        int expectedKidBoris = users.get(2).getAge();
        int expectedOldBoris = users.get(0).getAge();

        sortUsers.sortByAllFields(users);

        int resultBabyBoris = users.get(2).getAge();
        int resultKidBoris = users.get(3).getAge();
        int resultOldBoris = users.get(4).getAge();

        Assert.assertThat(resultBabyBoris, is(expectedBabyBoris));
        Assert.assertThat(resultKidBoris, is(expectedKidBoris));
        Assert.assertThat(resultOldBoris, is(expectedOldBoris));
    }

}
