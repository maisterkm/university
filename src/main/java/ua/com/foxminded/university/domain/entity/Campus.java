package ua.com.foxminded.university.domain.entity;

public class Campus {
    private int campus_id;
    private String campus;

    public int getCampus_id() {
        return campus_id;
    }

    public void setCampus_id(int id) {
        this.campus_id = id;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

}
