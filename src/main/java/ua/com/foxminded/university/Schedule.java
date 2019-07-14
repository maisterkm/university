package ua.com.foxminded.university;

import java.util.ArrayList;
import java.util.Calendar;
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
    
    public void removeClass(Class c) {
        for(int i = 0; i < listOfMonthlySchedule.size(); i++) {
            List<DailySchedule> listOfDailySchedule = listOfMonthlySchedule.get(i).getListOfDailySchedule();
            for(int j  = 0; j < listOfDailySchedule.size(); j++) {
                for(Class item : listOfDailySchedule.get(j).getListsOfClasses()) {
                    if(c == item) {
                        listOfDailySchedule.get(j).removeClass(c);
                    }
                }
            }
        }
    }

    //////////////////////////////////////////*****************************////////////////////////////////////////
    public void addClass(Class c) {
        int month = c.getBeginTime().get(Calendar.MONTH);
        int day = c.getBeginTime().get(Calendar.DAY_OF_MONTH) - 1;
        
        listOfMonthlySchedule.get(month).getListOfDailySchedule().get(day).getListsOfClasses().add(c);
        
    }
    
    ///////////////////////////////////////////////////
    public void rmoveClass(Class c) {
        int month = c.getBeginTime().get(Calendar.MONTH);
        int day = c.getBeginTime().get(Calendar.DAY_OF_MONTH);
        
        listOfMonthlySchedule.get(month).listOfDailySchedule.get(day).removeClass(c);
    }
    
    public void displayMonth(int month) {
        System.out.println("\n----- Display Month -----");
        listOfMonthlySchedule.get(month-1).display();
    }
    
//    public void displayDay(int month, int day) {
//        listOfMonthlySchedule.get(month).listOfDailySchedule.get(day).display();
//    }
}