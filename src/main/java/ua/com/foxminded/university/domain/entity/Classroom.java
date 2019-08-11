package ua.com.foxminded.university.domain.entity;

public class Classroom {
    private Campus campus;
    private int capacity;
    private String roomNumber;

//    public Classroom() {}
//    public Classroom(Campus campus, String roomNumber, int capacity) {
//        this.campus = campus;
//        this.roomNumber = roomNumber;
//        this.capacity = capacity;
//    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        String output = "class name: " + this.getClass().getSimpleName() + ", campus: " + campus + ", room number: "
                + roomNumber + ", capacity: " + capacity;
        return output;
    }
}
