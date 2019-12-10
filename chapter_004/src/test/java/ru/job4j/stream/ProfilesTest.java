package ru.job4j.stream;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;

public class ProfilesTest {
    @Test
    public void sortByCity() {
        Profiles wrap = new Profiles();
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow ", "Mira ", 15, 269)),
                new Profile(new Address("Yaroslavl ", "Pravda ", 2, 19)),
                new Profile(new Address("Arkhangelsk ", "Navratilova ", 68, 85)));

        List<Address> addresses = wrap.collect(profiles);
        String expected0 = "Город: Arkhangelsk  Улица: Navratilova  Дом: 68 Квартира: 85";
        String expected1 = "Город: Moscow  Улица: Mira  Дом: 15 Квартира: 269";
        String expected2 = "Город: Yaroslavl  Улица: Pravda  Дом: 2 Квартира: 19";

        Assert.assertThat(addresses.get(0).toString(), is(expected0));
        Assert.assertThat(addresses.get(1).toString(), is(expected1));
        Assert.assertThat(addresses.get(2).toString(), is(expected2));
    }

    @Test
    public void sortByCityAndDeleteClones() {
        Profiles wrap = new Profiles();
        List<Profile> profiles = List.of(
                new Profile(new Address("Arkhangelsk ", "Navratilova ", 68, 85)),
                new Profile(new Address("Yaroslavl ", "Pravda ", 2, 19)),
                new Profile(new Address("Arkhangelsk ", "Navratilova ", 68, 85)),
                new Profile(new Address("Yaroslavl ", "Pravda ", 2, 42)),
                new Profile(new Address("Yaroslavl ", "Pravda ", 2, 42)),
                new Profile(new Address("Yaroslavl ", "Pravda ", 2, 19)),
                new Profile(new Address("Yaroslavl ", "Pravda ", 2, 42)),
                new Profile(new Address("Arkhangelsk ", "Navratilova ", 68, 85)));

        List<Address> addresses = wrap.collect(profiles);
        String expected0 = "Город: Arkhangelsk  Улица: Navratilova  Дом: 68 Квартира: 85";
        String expected1 = "Город: Yaroslavl  Улица: Pravda  Дом: 2 Квартира: 19";
        String expected2 = "Город: Yaroslavl  Улица: Pravda  Дом: 2 Квартира: 42";
        int size = addresses.size();

        Assert.assertThat(addresses.get(0).toString(), is(expected0));
        Assert.assertThat(addresses.get(1).toString(), is(expected1));
        Assert.assertThat(addresses.get(2).toString(), is(expected2));
        Assert.assertThat(size, is(3));
    }

}
