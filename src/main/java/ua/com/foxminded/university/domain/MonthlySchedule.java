package ua.com.foxminded.university.domain;

import java.util.ArrayList;
import java.util.List;

public class MonthlySchedule {
    private int monthlySchedule_id;
    private int schedule_id;
    private String description;
    public List<DailySchedule> listOfDailySchedule = new ArrayList<DailySchedule>();
    static final int NUMBER_OF_DAY_IN_MONTH = 31;

    public MonthlySchedule() {
        for (int i = 0; i < NUMBER_OF_DAY_IN_MONTH; i++) {
            listOfDailySchedule.add(new DailySchedule());
        }
    }

    public List<DailySchedule> getListOfDailySchedule() {
        return listOfDailySchedule;
    }

    public void displayMonthlySchedule() {
        for (DailySchedule item : listOfDailySchedule) {
            item.displayDay();
        }
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

    @Override
    public String toString() {
        String output = "class name: " + this.getClass().getSimpleName() + ", monthlySchedule_id: " + monthlySchedule_id
                + ", schedule_id: " + schedule_id + ", description: " + description;
        return output;
    }
}
