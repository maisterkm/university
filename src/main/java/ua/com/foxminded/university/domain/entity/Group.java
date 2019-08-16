package ua.com.foxminded.university.domain.entity;

public class Group {
    private int groupId;
    private String groupNumber;
    private Faculties faculty;

    public Group() {
    }

    public Group(int groupId, String groupNumber, Faculties faculty) {
        this.groupId = groupId;
        this.groupNumber = groupNumber;
        this.faculty = faculty;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public int getFacultyId() {
        return faculty.getFacultyId();
    }

    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        String output = "";
        output += "class name: " + this.getClass().getSimpleName() + ", group_id: " + groupId + ", group number: "
                + groupNumber + ", faculty: " + faculty.getFaculty() + "\n\tlist of students:";
        return output;
    }

}
