package ua.com.foxminded.university.domain.entity;

//public enum Faculties {
//    FACULTY_OF_MATHEMATICS, FACULTY_OF_PHYSICS, FACULTY_OF_COMPUTER_SCIENCE
//}
public class Faculties {
    private int faculty_id;
    private String faculty;
    
    public Faculties() {}
    public Faculties(int faculty_id, String faculty) {
        this.faculty_id = faculty_id;
        this.faculty = faculty;
    }
    
    public int getFaculty_id() {
        return faculty_id;
    }
    public void setFaculty_id(int faculty_id) {
        this.faculty_id = faculty_id;
    }
    public String getFaculty() {
        return faculty;
    }
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    
}
