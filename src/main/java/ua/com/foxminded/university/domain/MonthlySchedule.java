package ua.com.foxminded.university.domain;

import java.util.ArrayList;
import java.util.List;

public class MonthlySchedule {
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
}
