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

    @Override
    public String toString() {
        String strPosition = position == null ? "There is no position" : position.toString();
        String strSchedule = teacherSchedule == null ? "There is no schedule" : teacherSchedule.toString();
        String output = super.toString() + ", position: " + strPosition + ", salary: " + salary + " teacherSchedule: "
                + strSchedule;
        return output;
    }

}
