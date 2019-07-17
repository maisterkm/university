package ua.com.foxminded.university.domain;

import java.util.ArrayList;
import java.util.List;

public class MonthlySchedule {
    public List<DailySchedule> listOfDailySchedule = new ArrayList<DailySchedule>();

    public MonthlySchedule() {
        for (int i = 0; i < 31; i++) {
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
}
