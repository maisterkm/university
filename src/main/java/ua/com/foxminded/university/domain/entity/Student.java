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

    @Override
    public String toString() {
        String output = super.toString() + ", group: "
                + (group == null ? "there is no group yet" : group.getGroupNumber()) + " matriculationnumber: "
                + matriculationnumber;
        return output;
    }
}