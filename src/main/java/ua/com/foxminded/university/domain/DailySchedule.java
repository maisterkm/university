package ua.com.foxminded.university.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ua.com.foxminded.university.domain.entity.Class;

public class DailySchedule {
    private List<Class> listsOfClasses = new ArrayList<Class>();

    public List<Class> getListsOfClasses() {
        return listsOfClasses;
    }

    public void addClass(Class clas) {
        listsOfClasses.add(clas);
    }

    public void removeClass(Class clas) {
        listsOfClasses.remove(clas);
    }

    public String displayDay() {
        String output = "";
        if (!listsOfClasses.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE, d MMMM");
            output += sdf.format(listsOfClasses.get(0).getBeginTime().getTime());
            for (Class item : listsOfClasses) {
                output += item.displayClass();
            }
        }
        return output;
    }
}
