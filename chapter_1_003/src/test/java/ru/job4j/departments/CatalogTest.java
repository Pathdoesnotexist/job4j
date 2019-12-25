package ru.job4j.departments;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import static org.hamcrest.core.Is.is;

public class CatalogTest {

    @Test
    public void addNotExistedK1AndK2SK1() {
        Catalog wrap = new Catalog();
        List<String> catalog = wrap.catalog;
        catalog.add("K1\\SK2");
        catalog.add("K1\\SK1\\SSK1");
        catalog.add("K1\\SK1\\SSK2");
        catalog.add("K2\\SK1\\SSK1");
        catalog.add("K2\\SK1\\SSK2");
        wrap.fillGaps(catalog);
        String k2 = catalog.get(7);
        String k2Sk1 = catalog.get(8);
        Assert.assertThat(k2, is("K2"));
        Assert.assertThat(k2Sk1, is("K2\\SK1"));
    }

    @Test
    public void absSort() {
        Catalog wrap = new Catalog();
        List<String> catalog = wrap.catalog;
        catalog.add("K1\\SK2");
        catalog.add("K1\\SK1\\SSK1");
        catalog.add("K1\\SK1\\SSK2");
        catalog.add("K2\\SK1\\SSK1");
        catalog.add("K2\\SK1\\SSK2");
        wrap.fillGaps(catalog);
        wrap.abs(catalog);

        StringJoiner joiner = new StringJoiner(", ");
            joiner.add("[K1");
             joiner.add("K1\\SK1");
             joiner.add("K1\\SK1\\SSK1");
             joiner.add("K1\\SK1\\SSK2");
             joiner.add("K1\\SK2");
             joiner.add("K2");
             joiner.add("K2\\SK1");
             joiner.add("K2\\SK1\\SSK1");
             joiner.add("K2\\SK1\\SSK2]");
        String expected = joiner.toString();
        Assert.assertThat(catalog.toString(), is(expected));
    }

    @Test
    public void descSort() {
        Catalog wrap = new Catalog();
        List<String> catalog = wrap.catalog;
        catalog.add("K1\\SK2");
        catalog.add("K1\\SK1\\SSK1");
        catalog.add("K1\\SK1\\SSK2");
        catalog.add("K2\\SK1\\SSK1");
        catalog.add("K2\\SK1\\SSK2");
        wrap.fillGaps(catalog);
        wrap.desc(catalog);

        String expected = "[K2, "
                         + "K2\\SK1, "
                         + "K2\\SK1\\SSK2, "
                         + "K2\\SK1\\SSK1, "
                         + "K1, "
                         + "K1\\SK2, "
                         + "K1\\SK1, "
                         + "K1\\SK1\\SSK2, "
                         + "K1\\SK1\\SSK1]";
        Assert.assertThat(catalog.toString(), is(expected));
    }
}
