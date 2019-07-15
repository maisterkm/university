package ua.com.foxminded.university;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class Schedule {
    private List<MonthlySchedule> listOfMonthlySchedule = new ArrayList<MonthlySchedule>();
    
    public Schedule() {
        for(int i = 0; i < 12; i++) {
            listOfMonthlySchedule.add(new MonthlySchedule());
        }
    }

    public List<MonthlySchedule> getListOfMonthlySchedule() {
        return listOfMonthlySchedule;
    }

    public void setListOfMonthlySchedule(List<MonthlySchedule> listOfMonthlySchedule) {
        this.listOfMonthlySchedule = listOfMonthlySchedule;
    }
    
    public void addClass(Class c) {
        int month = c.getBeginTime().get(Calendar.MONTH);
        int day = c.getBeginTime().get(Calendar.DAY_OF_MONTH)-1;
        listOfMonthlySchedule.get(month).getListOfDailySchedule().get(day).getListsOfClasses().add(c);
        Collections.sort(listOfMonthlySchedule.get(month).getListOfDailySchedule().get(day).getListsOfClasses());
    }
    
    public void removeClass(Class c) {
        int month = c.getBeginTime().get(Calendar.MONTH);
        int day = c.getBeginTime().get(Calendar.DAY_OF_MONTH);
        listOfMonthlySchedule.get(month).listOfDailySchedule.get(day-1).removeClass(c);
    }
    
    public void displayMonth(int month) {
        System.out.println("\n---------- Display Month ----------");
        listOfMonthlySchedule.get(month-1).displayMonthlySchedule();
    }
    
    public void displayDay(int month, int day) {
        System.out.println("\n---------- Display Day ----------");
        listOfMonthlySchedule.get(month-1).listOfDailySchedule.get(day-1).displayDay();
    }
}