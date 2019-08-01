package ua.com.foxminded.university.domain.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClassTest {
    Campus campus = new Campus();
    private Teacher teacher = new Teacher(2, "firstName_3", "lastName_3", 12, 10, 1958, 1, 8, 1987, Position.PROFESSOR,
            6000);
    private Classroom room = new Classroom(campus, 101, 30);
    private Subject subject = new Subject(Subjects.MATHEMATICS, teacher, "description_1");
    private Class clas = new Class(room, teacher, subject, 8, 0, 1, 9, 2019, 9, 30, 1, 9, 2019);

    @Test
    public void displayClassShouldReturnProperString() {
        String result = clas.displayClass();
        String expected = "class name: Class, begin time: 08:00 01-09-2019, end time: 09:30 01-09-2019, subject: MATHEMATICS, classroom: 101, teacher: firstName_3 lastName_3";
        assertEquals(expected, result);
    }
}
