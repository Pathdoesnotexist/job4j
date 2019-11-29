package ru.job4j.stream;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;

public class ProfilesTest {
    @Test
    public void streetAdd() {
        Profiles wrap = new Profiles();
        List<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile(new Address("Moscow ", "Mira ", 15, 269)));
        profiles.add(new Profile(new Address("Rostov ", "Pravda ", 2, 19)));
        profiles.add(new Profile(new Address("Novgorod ", "Navratilova ", 68, 85)));

        List<Address> addresses = wrap.collect(profiles);
        String expected0 = "Город: Moscow  Улица: Mira  Дом: 15 Квартира: 269";
        String expected1 = "Город: Rostov  Улица: Pravda  Дом: 2 Квартира: 19";
        String expected2 = "Город: Novgorod  Улица: Navratilova  Дом: 68 Квартира: 85";

        Assert.assertThat(addresses.get(0).toString(), is(expected0));
        Assert.assertThat(addresses.get(1).toString(), is(expected1));
        Assert.assertThat(addresses.get(2).toString(), is(expected2));
    }
}
