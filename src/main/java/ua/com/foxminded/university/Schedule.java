package ua.com.foxminded.university;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private List<MonthlySchedule> listOfMonthlySchedule = new ArrayList<MonthlySchedule>();

    public List<MonthlySchedule> getListOfMonthlySchedule() {
        return listOfMonthlySchedule;
    }

    public void setListOfMonthlySchedule(List<MonthlySchedule> listOfMonthlySchedule) {
        this.listOfMonthlySchedule = listOfMonthlySchedule;
    }
    
    public void displayMonthlySchedule(int numberOfMonth) {
        
    }
}
