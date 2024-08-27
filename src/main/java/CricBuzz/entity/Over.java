package CricBuzz.entity;

import java.util.ArrayList;
import java.util.List;

public class Over {

    private int overNo;
    private List<Ball> balls;
    private Player bowledBy;
    private int extraBalls;

    public Over(int overNo, Player bowledBy) {
        this.overNo = overNo;
        this.balls = new ArrayList<>();
        this.bowledBy = bowledBy;
        this.extraBalls = 0;
    }

    public int getOverNo() {
        return overNo;
    }

    public void setOverNo(int overNo) {
        this.overNo = overNo;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

    public Player getBowledBy() {
        return bowledBy;
    }

    public void setBowledBy(Player bowledBy) {
        this.bowledBy = bowledBy;
    }

    public int getExtraBalls() {
        return extraBalls;
    }

    public void setExtraBalls(int extraBalls) {
        this.extraBalls = extraBalls;
    }

    public boolean start(Team battingTeam, Team bowlingTeam, int runsToWin){
        int ballsBowled = 1;
        while(ballsBowled <= 6){
            Ball ball = new Ball(ballsBowled);
            ball.startBallDelivery(battingTeam, bowlingTeam, this);
            if(ball.getBallType() == BallType.LEGIT){
                balls.add(ball);
                ballsBowled++;
                if(ball.getWicketTaken())
                    battingTeam.getBattingController().nextBatter();

                if(runsToWin != -1 && battingTeam.getTotalRun() >= runsToWin){
                    battingTeam.setWinner(true);
                    return true;
                }
            }else{
                this.extraBalls++;
            }
        }

        return false;
    }
}
