package ua.com.foxminded.university.domain.entity;

public class Campus {
    private int campusId;
    private String campus;

    public Campus() {}
    public Campus(int campusId, String campus) {
        this.campusId = campusId;
        this.campus = campus;
    }
    public int getCampusId() {
        return campusId;
    }

    public void setCampusId(int id) {
        this.campusId = id;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }
    
    @Override
    public String toString() {
        String output = "class name: " + this.getClass().getSimpleName() + " campus_id: " + campusId + ", campus: " + campus;
        return output;
    }

}
