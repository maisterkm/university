package ua.com.foxminded.university.domain.entity;

//public enum Position {
//    PROFESSOR, ASSOCIATE_PROFESSOR, ASSISTANT_PROFESSOR, LECTURER
//}

public class Position {
    private int position_id;
    private String position;

    public Position() {
    }

    public Position(int position_id, String position) {
        this.position_id = position_id;
        this.position = position;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        String output = "class name: " + this.getClass().getSimpleName() + ", position_id: " + position_id
                + ", position:" + position;
        return output;
    }
}
