package SnakeAndLadder.entity;

public abstract class Obstacle {

    private Point startingPoint;
    private Point endingPoint;

    Obstacle(Point startingPoint, Point endingPoint){
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
    }

    public Point getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(Point startingPoint) {
        this.startingPoint = startingPoint;
    }

    public Point getEndingPoint() {
        return endingPoint;
    }

    public void setEndingPoint(Point endingPoint) {
        this.endingPoint = endingPoint;
    }
}
