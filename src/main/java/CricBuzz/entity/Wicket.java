package CricBuzz.entity;

public class Wicket {

    private WicketType wicketType;
    private Player takenBy;
    private Over over;
    private Ball ball;

    public Wicket(WicketType wicketType, Player takenBy, Over over, Ball ball) {
        this.wicketType = wicketType;
        this.takenBy = takenBy;
        this.over = over;
        this.ball = ball;
    }

    public WicketType getWicketType() {
        return wicketType;
    }

    public void setWicketType(WicketType wicketType) {
        this.wicketType = wicketType;
    }

    public Player getTakenBy() {
        return takenBy;
    }

    public void setTakenBy(Player takenBy) {
        this.takenBy = takenBy;
    }

    public Over getOver() {
        return over;
    }

    public void setOver(Over over) {
        this.over = over;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }
}
