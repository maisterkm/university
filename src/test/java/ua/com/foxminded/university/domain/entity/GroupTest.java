package ua.com.foxminded.university.domain.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GroupTest {
    Group group = new Group("mt-1", Faculties.FACULTY_OF_MATHEMATICS);
    Student student1 = new Student(1, "Eric", "Moore", 7, 2, 1999, 1, 9, 2016);

    @Test
    public void addStudentShouldIncreaseArrayList() {
        group.addStudent(student1);
        int resultSize = group.getStudentList().size();
        int expectedSize = 1;
        assertEquals(expectedSize, resultSize);
    }

    @Test
    public void removeStudentShouldDecreaseArrayList() {
        group.removeStudent(student1);
        int resultSize = group.getStudentList().size();
        int expectedSize = 0;
        assertEquals(expectedSize, resultSize);
    }

    @Test
    public void displayGroupShouldReturnProperString() {
        group.addStudent(student1);
        String result = group.displayGroup();
        String expected = "class name: Group, group number: mt-1, faculty: FACULTY_OF_MATHEMATICS\n"
                + "\tlist of students:\t1: class name: Student, id: 1, first name: Eric, last name: Moore, date of birth: 07 Feb 1999, enrollment date: 01 Sep 2016, group: mt-1";
        assertEquals(expected, result);
    }
}
