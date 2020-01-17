package ru.job4j.generics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AbstractStoreTest {
    RoleStore roleStore;
    UserStore userStore;

    @Before
    public void setUp() {
        roleStore = new RoleStore(5);
        roleStore.add(new Role("23a"));
        roleStore.add(new Role("35a"));

        userStore = new UserStore(5);
        userStore.add(new User("67b"));
        userStore.add(new User("23t"));
        userStore.add(new User("03c"));
    }


    @Test
    public void whenElementFoundById() {
        Assert.assertThat(userStore.findById("67b").getId(), is("67b"));
    }

    @Test
    public void whenElementNotFoundById() {
        User expected = userStore.findById("ka-boom");
        Assert.assertNull(expected);
    }

    @Test
    public void whenAddElement() {
        roleStore.add(new Role("00z"));
        userStore.add(new User("00z"));
        Assert.assertThat(roleStore.findById("00z").getId(), is("00z"));
        Assert.assertThat(userStore.findById("00z").getId(), is("00z"));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddElementInFullArray() {
        roleStore.add(new Role("02w"));
        roleStore.add(new Role("13r"));
        roleStore.add(new Role("54h"));
        roleStore.add(new Role("ka-boom"));
    }

    @Test
    public void whenReplaceElement() {
        boolean result = userStore.replace("23t", new User("33f"));
        Assert.assertTrue(result);
    }
    @Test
    public void whenTryReplaceElementByWrongId() {
        boolean result = roleStore.replace("000", new Role("88u"));
        Assert.assertFalse(result);
    }
    @Test
    public void whenDeleteElement() {
        Assert.assertTrue(userStore.delete("23t"));
        Assert.assertTrue(roleStore.delete("35a"));
    }

    @Test
    public void whenDeleteElementByWrongId() {
        Assert.assertFalse(userStore.delete("00000000"));
        Assert.assertFalse(roleStore.delete("00000000"));
    }
}