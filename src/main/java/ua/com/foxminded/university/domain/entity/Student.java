package ua.com.foxminded.university.domain.entity;

import ua.com.foxminded.university.domain.Schedule;

public class Student extends Person {
    private int matriculationnumber;
    private Group group;
    private Schedule studentSchedule;

    public Student(int id, String firstName, String lastName, int birthDay, int birthMonth, int birthYear,
            int enrollmentDay, int enrollmentMonth, int enrollmentYear) {
        super(id, firstName, lastName, birthDay, birthMonth, birthYear, enrollmentDay, enrollmentMonth, enrollmentYear);
        group = null;
        studentSchedule = new Schedule();
    }

    public int getMatriculationnumber() {
        return matriculationnumber;
    }

    public void setMatriculationnumber(int matriculationnumber) {
        this.matriculationnumber = matriculationnumber;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Schedule getStudentSchedule() {
        return studentSchedule;
    }

    public void setStudentSchedule(Schedule studentSchedule) {
        this.studentSchedule = studentSchedule;
    }

    public void addClassToSchedule(Lesson c) {
        studentSchedule.addClass(c);
    }

    public void removeClassFromSchedule(Lesson c) {
        studentSchedule.removeClass(c);
    }

    public void displayMonthSchedule(int month) {
        studentSchedule.displayMonth(month);
    }

    public void displayDaySchedule(int month, int day) {
        studentSchedule.displayDay(month, day);
    }

    @Override
    public String toString() {
        String output = super.toString() + ", group: "
                + (group == null ? "there is no group yet" : group.getGroupNumber()) + " matriculationnumber: "
                + matriculationnumber;
        return output;
    }
}