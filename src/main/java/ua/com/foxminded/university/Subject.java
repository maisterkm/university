package ua.com.foxminded.university;

public class Subject {
    private Subjects subject;
    private String description;
    private Teacher teacher;

    public Subject(Subjects subject, Teacher teacher, String description) {
        this.subject = subject;
        this.teacher = teacher;
        this.description = description;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        String output = "class name: " + this.getClass().getSimpleName() + ", subject: " + subject + ", teacher: "
                + teacher + ", description: " + description;
        return output;
    }

}
