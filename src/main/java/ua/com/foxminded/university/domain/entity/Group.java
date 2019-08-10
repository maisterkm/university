package ua.com.foxminded.university.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private int group_id;
    private String groupNumber;
    private Faculties faculty;
    private List<Student> studentList = new ArrayList<Student>();

    public Group() {
    }

    public Group(int group_id, String groupNumber, Faculties faculty) {
        this.group_id = group_id;
        this.groupNumber = groupNumber;
        this.faculty = faculty;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
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

    public int getFaculty_id() {
        return faculty.getFaculty_id();
    }

    public void setFaculty_id(int faculty_id) {
        this.faculty.setFaculty_id(faculty_id);
    }

    public Faculties getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
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
        output += "class name: " + this.getClass().getSimpleName() + ", group_id: " + group_id + ", group number: "
                + groupNumber + ", faculty: " + faculty.getFaculty() + "\n\tlist of students:";
        int i = 0;
        for (Student item : studentList) {
            output += "\t" + Integer.toString(++i) + ": " + item;
        }
        return output;
    }

}
