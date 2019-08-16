package ua.com.foxminded.university.domain.entity;

public class Subject {
    private int subjectId;
    private String subject;

    public Subject() {
    }

    public Subject(int subjectId, String subject) {
        this.subjectId = subjectId;
        this.subject = subject;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        String output = "class name: " + this.getClass().getSimpleName() + " subject_id=" + subjectId + ", subject: "
                + subject;
        return output;
    }

}
