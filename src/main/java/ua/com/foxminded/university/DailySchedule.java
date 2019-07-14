package ua.com.foxminded.university;

import java.util.ArrayList;
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
        listsOfClasses.remove(clas);
    }
    
    public void display() {
        for(Class item : listsOfClasses) {
            item.display();
        }
    }
    
    public void display(Class c) {
        for(Class item : listsOfClasses) {
            if(item == c) {
                item.display();
            }
        }
    }
}
