package ua.com.foxminded.university;

import java.util.Date;

public class Class {

    private Classroom classroom;
    private Teacher teacher;
    private Subject subject;
    private Date beginTime;
    private Date endTime;
    
    public Class(Classroom classroom, Teacher teacher, Subject subject, Date beginTime, Date endTime) {
        
        this.classroom = classroom;
        this.teacher = teacher;
        this.subject = subject;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }
    
    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
     
}
