package ua.com.foxminded.university.domain.entity;

public class Group {
    private int group_id;
    private String groupNumber;
    private Faculties faculty;

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

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public int getFaculty_id() {
        return faculty.getFaculty_id();
    }

    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        String output = "";
        output += "class name: " + this.getClass().getSimpleName() + ", group_id: " + group_id + ", group number: "
                + groupNumber + ", faculty: " + faculty.getFaculty() + "\n\tlist of students:";
        return output;
    }

}
