package ua.com.foxminded.university.domain.entity;

public class Position {
    private int positionId;
    private String position;

    public Position() {
    }

    public Position(int positionId, String position) {
        this.positionId = positionId;
        this.position = position;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        String output = "class name: " + this.getClass().getSimpleName() + ", position_id: " + positionId
                + ", position:" + position;
        return output;
    }
}
