package ua.com.foxminded.university.domain.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import ua.com.foxminded.university.domain.DailySchedule;
import ua.com.foxminded.university.domain.MonthlySchedule;
import ua.com.foxminded.university.domain.Schedule;

public class Lesson implements Comparable<Lesson> {
    private int lesson_id;
    private Schedule schedule;
    private MonthlySchedule monthlySchedule;
    private DailySchedule dailySchedule;
    private Classroom classroom;
    private Subject subject;
    private Calendar beginTime = new GregorianCalendar();
    private Calendar endTime = new GregorianCalendar();
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd-MM-yyyy");

    public Lesson() {
    }

    public Lesson(int lesson_id, Classroom classroom, Subject subject, int beginHour, int beginMin, int beginDay,
            int beginMonth, int beginYear, int endHour, int endMin, int endDay, int endMonth, int endYear) {
        this.lesson_id = lesson_id;
        this.classroom = classroom;
        this.subject = subject;
        beginTime.set(Calendar.HOUR_OF_DAY, beginHour);
        beginTime.set(Calendar.MINUTE, beginMin);
        beginTime.set(Calendar.DAY_OF_MONTH, beginDay);
        beginTime.set(Calendar.MONTH, beginMonth - 1);
        beginTime.set(Calendar.YEAR, beginYear);
        endTime.set(Calendar.HOUR_OF_DAY, endHour);
        endTime.set(Calendar.MINUTE, endMin);
        endTime.set(Calendar.DAY_OF_MONTH, endDay);
        endTime.set(Calendar.MONTH, endMonth - 1);
        endTime.set(Calendar.YEAR, endYear);
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    public int getCampus_id() {
        return classroom.getCampus().getCampus_id();
    }

    public void setCampus_id(int campus_id) {
        classroom.getCampus().setCampus_id(campus_id);
    }

    public String getRoomnumber() {
        return classroom.getRoomNumber();
    }

    public void setRoomnumber(String roomnumber) {
        classroom.setRoomNumber(roomnumber);
    }

    public int getSubject_id() {
        return subject.getSubject_id();
    }

    public void setSubject_id(int subject_id) {
        subject.setSubject_id(subject_id);
    }

    public int getDailyschedule_id() {
        return dailySchedule.getDailySchedule_id();
    }

    public void setDailyschedule_id(int dailyschedule_id) {
        dailySchedule.setDailySchedule_id(dailyschedule_id);
    }

    public int getMonthlyschedule_id() {
        return monthlySchedule.getMonthlySchedule_id();
    }

    public void setMonthlyschedule_id(int monthlyschedule_id) {
        monthlySchedule.setMonthlySchedule_id(monthlyschedule_id);
    }

    public int getSchedule_id() {
        return schedule.getSchedule_id();
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule.setSchedule_id(schedule_id);
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public MonthlySchedule getMonthlySchedule() {
        return monthlySchedule;
    }

    public void setMonthlySchedule(MonthlySchedule monthlySchedule) {
        this.monthlySchedule = monthlySchedule;
    }

    public DailySchedule getDailySchedule() {
        return dailySchedule;
    }

    public void setDailySchedule(DailySchedule dailySchedule) {
        this.dailySchedule = dailySchedule;
    }

    public Calendar getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Calendar beginTime) {
        this.beginTime = beginTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public String displayClass() {
        String output = "class name: " + this.getClass().getSimpleName() + ", lesson_id: " + lesson_id + ", campus_id: "
                + getCampus_id() + ", roomnumber: " + getRoomnumber() + ", begin time: "
                + sdf.format(beginTime.getTime()) + ", end time: " + sdf.format(endTime.getTime()) + ", subject: "
                + subject.getSubject() + ", classroom: " + classroom.getRoomNumber();
        return output;
    }

    public int compareTo(Lesson o) {
        return this.beginTime.getTime().compareTo(o.beginTime.getTime());
    }
}
