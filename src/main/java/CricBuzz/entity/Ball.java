package CricBuzz.entity;

import CricBuzz.observer.BattingScoreCardObserver;
import CricBuzz.observer.BowlingScoreCardObserver;
import CricBuzz.observer.ScoreUpdaterObserver;

import java.util.ArrayList;
import java.util.List;

public class Ball {

    private int ballNo;
    private BallType ballType;
    private RunType runType;
    private Player playedBy;
    private Player bowledBy;
    private boolean isWicketTaken;
    private Wicket wicket;

    private List<ScoreUpdaterObserver> scoreCardObservers;

    public Ball(int ballNo) {
        this.ballNo = ballNo;
        this.scoreCardObservers = new ArrayList<>();
        scoreCardObservers.add(new BattingScoreCardObserver());
        scoreCardObservers.add(new BowlingScoreCardObserver());
    }

    public int getBallNo() {
        return ballNo;
    }

    public void setBallNo(int ballNo) {
        this.ballNo = ballNo;
    }

    public BallType getBallType() {
        return ballType;
    }

    public void setBallType(BallType ballType) {
        this.ballType = ballType;
    }

    public RunType getRunType() {
        return runType;
    }

    public void setRunType(RunType runType) {
        this.runType = runType;
    }

    public Player getPlayedBy() {
        return playedBy;
    }

    public void setPlayedBy(Player playedBy) {
        this.playedBy = playedBy;
    }

    public Player getBowledBy() {
        return bowledBy;
    }

    public void setBowledBy(Player bowledBy) {
        this.bowledBy = bowledBy;
    }

    public List<ScoreUpdaterObserver> getScoreCardObservers() {
        return scoreCardObservers;
    }

    public void setScoreCardObservers(List<ScoreUpdaterObserver> scoreCardObservers) {
        this.scoreCardObservers = scoreCardObservers;
    }

    public boolean getWicketTaken(){
        return isWicketTaken;
    }

    public void setWicketTaken(boolean wicketTaken) {
        isWicketTaken = wicketTaken;
    }

    public Wicket getWicket() {
        return wicket;
    }

    public void setWicket(Wicket wicket) {
        this.wicket = wicket;
    }

    public void startBallDelivery(Team battingTeam, Team bowlingTeam, Over over) {
        this.playedBy = battingTeam.getBattingController().getStriker();
        if(playedBy == null)
            return;
        this.bowledBy = bowlingTeam.getBowlingController().getCurrentBowler();

        ballType = BallType.LEGIT;

        int run = 0;

        if(isWicketTaken()){
            runType = RunType.ZERO;
            this.wicket = new Wicket(WicketType.BOWLED, bowledBy, over, this);
            this.setWicketTaken(true);
            battingTeam.getBattingController().setStriker(null);
            battingTeam.getBattingController().nextBatter();
        }else{
            runType = getRunTypeAlgo();
            if(RunType.SINGLE == runType){
                run = 1;
            }else if(RunType.DOUBLE == runType){
                run = 2;
            }else if(RunType.TRIPLE == runType){
                run = 3;
            }else if(RunType.FOUR == runType){
                run = 4;
            } else if (RunType.SIX == runType) {
                run = 6;
            }

            if(runType == RunType.SINGLE || runType == RunType.TRIPLE){
                Player swap = playedBy;
                battingTeam.getBattingController().setStriker(battingTeam.getBattingController().getNonStriker());
                battingTeam.getBattingController().setNonStriker(swap);
            }
        }

        battingTeam.setTotalRun(battingTeam.getTotalRun() + run);

        notifyObservers(this);
    }

    public void notifyObservers(Ball ball){
        for(ScoreUpdaterObserver scoreUpdaterObserver : ball.getScoreCardObservers()){
            scoreUpdaterObserver.update(ball);
        }
    }

    private RunType getRunTypeAlgo() {
        double val = Math.random();
        if(val < 0.2){
            return RunType.SINGLE;
        }else if(val >= 0.3 && val <= 0.5){
            return RunType.DOUBLE;
        }else if(val >= 0.6 && val <= 0.8){
            return RunType.FOUR;
        }else{
            return RunType.SIX;
        }

    }
    private boolean isWicketTaken() {
        if(Math.random() < 0.2)
            return true;
        else
            return false;
    }
}
