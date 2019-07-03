package ua.com.foxminded.university;

public class Classroom {

    private Campus campus;
    private int capacity;
    private int roomNumber;
    
    public Classroom(Campus campus, int capacity, int roomNumber) {
        super();
        this.campus = campus;
        this.capacity = capacity;
        this.roomNumber = roomNumber;
    }
    
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

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
     
}
