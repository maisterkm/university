package ua.com.foxminded.university.domain.entity;

public class Faculties {
    private int facultyId;
    private String faculty;

    public Faculties() {
    }

    public Faculties(int facultyId, String faculty) {
        this.facultyId = facultyId;
        this.faculty = faculty;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        String output = "class name: " + this.getClass().getSimpleName() + ", faculty_id: " + facultyId + ", facult: "
                + faculty;
        return output;
    }
}
