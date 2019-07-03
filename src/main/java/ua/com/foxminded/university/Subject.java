package ua.com.foxminded.university;

public class Subject {
    
    private String description;
    private Subjects subject;
    private Teacher teacher;
    
    public Subject(String description, Subjects subject, Teacher teacher) {
        
        this.description = description;
        this.subject = subject;
        this.teacher = teacher;
    }
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Subjects getSubject() {
        return subject;
    }
    public void setSubject(Subjects subject) {
        this.subject = subject;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
     
    
}
