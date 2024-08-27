package CricBuzz.entity;

public class BattingScoreCard implements ScoreCard{

    private int totalRuns;
    private int totalBalls;
    private int total4s;
    private int total6s;
    private int strikeRate;
    private Wicket wicket;

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public int getTotalBalls() {
        return totalBalls;
    }

    public void setTotalBalls(int totalBalls) {
        this.totalBalls = totalBalls;
    }

    public int getTotal4s() {
        return total4s;
    }

    public void setTotal4s(int total4s) {
        this.total4s = total4s;
    }

    public int getTotal6s() {
        return total6s;
    }

    public void setTotal6s(int total6s) {
        this.total6s = total6s;
    }

    public int getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(int strikeRate) {
        this.strikeRate = strikeRate;
    }

    public Wicket getWicket() {
        return wicket;
    }

    public void setWicket(Wicket wicket) {
        this.wicket = wicket;
    }
}
