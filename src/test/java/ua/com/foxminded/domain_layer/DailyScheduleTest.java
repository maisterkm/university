package ua.com.foxminded.domain_layer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ua.com.foxminded.university.domain.DailySchedule;
import ua.com.foxminded.university.entity.Campus;
import ua.com.foxminded.university.entity.Class;
import ua.com.foxminded.university.entity.Classroom;
import ua.com.foxminded.university.entity.Position;
import ua.com.foxminded.university.entity.Subject;
import ua.com.foxminded.university.entity.Subjects;
import ua.com.foxminded.university.entity.Teacher;

public class DailyScheduleTest {
    Teacher teacher = new Teacher(1, "Joe", "Black", 25, 10, 1965, 12, 11, 2001, Position.PROFESSOR, 5000);
    Classroom room = new Classroom(Campus.CAMPUS_A, 101, 30);
    Subject subject = new Subject(Subjects.MATHEMATICS, teacher, "description_1");
    Class class1 = new Class(room, teacher, subject, 8, 0, 1, 9, 2019, 9, 30, 1, 9, 2019);
    Class class2 = new Class(room, teacher, subject, 10, 0, 2, 9, 2019, 11, 30, 2, 9, 2019);
    DailySchedule dailySchedule = new DailySchedule();

    @Test
    public void displayDayShouldReturnProperString() {
        dailySchedule.addClass(class1);
        dailySchedule.addClass(class2);
        String result = dailySchedule.displayDay();
        String expected = "Sunday, 1 Septemberclass name: Class, begin time: 08:00 01-09-2019, end time: 09:30 01-09-2019, subject: MATHEMATICS, classroom: 101, teacher: Joe Blackclass name: Class, begin time: 10:00 02-09-2019, end time: 11:30 02-09-2019, subject: MATHEMATICS, classroom: 101, teacher: Joe Black";
        assertEquals(expected, result);
    }
    
    @Test
    public void addClassShouldAddClassToListsOfClasses() {
        dailySchedule.addClass(class1);
        dailySchedule.addClass(class2);
        int resultSize = dailySchedule.getListsOfClasses().size();
        int expectedSize = 2;
        assertEquals(expectedSize, resultSize);
    }
}
