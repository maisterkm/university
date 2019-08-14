package ua.com.foxminded.university.domain;

import java.util.ArrayList;
import java.util.List;

public class MonthlySchedule {
    private int monthlyScheduleId;
    private int scheduleId;
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

    @Override
    public String toString() {
        String output = "class name: " + this.getClass().getSimpleName() + ", monthlySchedule_id: " + monthlyScheduleId
                + ", schedule_id: " + scheduleId + ", description: " + description;
        return output;
    }
}
