package ua.com.foxminded.university;

import java.util.Date;

public class Teacher extends Person{

    private Position position;
    private int salary;
    private Schedule teacherSchedule;
    
    public Teacher(int id, String firstName, String lastName, Date dateOfBirth, Date enrollmentDate, Position position, int salary) {
        super(id, firstName, lastName, dateOfBirth, enrollmentDate);
        
        this.position = position;
        this.salary = salary;
        
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
   
}
