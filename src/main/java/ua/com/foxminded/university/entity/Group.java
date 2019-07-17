package ua.com.foxminded.university.entity;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String groupNumber;
    private Faculties faculty;
    private List<Student> studentList = new ArrayList<Student>();

    public Group(String groupNumber, Faculties faculty) {
        this.groupNumber = groupNumber;
        this.faculty = faculty;
    }
    
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public void addStudent(Student student) {
        studentList.add(student);
        student.setGroup(this);
    }

    public void removeStudent(Student student) {
        studentList.remove(student);
    }

    public String displayGroup() {
        String output = "";
        output += "class name: " + this.getClass().getSimpleName() + ", group number: " + groupNumber
                + ", faculty: " + faculty + "\n\tlist of students:";
        int i = 0;
        for (Student item : studentList) {
            output += "\t" + Integer.toString(++i) + ": " + item;
        }
        System.out.println(output);
        return output;
    }

}
