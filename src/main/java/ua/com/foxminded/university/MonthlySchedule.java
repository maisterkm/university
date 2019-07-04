package ua.com.foxminded.university;

import java.util.ArrayList;
import java.util.List;

public class MonthlySchedule {
    public List<DailySchedule> listOfDailySchedule = new ArrayList<DailySchedule>(); 
    
    public List<DailySchedule> getListOfDailyShedule() {
        return listOfDailySchedule;
    }

    public void setListOfDailyShedule(List<DailySchedule> listOfDailyShedule) {
        this.listOfDailySchedule = listOfDailyShedule;
    }
    
    public void display() {
        for(DailySchedule item : listOfDailySchedule) {
            item.display();
        }
    }
    
}
