package ua.com.foxminded.university;

public class Student extends Person{

    private Group group;
    
    private Schedule studentSchedule;
    
    public Student(int id, String firstName, String lastName, int birthDay, int birthMonth, int birthYear,
            int enrollmentDay, int enrollmentMonth, int enrollmentYear) {
        super(id, firstName, lastName, birthDay, birthMonth, birthYear, enrollmentDay, enrollmentMonth, enrollmentYear);
        group = null;
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
   
    @Override
    public String toString() {
        String output = super.toString() +  
                ", group: " + (group == null ? "there is no group yet" : group.getGroupNumber());
        return output;
    }
}