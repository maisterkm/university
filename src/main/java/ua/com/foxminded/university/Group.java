package ua.com.foxminded.university;

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

    public Group(String groupNumber, Faculties faculty, List<Student> studentList) {
        this.groupNumber = groupNumber;
        this.faculty = faculty;
        this.studentList = studentList;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Faculties getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(Student student) {
        studentList.add(student);
        student.setGroup(this);
    }

    public void removeStudent(Student student) {
        studentList.remove(student);
    }

    public void display() {
        System.out.println("class name: " + this.getClass().getSimpleName() + ", group number: " + groupNumber
                + ", faculty: " + faculty + "\n\tlist of students:");
        int i = 0;
        for (Student item : studentList) {
            System.out.println("\t" + Integer.toString(++i) + ": " + item);
        }
    }

}
