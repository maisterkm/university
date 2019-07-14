 package ua.com.foxminded.university;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Class {
    private Classroom classroom;
    private Teacher teacher;
    private Subject subject;
//    private int beginHour;
//    private int beginMin;
//    private int beginDay;
//    private int beginMonth;
//    private int beginYear;
//    private int endHour;
//    private int endMin;
//    private int endDay;
//    private int endMonth;
//    private int endYear;
    private Calendar beginTime = new GregorianCalendar();
    private Calendar endTime = new GregorianCalendar();
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd-MM-yyyy");
    
    public Class(Classroom classroom, Teacher teacher, Subject subject, int beginHour, int beginMin, int beginDay, int beginMonth, int beginYear,
             int endHour, int endMin, int endDay, int endMonth, int endYear) {
        this.classroom = classroom;
        this.teacher = teacher;
        this.subject = subject;
        beginTime.set(Calendar.HOUR, beginHour);
        beginTime.set(Calendar.MINUTE, beginMin);
        beginTime.set(Calendar.DAY_OF_MONTH, beginDay);
        beginTime.set(Calendar.MONTH, beginMonth-1);
        beginTime.set(Calendar.YEAR, beginYear);
        endTime.set(Calendar.HOUR, endHour);
        endTime.set(Calendar.MINUTE, endMin);
        endTime.set(Calendar.DAY_OF_MONTH, endDay);
        endTime.set(Calendar.MONTH, endMonth-1);
        endTime.set(Calendar.YEAR, endYear);
        
    }
    
    public Calendar getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Calendar beginTime) {
        this.beginTime = beginTime;
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
    
    public void display() {
        System.out.println("class name: " + this.getClass().getSimpleName() + ", begin time: " + sdf.format(beginTime.getTime()) + ", end time: " + sdf.format(endTime.getTime()) + 
                        ", subject: " + subject.getSubject() + ", classroom: " + classroom.getRoomNumber() + 
                        ", teacher: " + teacher.getFirstName() + " " + teacher.getLastName());
    }
     
}


