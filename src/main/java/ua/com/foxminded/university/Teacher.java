package ua.com.foxminded.university;

public class Teacher extends Person{

    private Position position;
    private int salary;
    private Schedule teacherSchedule;
    
    public Teacher(int id, String firstName, String lastName, int birthDay, int birthMonth, int birthYear,
            int enrollmentDay, int enrollmentMonth, int enrollmentYear, Position position, int salary) {
        super(id, firstName, lastName, birthDay, birthMonth, birthYear, enrollmentDay, enrollmentMonth, enrollmentYear);
        
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
    
    @Override
    public String toString() {
        String output = super.toString() + ", position: " + position + ", salary: " +  salary;
        return output;
    }
   
}
