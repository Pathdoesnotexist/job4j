package ru.job4j.transform;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;

public class UserConvertTest {

    @Test
    public void keySetCompare() {
        UserConvert wrap = new UserConvert();
        wrap.list.add(new User(1487, "Jack", "London"));
        wrap.list.add(new User(2570, "Saul", "Haifa"));
        wrap.list.add(new User(9088, "Oleg", "Rostov"));

        HashMap<Integer, User> userMap = wrap.process(wrap.list);
        Set<Integer> result = userMap.keySet();
        String expected = "[9088, 2570, 1487]";
        Assert.assertThat(result.toString(), is(expected));


    }

}
