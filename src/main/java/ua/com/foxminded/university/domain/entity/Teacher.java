package ua.com.foxminded.university.domain.entity;

import ua.com.foxminded.university.domain.Schedule;

public class Teacher extends Person {
    private Position position;
    private int salary;
    private Schedule teacherSchedule;

    public Teacher() {
    }

    public Teacher(int id, String firstName, String lastName, int birthDay, int birthMonth, int birthYear,
            int enrollmentDay, int enrollmentMonth, int enrollmentYear, Position position, int salary) {
        super(id, firstName, lastName, birthDay, birthMonth, birthYear, enrollmentDay, enrollmentMonth, enrollmentYear);

        this.position = position;
        this.salary = salary;
        teacherSchedule = new Schedule();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Schedule getTeacherSchedule() {
        return teacherSchedule;
    }

    public void setTeacherSchedule(Schedule teacherSchedule) {
        this.teacherSchedule = teacherSchedule;
    }

    public void displayMonthSchedule(int month) {
        teacherSchedule.displayMonth(month);
    }

    public void displayDaySchedule(int month, int day) {
        teacherSchedule.displayDay(month, day);
    }

    @Override
    public String toString() {
        String output = super.toString() + ", position: " + position.toString() + ", salary: " + salary;
        return output;
    }

}
