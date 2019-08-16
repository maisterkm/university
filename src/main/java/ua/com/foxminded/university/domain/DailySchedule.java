package ua.com.foxminded.university.domain;

import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.university.domain.entity.Lesson;

public class DailySchedule {
    private int dailyScheduleId;
    private int monthlyScheduleId;
    private int scheduleId;
    private String description;
    private List<Lesson> listsOfClasses = new ArrayList<Lesson>();

    public DailySchedule() {
    }

    public int getDailyScheduleId() {
        return dailyScheduleId;
    }

    public void setDailyScheduleId(int dailyScheduleId) {
        this.dailyScheduleId = dailyScheduleId;
    }

    public int getMonthlyScheduleId() {
        return monthlyScheduleId;
    }

    public void setMonthlyScheduleId(int monthlyScheduleId) {
        this.monthlyScheduleId = monthlyScheduleId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
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
        String output = "class name: " + this.getClass().getSimpleName() + ", dailySchedule_id: " + dailyScheduleId
                + ", monthlySchedule_id: " + monthlyScheduleId + ", schedule_id: " + scheduleId + ", description: "
                + description;
        return output;
    }
}
