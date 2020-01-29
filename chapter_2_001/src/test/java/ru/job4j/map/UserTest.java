package ru.job4j.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.*;

public class UserTest {
    User user1;
    User user2;

    @Before
    public void beforeTest() {
        user1 = new User("Dmitriy", 2, new GregorianCalendar(1990, Calendar.MARCH, 25));
        user2 = new User("Dmitriy", 2, new GregorianCalendar(1990, Calendar.MARCH, 25));
    }

    @Test
    public void whenAddTwoUsersShouldReturnSize2() {
        Map<User, Object> map = new HashMap<>();
        map.put(user1, 10001);
        map.put(user2, 10002);
        System.out.println(map);
        System.out.println(user1.equals(user2));
        Assert.assertThat(map.size(), is(1));
    }
}
