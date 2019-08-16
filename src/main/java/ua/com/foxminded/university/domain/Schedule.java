package ua.com.foxminded.university.domain;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private int scheduleId;
    private String description;
    private List<MonthlySchedule> listOfMonthlySchedule = new ArrayList<MonthlySchedule>();
    static final int NUMBER_OF_MONTH_IN_YEAR = 12;

    public Schedule() {
        for (int i = 0; i < NUMBER_OF_MONTH_IN_YEAR; i++) {
            listOfMonthlySchedule.add(new MonthlySchedule());
        }
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

    @Override
    public String toString() {
        String output = "class name: " + this.getClass().getSimpleName() + ", schedule_id: " + scheduleId
                + ", description: " + description;
        return output;
    }

}