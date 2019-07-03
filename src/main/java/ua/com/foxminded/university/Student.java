package ua.com.foxminded.university;

import java.util.Date;

public class Student extends Person{

    private Group group;
    private int matriculationNumber;
    private Schedule studentSchedule;
    
    public Student(int id, String firstName, String lastName, Date dateOfBirth, Date enrollmentDate, 
                Group group, int matriculationNumber) {
        super(id, firstName, lastName, dateOfBirth, enrollmentDate);
        
        this.group = group;
        this.matriculationNumber = matriculationNumber;
    }
    
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getMatriculationNumber() {
        return matriculationNumber;
    }

    public void setMatriculationNumber(int matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }
    
    public Schedule getStudentSchedule() {
        return studentSchedule;
    }

    public void setStudentSchedule(Schedule studentSchedule) {
        this.studentSchedule = studentSchedule;
    }
   
}
