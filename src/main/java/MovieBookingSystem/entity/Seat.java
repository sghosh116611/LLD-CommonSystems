package MovieBookingSystem.entity;

public class Seat {
    private int id;
    private int row;
    private SeatType Type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public SeatType getType() {
        return Type;
    }

    public void setType(SeatType type) {
        Type = type;
    }
}
