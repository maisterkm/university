package ua.com.foxminded.university;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MonthlySchedule {
    public List<DailySchedule> listOfDailySchedule = new ArrayList<DailySchedule>(); 
    
    public MonthlySchedule() {
        for(int i = 0; i < 31; i++) {
            listOfDailySchedule.add(new DailySchedule());
        }
    }

//    public void addDayToMonthlySchedule(DailySchedule ds) {
//        if(ds.getListsOfClasses().size() != 0) {
//            if(listOfDailySchedule.size() != 0 && 
//                    ds.getListsOfClasses().get(0).getBeginTime().get(Calendar.MONTH) == listOfDailySchedule.get(0).getListsOfClasses().get(0).getBeginTime().get(Calendar.MONTH) && 
//                    ds.getListsOfClasses().get(0).getBeginTime().get(Calendar.YEAR) == listOfDailySchedule.get(0).getListsOfClasses().get(0).getBeginTime().get(Calendar.YEAR)) {
//                listOfDailySchedule.add(ds);
//            } else if(listOfDailySchedule.size() == 0) {
//                listOfDailySchedule.add(ds);
//            }
//        }
//    }
    
    public List<DailySchedule> getListOfDailySchedule() {
        return listOfDailySchedule;
    }
    
    public int getNumberOfMonth() {
        int numberOfMonth = -1;
        if(listOfDailySchedule.size() != 0) {
            numberOfMonth = listOfDailySchedule.get(0).getListsOfClasses().get(0).getBeginTime().get(Calendar.MONTH);
        }
        return numberOfMonth;
    }

    public void displayMonth() {
        for(DailySchedule item : listOfDailySchedule) {
            item.displayDay();
        }
    }
    
}
