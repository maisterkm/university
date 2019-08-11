package ua.com.foxminded.university.domain;

import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.university.domain.entity.Lesson;

public class DailySchedule {
    private int dailySchedule_id;
    private int monthlySchedule_id;
    private int schedule_id;
    private String description;
    private List<Lesson> listsOfClasses = new ArrayList<Lesson>();

    public DailySchedule() {
    }

    public int getDailySchedule_id() {
        return dailySchedule_id;
    }

    public void setDailySchedule_id(int dailySchedule_id) {
        this.dailySchedule_id = dailySchedule_id;
    }

    public int getMonthlySchedule_id() {
        return monthlySchedule_id;
    }

    public void setMonthlySchedule_id(int monthlySchedule_id) {
        this.monthlySchedule_id = monthlySchedule_id;
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

    public List<Lesson> getListsOfClasses() {
        return listsOfClasses;
    }

    @Override
    public String toString() {
        String output = "class name: " + this.getClass().getSimpleName() + ", dailySchedule_id: " + dailySchedule_id
                + ", monthlySchedule_id: " + monthlySchedule_id + ", schedule_id: " + schedule_id + ", description: "
                + description;
        return output;
    }
}
