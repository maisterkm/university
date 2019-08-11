package ua.com.foxminded.university.domain;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String toString() {
        String output = "class name: " + this.getClass().getSimpleName() + ", schedule_id: " + schedule_id
                + ", description: " + description;
        return output;
    }

}