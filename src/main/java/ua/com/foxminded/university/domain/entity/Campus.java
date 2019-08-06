package ua.com.foxminded.university.domain.entity;

public class Campus {
    private int campus_id;
    private String campus;

    public Campus() {}
    public Campus(int campus_id, String campus) {
        this.campus_id = campus_id;
        this.campus = campus;
    }
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
