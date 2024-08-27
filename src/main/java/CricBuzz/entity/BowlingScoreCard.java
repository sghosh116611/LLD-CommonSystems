package CricBuzz.entity;

public class BowlingScoreCard implements ScoreCard{

    private int totalOversBowled;
    private int totalRunsGiven;
    private int wicketsTaken;
    private int noBallsBowled;
    private int wideBallsBowled;
    private double economyRate;

    public int getTotalOversBowled() {
        return totalOversBowled;
    }

    public void setTotalOversBowled(int totalOversBowled) {
        this.totalOversBowled = totalOversBowled;
    }

    public int getTotalRunsGiven() {
        return totalRunsGiven;
    }

    public void setTotalRunsGiven(int totalRunsGiven) {
        this.totalRunsGiven = totalRunsGiven;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public void setWicketsTaken(int wicketsTaken) {
        this.wicketsTaken = wicketsTaken;
    }

    public int getNoBallsBowled() {
        return noBallsBowled;
    }

    public void setNoBallsBowled(int noBallsBowled) {
        this.noBallsBowled = noBallsBowled;
    }

    public int getWideBallsBowled() {
        return wideBallsBowled;
    }

    public void setWideBallsBowled(int wideBallsBowled) {
        this.wideBallsBowled = wideBallsBowled;
    }

    public double getEconomyRate() {
        return economyRate;
    }

    public void setEconomyRate(double economyRate) {
        this.economyRate = economyRate;
    }
}
