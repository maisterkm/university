package ua.com.foxminded.university.entity;

public class Classroom {
    private Campus campus;
    private int capacity;
    private int roomNumber;

    public Classroom(Campus campus, int roomNumber, int capacity) {
        this.campus = campus;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        String output = "class name: " + this.getClass().getSimpleName() + ", campus: " + campus + ", room number: "
                + roomNumber + ", capacity: " + capacity;
        return output;
    }
}
