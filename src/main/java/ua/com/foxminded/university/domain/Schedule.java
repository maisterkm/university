package ua.com.foxminded.university.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import ua.com.foxminded.university.domain.entity.Lesson;

public class Schedule {
    private int schedule_id;
    private String description;
    private List<MonthlySchedule> listOfMonthlySchedule = new ArrayList<MonthlySchedule>();
    static final int NUMBER_OF_MONTH_IN_YEAR = 12;

    public Schedule() {
        for (int i = 0; i < NUMBER_OF_MONTH_IN_YEAR; i++) {
            listOfMonthlySchedule.add(new MonthlySchedule());
        }
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addClass(Lesson c) {
        int month = c.getBeginTime().get(Calendar.MONTH);
        int day = c.getBeginTime().get(Calendar.DAY_OF_MONTH) - 1;
        listOfMonthlySchedule.get(month).getListOfDailySchedule().get(day).getListsOfClasses().add(c);
        Collections.sort(listOfMonthlySchedule.get(month).getListOfDailySchedule().get(day).getListsOfClasses());
    }

    public void removeClass(Lesson c) {
        int month = c.getBeginTime().get(Calendar.MONTH);
        int day = c.getBeginTime().get(Calendar.DAY_OF_MONTH);
        listOfMonthlySchedule.get(month).listOfDailySchedule.get(day - 1).removeClass(c);
    }

    public void displayMonth(int month) {
        listOfMonthlySchedule.get(month - 1).displayMonthlySchedule();
    }

    public void displayDay(int month, int day) {
        listOfMonthlySchedule.get(month - 1).listOfDailySchedule.get(day - 1).displayDay();
    }

    @Override
    public String toString() {
        String output = "class name: " + this.getClass().getSimpleName() + ", schedule_id: " + schedule_id
                + ", description: " + description;
        return output;
    }

}