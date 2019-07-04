package ua.com.foxminded.university;

import java.util.ArrayList;
import java.util.List;

public class DailySchedule {
    private List<Class> listsOfClass = new ArrayList<Class>();

    public List<Class> getListsOfClass() {
        return listsOfClass;
    }

    public void setListsOfClass(List<Class> listsOfClass) {
        this.listsOfClass = listsOfClass;
    }
    
    public void addClass(Class clas) {
        listsOfClass.add(clas);
    }
    
    public void removeClass(Class clas) {
        listsOfClass.remove(clas);
    }
    
    public void display() {
        for(Class item : listsOfClass) {
            item.display();
        }
    }
}
