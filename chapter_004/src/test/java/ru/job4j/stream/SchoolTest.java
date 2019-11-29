package ru.job4j.stream;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;

public class SchoolTest {
    int groupSize = 90;

    @Test
    public void when0To50() {
     School school = new School();
     List<Student> group = school.group;
     while (group.size() < this.groupSize) {
         school.group.add(new Student((int) (Math.random() * 100)));
     }
     Predicate<Student> filter = x -> x.getScore() <= 50;

     List<Student> filteredGroup = school.collect(group, filter);
     boolean result = filteredGroup.stream().allMatch(filter);

     Assert.assertTrue(result);
    }

    @Test
    public void when51To70() {
        School school = new School();
        List<Student> group = school.group;
        while (group.size() < this.groupSize) {
            school.group.add(new Student((int) (Math.random() * 100)));
        }
        Predicate<Student> filter = x -> x.getScore() > 50 && x.getScore() <= 70;

        List<Student> filteredGroup = school.collect(group, filter);
        boolean result = filteredGroup.stream().allMatch(filter);

        Assert.assertTrue(result);
    }

    @Test
    public void when71To100() {
        School school = new School();
        List<Student> group = school.group;
        while (group.size() < this.groupSize) {
            school.group.add(new Student((int) (Math.random() * 100)));
        }
        Predicate<Student> filter = x -> x.getScore() > 70;

        List<Student> filteredGroup = school.collect(group, filter);
        boolean result = filteredGroup.stream().allMatch(filter);

        Assert.assertTrue(result);
    }
}
