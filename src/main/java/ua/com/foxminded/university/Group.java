package ua.com.foxminded.university;

import java.util.List;

public class Group {
    
    private String groupNumber;
    private Faculties faculty;
    private List<Student> studentList;
    
    public Group(String groupNumber, Faculties faculty, List<Student> studentList) {
        super();
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
    
    
    
}
