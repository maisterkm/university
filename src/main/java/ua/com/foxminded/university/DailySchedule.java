package ua.com.foxminded.university;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DailySchedule {
    private List<Class> listsOfClasses = new ArrayList<Class>();
    
    public List<Class> getListsOfClasses() {
        return listsOfClasses;
    }

    public void setListsOfClasses(List<Class> listsOfClasses) {
        this.listsOfClasses = listsOfClasses;
    }
    
    public void addClass(Class clas) {
            listsOfClasses.add(clas);
    }

    public void removeClass(Class clas) {
        int month = clas.getBeginTime().get(Calendar.MONTH);
        int day = clas.getBeginTime().get(Calendar.DAY_OF_MONTH);
        System.out.println("Remove day " + day + " month " + month);
        listsOfClasses.remove(clas);
    }
    
    public void displayDay() {
        if(!listsOfClasses.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE, d MMMM");
            System.out.println(sdf.format(listsOfClasses.get(0).getBeginTime().getTime()));
                for(Class item : listsOfClasses) {
                    item.displayClass();
                }
        }
    }
}
